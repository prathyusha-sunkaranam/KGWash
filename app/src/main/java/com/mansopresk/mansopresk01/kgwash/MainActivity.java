package com.mansopresk.mansopresk01.kgwash;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText email,password,dateview;
    Button signin,signup;
    ImageView close;


    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String pswrd = "pswrdKey";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = (Button)findViewById(R.id.signup);
        signin = (Button)findViewById(R.id.signin);
        email = (EditText)findViewById(R.id.emailid);
        password = (EditText)findViewById(R.id.password);
        close = (ImageView)findViewById(R.id.close);



        sharedpreferences = getSharedPreferences("userdetails",MODE_PRIVATE);
        String uname = sharedpreferences.getString("email",null);
        if(uname!=null){
            Intent i=new Intent(this,NavigationMainActivity.class);
            startActivity(i);
        }


    }

    public void valid(View v){
        if(email.getText().toString().trim().isEmpty()){
            email.requestFocus();
            email.setError("");
        }
        else if (password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("");
        }
        else {
            String usrname = email.getText().toString();
            String pswrd = password.getText().toString();
//            sharedpreferences = getSharedPreferences("email",MODE_PRIVATE);
            editor = getSharedPreferences("userdetails",MODE_PRIVATE).edit();
            editor.putString("email",usrname);
            editor.putString("password",pswrd);
            editor.commit();
            if(sharedpreferences!=null) {

                Intent i = new Intent(MainActivity.this,NavigationMainActivity.class);
                startActivity(i);
            }
        }}
    public void signup(View v){
        Intent i3 = new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(i3);
    }

    public void close(View v){
        Intent i2 = new Intent(MainActivity.this,NavigationMainActivity.class);
        startActivity(i2);
    }


}
