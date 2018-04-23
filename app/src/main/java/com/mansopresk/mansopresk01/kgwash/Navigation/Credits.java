package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mansopresk.mansopresk01.kgwash.R;


public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbartc);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(Credits.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
}
