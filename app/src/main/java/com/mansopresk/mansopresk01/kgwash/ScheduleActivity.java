package com.mansopresk.mansopresk01.kgwash;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class ScheduleActivity extends AppCompatActivity {
    Spinner spinner;
    Calendar calendar;
    private int year, month, day;
    EditText  name_sch,mobile_sch,alternatenum_sch,emailregister_sch,address_sch,landmark_sch,dateview;
    Button Schedule;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        name_sch = findViewById(R.id.name_register);
        mobile_sch = findViewById(R.id.mobile_register);
        alternatenum_sch = findViewById(R.id.alternate_mob_register);
        emailregister_sch = findViewById(R.id.email_register);
        address_sch = findViewById(R.id.address_register);
        landmark_sch = findViewById(R.id.landmark_register);
        spinner=(Spinner)findViewById(R.id.spinner);
        dateview = (EditText) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();

        Schedule = findViewById(R.id.schedule);
        Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ScheduleActivity.this,YourOrdersActivity.class);
                startActivity(i);
            }
        });


        sharedpreferences = getSharedPreferences("userdetails",MODE_PRIVATE);
       String uname = sharedpreferences.getString("username",null);
        String mobilenum = sharedpreferences.getString("mobile",null);
        String alernum = sharedpreferences.getString("alternatenum",null);
        String emailid = sharedpreferences.getString("emailregister",null);
        String adreesdetails = sharedpreferences.getString("address",null);
        String landmarkdetails = sharedpreferences.getString("landmark",null);

        name_sch.setText(uname);
        mobile_sch.setText(mobilenum);
        alternatenum_sch.setText(alernum);
        emailregister_sch.setText(emailid);
        address_sch.setText(adreesdetails);
        landmark_sch.setText(landmarkdetails);

    }






    public void setDate(View view) {
        showDialog(999);
//
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);

                }
            };

    private void showDate(int year, int month, int day) {
        dateview.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }
}
