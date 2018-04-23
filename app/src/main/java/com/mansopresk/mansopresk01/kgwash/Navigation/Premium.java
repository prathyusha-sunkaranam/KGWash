package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.R;
import com.mansopresk.mansopresk01.kgwash.ScheduleActivity;

public class Premium extends AppCompatActivity {
    TextView  basiccost,silvercost,goldcost,platinacost;
    Button basicbook,silverbook,goldbook,platinabook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);

        basiccost=(TextView)findViewById(R.id.basiccost);
        silvercost=(TextView)findViewById(R.id.silvercost);
        goldcost=(TextView)findViewById(R.id.goldcost);
        platinacost=(TextView)findViewById(R.id.platinacost);

        basicbook=findViewById(R.id.basicbook);
        silverbook=findViewById(R.id.silverbook);
        goldbook=findViewById(R.id.goldbook);
        platinabook=findViewById(R.id.platinabook);

       basiccost.setPaintFlags(basiccost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        silvercost.setPaintFlags(silvercost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        goldcost.setPaintFlags(goldcost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        platinacost.setPaintFlags(platinacost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        basicbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(Premium.this, ScheduleActivity.class);
                startActivity(it);
            }
        });
        silverbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(Premium.this, ScheduleActivity.class);
                startActivity(it);
            }
        });
        goldbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(Premium.this, ScheduleActivity.class);
                startActivity(it);
            }
        });
        platinabook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(Premium.this, ScheduleActivity.class);
                startActivity(it);
            }
        });
    }
}
