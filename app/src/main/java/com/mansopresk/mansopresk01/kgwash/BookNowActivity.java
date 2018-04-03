package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

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
        order = (Button) findViewById(R.id.placeorder);

    }

    public void  porder(View v){
        Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
        startActivity(i);
    }
}
