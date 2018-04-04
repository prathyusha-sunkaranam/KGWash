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
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity {
    Spinner spinner;
    Calendar calendar;
    private int year, month, day;
    EditText  name_sch,mobile_sch,alternatenum_sch,emailregister_sch,address_sch,landmark_sch,dateview,etcalendar;
    Button Schedule,calendarbtn;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    LinearLayout calendarll;
    static final int DATE_PICKER_ID = 1111;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //dateview = (EditText) findViewById(R.id.textView3);
        etcalendar=findViewById(R.id.etcalender);
        calendarbtn = findViewById(R.id.calendarbtn);
        //calendarbtn.findViewById(R.id.calendarbtn);

        //calendar = Calendar.getInstance();
        calendarll=findViewById(R.id.calendarll);
        Schedule = findViewById(R.id.schedule);


//        etcalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calendar = Calendar.getInstance();
//                day = calendar.get(Calendar.DAY_OF_MONTH);
//                month = calendar.get(Calendar.MONTH);
//                year = calendar.get(Calendar.YEAR);
//                showDialog(DATE_PICKER_ID);
//            }
//        });
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
    public void calender(View v){
        calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);
                showDialog(DATE_PICKER_ID);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent ip = new Intent(ScheduleActivity.this,BookNowActivity.class);
        startActivity(ip);
        return true;
    }






//    public void setDate(View view) {
//        showDialog(999);
////
//    }

//    @Override
//    protected Dialog onCreateDialog(int id) {
//        // TODO Auto-generated method stub
//        if (id == 999) {
//            return new DatePickerDialog(this,myDateListener, year, month, day);
//        }
//        return null;
//    }
@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
        case DATE_PICKER_ID:
            // create a new DatePickerDialog with values you want to show

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, datePickerListener, year, month, day);
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 0); // Add 0 days to Calendar
            Date newDate = calendar.getTime();
            datePickerDialog.getDatePicker().setMinDate(newDate.getTime()-(newDate.getTime()%(24*60*60*1000)));
            return datePickerDialog;
    }
    return null;
}
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        // the callback received when the user "sets" the Date in the
        // DatePickerDialog
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

            etcalendar.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
        }
    };

//    private DatePickerDialog.OnDateSetListener myDateListener = new
//            DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker arg0,
//                                      int arg1, int arg2, int arg3) {
//
//                    // TODO Auto-generated method stub
//                    // arg1 = year
//                    // arg2 = month
//                    // arg3 = day
//                    showDate(arg1, arg2+1, arg3);
//
//                }
//            };

//    private void showDate(int year, int month, int day) {
//        dateview.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
//
//    }
}
