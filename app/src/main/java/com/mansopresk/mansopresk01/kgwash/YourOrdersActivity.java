package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import com.mansopresk.mansopresk01.kgwash.Navigation.TermsConditionsActivity;

public class YourOrdersActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView dateplace,timesloteplace,customername,areaspinnertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarprofile);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dateplace = (TextView)findViewById(R.id.date_place);
        timesloteplace=findViewById(R.id.timeslote_place);
        areaspinnertext = findViewById(R.id.areaspinr);
        customername=findViewById(R.id.customername);
        sharedpreferences = getSharedPreferences("userdetails", MODE_PRIVATE);

        String uname =sharedpreferences.getString("custname", null);
        customername.setText(uname);


        String udate = sharedpreferences.getString("userdate", null);
        dateplace.setText(udate);
        timesloteplace.setText(sharedpreferences.getString("usertime", ""));
       // areaspinnertext.setText(sharedpreferences.getString("userarea", ""));
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(YourOrdersActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
}
