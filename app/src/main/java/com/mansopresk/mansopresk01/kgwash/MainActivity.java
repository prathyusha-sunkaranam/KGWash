package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

public class MainActivity extends Activity {
    EditText email,password,dateview;
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
    public void valid(View v) {
        if (email.getText().toString().trim().isEmpty()) {
            email.requestFocus();
            email.setError("");
        } else if (password.getText().toString().isEmpty()) {
            password.requestFocus();
            password.setError("");
        } else {
            String usrname = email.getText().toString();
            String pswrd = password.getText().toString();

//            sharedpreferences = getSharedPreferences("email",MODE_PRIVATE);
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
    //    }
    public void signup(View v){
        Intent i3 = new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(i3);
    }


}
