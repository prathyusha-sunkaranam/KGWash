package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mansopresk.mansopresk01.kgwash.R;


public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarcredits);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(Credits.this,NavigationMainActivity.class);
                startActivity(i2);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
