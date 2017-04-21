package com.android.xymeng.oncourse1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_calc, btn_jmp;
    EditText edt_wei, edt_hei;
    TextView text_bmi;
    double wei,hei,bmi;
    boolean isFirstWei = true, isFirstHei = true;
    public static final String EXTRA_MESSAGE = "com.android.xymeng.oncourse1.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_calc= (Button) findViewById(R.id.button_calc);
        btn_jmp = (Button) findViewById(R.id.btn_jmp);
        edt_hei= (EditText) findViewById(R.id.editText_height);
        edt_wei= (EditText) findViewById(R.id.editText_weight);
        text_bmi= (TextView) findViewById(R.id.textView_BMI);
        btn_jmp.setOnClickListener( v->{
            Intent newActivity = new Intent(this, HistoryActivity.class);

            startActivity(newActivity);
        });
        edt_hei.setOnClickListener(v->{
            if(isFirstHei){
                edt_hei.setText("");
                isFirstHei = false;
            }
        });
        edt_wei.setOnClickListener(v->{
            if(isFirstWei){
                edt_wei.setText("");
                isFirstWei = false;
            }
        });
        btn_calc.setOnClickListener(v -> {
            wei=Double.valueOf(edt_wei.getText().toString());
            hei=Double.valueOf(edt_hei.getText().toString());
            if(hei <= 0 || wei <= 0){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("ERROR!")
                        .setMessage("The height must be larger than zero!")
                        .show();
                return;
            }
            bmi=wei/hei/hei;
            Intent newActivity = new Intent(this, HistoryActivity.class);
            newActivity.putExtra(EXTRA_MESSAGE,String.valueOf(bmi));
            startActivity(newActivity);
            //text_bmi.setText(String.valueOf(bmi));
        });
    }
}
