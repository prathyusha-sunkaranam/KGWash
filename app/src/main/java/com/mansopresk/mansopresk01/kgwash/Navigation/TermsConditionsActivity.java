package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mansopresk.mansopresk01.kgwash.R;

public class TermsConditionsActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbartc);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(TermsConditionsActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
}
