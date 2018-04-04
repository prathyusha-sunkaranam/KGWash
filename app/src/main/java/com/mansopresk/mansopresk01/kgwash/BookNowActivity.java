package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;



public class BookNowActivity extends AppCompatActivity {
    RadioButton washfold,washiron,iron;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        washfold = (RadioButton) findViewById(R.id.washfold_button);
        washiron = (RadioButton) findViewById(R.id.washiron_button);
        iron = (RadioButton) findViewById(R.id.iron_button);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       findViewById(R.id.placeorder).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
         startActivity(i);
           }
       });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
//
//    public void click(View v){
//        Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
//        startActivity(i);
//    }
}
