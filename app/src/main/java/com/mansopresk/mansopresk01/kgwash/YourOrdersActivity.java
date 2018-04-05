package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import com.mansopresk.mansopresk01.kgwash.Navigation.TermsConditionsActivity;

public class YourOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarorder);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(YourOrdersActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
}
