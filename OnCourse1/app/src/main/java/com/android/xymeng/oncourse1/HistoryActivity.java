package com.android.xymeng.oncourse1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView tv = (TextView)findViewById(R.id.textView2);
        tv.setText(msg);
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("PUS","Pause");
    }
}
