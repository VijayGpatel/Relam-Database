package com.realmdatabase;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public List<UserDetail> getUserDetail() {
        return realm.where(UserDetail.class).findAll();
    }

    public void deleteByUserId(String emailId) {
        RealmResults<UserDetail> results = realm.where(UserDetail.class).equalTo("email", emailId).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public void updateUserDetailById(int id, String name, String email, String phone, String city, String state) {
        RealmResults<UserDetail> results = realm.where(UserDetail.class).equalTo("email", email).findAll();

        realm.beginTransaction();

        for (UserDetail userDetail : results) {
            userDetail.setId(id);
            userDetail.setName(name);
            userDetail.setEmail(email);
            userDetail.setPhone(phone);
            userDetail.setCity(city);
            userDetail.setState(state);
        }
        realm.commitTransaction();
    }
}
