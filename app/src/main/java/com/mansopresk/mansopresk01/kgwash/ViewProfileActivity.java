
package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

public class ViewProfileActivity extends AppCompatActivity {


    TextView name,mobile,altermobile,email,landmark,date,timeslot,adress;
    String sname,smobile,saltermobile,semail,slandmark,sdate,stimeslot,sadress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        name=findViewById(R.id.name_place);
        mobile=findViewById(R.id.mobile_place);
        altermobile=findViewById(R.id.alter_place);
        email=findViewById(R.id.email_place);
        landmark=findViewById(R.id.landmarl_place);
        date=findViewById(R.id.date_place);
        timeslot=findViewById(R.id.timeslote_place);
        adress=findViewById(R.id.adress_place);
        SharedPreferences sharedPreferences=getSharedPreferences("userdetails", MODE_PRIVATE);
        sname=sharedPreferences.getString("username",null);
        smobile=sharedPreferences.getString("mobile",null);
        saltermobile=sharedPreferences.getString("alternatenum",null);
        semail=sharedPreferences.getString("emailregister",null);
        slandmark=sharedPreferences.getString("address",null);
        sdate=sharedPreferences.getString("username",null);
        stimeslot=sharedPreferences.getString("username",null);
        sadress=sharedPreferences.getString("address",null);
        name.setText(sname);
        mobile.setText(smobile);
        altermobile.setText(saltermobile);
        email.setText(semail);
        landmark.setText(slandmark);
        date.setText(sdate);
        timeslot.setText(stimeslot);
        adress.setText(sadress);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarprofile);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(ViewProfileActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
}
