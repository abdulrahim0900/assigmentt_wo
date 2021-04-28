package com.example.abdalrahim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static final String TEXT1 = "TEXT1";
    public static final String TEXT2 = "TEXT2";
    public SharedPreferences prefs2;
    public SharedPreferences.Editor editor2;
    public final String FLAG = "FLAG";
    public boolean flag = false;
    private EditText edt1;
    private EditText edt11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        setupViews();
        setupSharedPrefs();
        checkPrefs();

//        String data1 = intent.getStringExtra("EDT1");
//        String data2 = intent.getStringExtra("EDT2");

//        TextView two1 = findViewById(R.id.tx1);
//        TextView two2 = findViewById(R.id.tx2);

//        two1.setText("Your name is: "+data1);
//        two2.setText("Your email is: "+data2);



    }

    private void setupViews(){
        setContentView(R.layout.activity_main2);
        edt1 = findViewById(R.id.txt1);
        edt11 = findViewById(R.id.txt2);

    }

    private void setupSharedPrefs(){
        prefs2= PreferenceManager.getDefaultSharedPreferences(this);
        editor2 = prefs2.edit();
    }


    private void checkPrefs(){

        flag = prefs2.getBoolean(FLAG,false);

        if(!flag) {


            String b = prefs2.getString(TEXT1, "");

            String bb = prefs2.getString(TEXT2, "");


            edt1.setText(b);
            edt11.setText(bb);
        }
        }

    public void registerBtn_onclick(View view) {


        String a = edt1.getText().toString();
        String aa = edt11.getText().toString();


                 editor2.putString(TEXT1, a);
                 editor2.putString(TEXT2, aa);
                 editor2.putBoolean(FLAG, true);
                 editor2.commit();

            }


        }

