package com.ishoot.ishoot.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ishoot.ishoot.R;

public class MyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        toolbar.setTitle("Nickname");
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.ic_myinfo_white);
        getSupportActionBar().setTitle("Nickname");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setBackgroundResource(R.drawable.ic_basketball);
        TextView myInfo = (TextView) findViewById(R.id.myInfo);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null) {
            toolbar.setTitle("Not signed in");
            myInfo.setText("E-Mail:\nCreate Time:");
        }
        else {
            toolbar.setTitle(user.getDisplayName());
            myInfo.setText("E-Mail:" + user.getEmail() + "\nCreate Time:" + user.getPhotoUrl());
        }
        android.support.v7.widget.AppCompatImageButton fab = (android.support.v7.widget.AppCompatImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }
}
