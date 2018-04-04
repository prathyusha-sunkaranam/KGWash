package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class BookNowActivity extends Activity {
    RadioButton washfold,washiron,iron;
    Button order;
    TextView textViewbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        washfold = (RadioButton) findViewById(R.id.washfold_button);
        washiron = (RadioButton) findViewById(R.id.washiron_button);
        iron = (RadioButton) findViewById(R.id.iron_button);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        textViewbook = (TextView) findViewById(R.id.toolbartextbook);

        textViewbook.setText("Place Order");

       findViewById(R.id.placeorder).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
         startActivity(i);
           }
       });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarbook);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Your code
                finish();
            }
        });

    }

//    public void click(View v){
//        Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
//        startActivity(i);
//    }
}
