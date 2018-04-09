package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
    
    EditText name,mobile,alternatenum,emailregister,address,landmark;
    Button register;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = findViewById(R.id.name_et);
        mobile = findViewById(R.id.mobile_et);
        alternatenum = findViewById(R.id.alternate_mob_et);
        emailregister = findViewById(R.id.email_et);
        address = findViewById(R.id.address_et);
        landmark = findViewById(R.id.landmark_et);
        register = findViewById(R.id.register);
    }

    public void showSnackbar(View view, String message, int duration) {
        Snackbar.make(view, message, duration).show();
    }


    public void register(View v)
    {

        if (name.getText().toString().isEmpty())
        {
            name.requestFocus();
            name.setError("");
        }

        else if (mobile.getText().toString().isEmpty())
        {
            mobile.requestFocus();
            mobile.setError("");
        }else if (mobile.length() != 10) {
            showSnackbar(mobile, "Please enter 10 digit mobile number", 4000);

        }
        else if( alternatenum.getText().toString().isEmpty())
        {
            alternatenum.requestFocus();
            alternatenum.setError("");

        }
        else if (emailregister.getText().toString().isEmpty())
        {
            emailregister.requestFocus();
            emailregister.setError("");

        }
        else if (address.getText().toString().isEmpty())
        {
            address.requestFocus();
            address.setError("");

        }
        else if (landmark.getText().toString().isEmpty())
        {
            landmark.requestFocus();
            landmark.setError("");

        }

        else {

            // String usrname = name.getText().toString();
            String username = name.getText().toString();
            String mobilenum = mobile.getText().toString();
            String alternatenumregister = alternatenum.getText().toString();
            String email = emailregister.getText().toString();
            String addressregister = address.getText().toString();
            String landmarkregister = landmark.getText().toString();

            if (email.contains("@") && email.contains(".com")) {

                editor = getSharedPreferences("userdetails", MODE_PRIVATE).edit();
                editor.putString("username", username);
                editor.putString("mobile", mobilenum);
                editor.putString("alternatenum", alternatenumregister);
                editor.putString("emailregister", email);
                editor.putString("address", addressregister);
                editor.putString("landmark", landmarkregister);
                editor.commit();
//            String uname = name.getText().toString().trim();
//            String lastname = mobile.getText().toString().trim();
//            String mail = alternatenum.getText().toString().trim();
//            String mobile = emailregister.getText().toString().trim();
//            String password = address.getText().toString().trim();
//            String cnfrmpasword = landmark.getText().toString().trim();

                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(i);

            }
            else{
                showSnackbar(emailregister, "provide proper email id", 4000);
            }

        }
}
}

