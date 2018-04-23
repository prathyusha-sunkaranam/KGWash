package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

public class MainActivity extends Activity {
    EditText email,password,dateview;
    TextView pass;
    Button signin,signup;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String pswrd = "pswrdKey";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = (Button)findViewById(R.id.signup);
        signin = (Button)findViewById(R.id.signin);
        email = (EditText)findViewById(R.id.emailid);
        password = (EditText)findViewById(R.id.password);
        pass=findViewById(R.id.forgotpass);

        sharedPreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
        String uname = sharedPreferences.getString("aemail",null);
        if(uname!=null){
            Intent i=new Intent(this,AdminOrder.class);
            startActivity(i);
        }
        String uname1 = sharedPreferences.getString("deliveryemail",null);
        if(uname1!=null){
            Intent i2=new Intent(this,DeliveryActivity.class);
            startActivity(i2);
        }
    }
    public  void forget(View v){
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        final EditText mail = alertLayout.findViewById(R.id.fmail);
        final Button ok=alertLayout.findViewById(R.id.fok);
        final Button cancel=alertLayout.findViewById(R.id.fcancel);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Forgot Password");
        alert.setView(alertLayout);
         alert.setCancelable(false);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String smail=mail.getText().toString().trim();
                if (smail.contains("@") && smail.contains(".com")) {
                    Intent it = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(it);
                }
                 else if (mail.getText().toString().trim().isEmpty()) {
                    mail.requestFocus();
                    mail.setError("Enter valid Email");
                }
                else {
                        Toast.makeText(MainActivity.this, " enter proper mail id ", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    public void valid(View v) {
        if (email.getText().toString().trim().isEmpty()) {
            email.requestFocus();
            email.setError("please provide email id");
        } else if (password.getText().toString().isEmpty()) {
            password.requestFocus();
            password.setError("please provide password");
        } else {
            String usrname = email.getText().toString();
            String pswrd = password.getText().toString();

             if((usrname.equals("admin")&& pswrd.equals("admin") )||(usrname.equals("delivery")&& pswrd.equals("delivery"))){
                 getApplicationContext().getSharedPreferences("admindetails", 0).edit().clear().apply();
             }
             else{
                 editor = getSharedPreferences("userdetails", MODE_PRIVATE).edit();
                 editor.putString("email", usrname);
                 editor.putString("password", pswrd);
                 editor.commit();
             }
            if (usrname.equals("admin") && pswrd.equals("admin")) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                editor = getSharedPreferences("admindetails", MODE_PRIVATE).edit();
                editor.putString("aemail", usrname);
                editor.putString("apassword", pswrd);
                editor.commit();
                Intent i = new Intent(this, AdminOrder.class);
                startActivity(i);
            }
            else if (usrname.equals("delivery") && pswrd.equals("delivery")){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                editor = getSharedPreferences("admindetails", MODE_PRIVATE).edit();
                editor.putString("deliveryemail", usrname);
                editor.putString("deliverypassword", pswrd);
                editor.commit();
                Intent i2 = new Intent(this, DeliveryActivity.class);
                startActivity(i2);
            }else {
                Intent i = new Intent(MainActivity.this, NavigationMainActivity.class);
                startActivity(i);
            }
        }
    }
    public void signup(View v){
        Intent i3 = new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(i3);
    }
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(this, "back key is pressed", Toast.LENGTH_SHORT).show();
        Intent i3 = new Intent(MainActivity.this,NavigationMainActivity.class);
        startActivity(i3);
    }
}
