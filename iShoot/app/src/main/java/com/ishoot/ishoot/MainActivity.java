package com.ishoot.ishoot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "iShootPrefsFile";
    public SharedPreferences settings;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    SwitchToLoginActivity();
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("ifLogin", true);
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };
    private void SwitchToLoginActivity()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(PREFS_NAME, 0);
        boolean ifLogin = settings.getBoolean("ifLogin", false);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (!ifLogin) {
            SwitchToLoginActivity();
        }
    }

}
