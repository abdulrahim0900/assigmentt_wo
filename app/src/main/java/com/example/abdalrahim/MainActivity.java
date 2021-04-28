package com.example.abdalrahim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abdalrahim.cvpackage.CV;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {


    private RadioGroup rg;
    private RadioButton radioButton;

    private Spinner spinner;


    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String PASS = "PASS";
    public static final String CONTACT = "CONTACT";
    public static final Integer GENDER = 0;
    public static final String LANG = "LANG";
    public static final String FLAG = "FLAG";
    public boolean flag = false;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edt3;
    private EditText edt4;
    private CheckBox chk;
    public SharedPreferences prefs;
    public SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
        setupSharedPrefs();
        checkPrefs();

    }

    private void setupViews(){
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.txt1);
        edtEmail = findViewById(R.id.txt2);

        edt3 = findViewById(R.id.txt3);
        edt4 = findViewById(R.id.txt4);
        rg= (RadioGroup) findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        chk = findViewById(R.id.chk);
    }


    private void setupSharedPrefs(){
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs(){
        flag = prefs.getBoolean(FLAG,false);

        if(flag){

            String name = prefs.getString(NAME,"");
            String email = prefs.getString(EMAIL,"");
            String pass = prefs.getString(PASS,"");
            String contact = prefs.getString(CONTACT,"");
            int gender = prefs.getInt(String.valueOf(GENDER),1);
            String lang = prefs.getString(LANG,"");

            edtName.setText(name);
            edtEmail.setText(email);
            edt3.setText(pass);
            edt4.setText(contact);
            rg.check(gender);

            spinner.setSelection(1);



            chk.setChecked(true);
        }
    }

    public void registerBtn_onclick(View view) {


        Intent intent2 = new Intent(this,MainActivity2.class);

        String name = edtName.getText().toString();
        String password = edtEmail.getText().toString();
        String data3 = edt3.getText().toString();
        String data4 = edt4.getText().toString();

        CV[] cvs = new CV[1];
        cvs[0] = new CV(name, data3);

        Gson gson = new Gson();
        String cvsString = gson.toJson(cvs);

        editor.putString("cvs", cvsString);


        int checked = rg.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(checked);
        int g = radioButton.getId();

        String str = spinner.getSelectedItem().toString();

        if(chk.isChecked()){
            if(!flag) {
                editor.putString(NAME, name);
                editor.putString(EMAIL, password);
                editor.putString(PASS,data3);
                editor.putString(CONTACT,data4);
                editor.putBoolean(FLAG, true);
                editor.putInt(String.valueOf(GENDER),g);
                editor.putString(LANG,str);
                editor.commit();

            }

            Toast.makeText(this, "Data Saved:\n" + cvsString,
                    Toast.LENGTH_SHORT).show();
       // Intent intent = new Intent(this, MainActivity2.class);


//
//        intent.putExtra("EDT1",data1);
//        intent.putExtra("EDT2",data2);
//        intent.putExtra("EDT3",data3);
//        intent.putExtra("EDT4",data4);
//        intent.putExtra("Gender",gender);
//        intent.putExtra("spinner",str);

        startActivity(intent2);

    }
    } }