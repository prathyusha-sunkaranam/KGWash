package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

    EditText name, mobile, alternatenum, emailregister, address, landmark, pass;
    Button register;
    SharedPreferences.Editor editor;
    String spass;

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

        pass = findViewById(R.id.pass_et);



    }

    public void showSnackbar(View view, String message, int duration) {
        Snackbar.make(view, message, duration).show();
    }


    public void register(View v) {

        if (name.getText().toString().isEmpty()) {
            name.requestFocus();
            name.setError("please provide name");
        } else if (mobile.getText().toString().isEmpty()) {
            mobile.requestFocus();
            mobile.setError("please provide mobile number");
        } else if (mobile.length() != 10) {
            showSnackbar(mobile, "Please enter 10 digit mobile number", 4000);

        }
        else if (emailregister.getText().toString().isEmpty()) {
            emailregister.requestFocus();
            emailregister.setError("please provide email id");

        } else if (address.getText().toString().isEmpty()) {
            address.requestFocus();
            address.setError("please provide address");

        } else if(pass.getText().toString().isEmpty()) {
            pass.requestFocus();
            pass.setError("");


        } else {



                String username = name.getText().toString();
                String mobilenum = mobile.getText().toString();
                String alternatenumregister = alternatenum.getText().toString();
                String email = emailregister.getText().toString();
                String addressregister = address.getText().toString();
                String landmarkregister = landmark.getText().toString();

                if (email.contains("@") && email.contains((".com"))) {



                        editor = getSharedPreferences("userdetails", MODE_PRIVATE).edit();
                        editor.putString("username", username);
                        editor.putString("mobile", mobilenum);
                        editor.putString("alternatenum", alternatenumregister);
                        editor.putString("emailregister", email);
                        editor.putString("address", addressregister);
                        editor.putString("landmark", landmarkregister);
                        editor.commit();


                        Intent i = new Intent(RegistrationActivity.this, BookNowActivity.class);
                        startActivity(i);
                    }
                    else{
                        showSnackbar(emailregister, "provide proper email id", 4000);

                }


            }
        }
    }


