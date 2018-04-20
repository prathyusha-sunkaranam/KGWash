package com.mansopresk.mansopresk01.kgwash;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.Maps.MapsActivity;
import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;

import pl.droidsonroids.gif.GifImageView;

public class AdminOrder extends AppCompatActivity {
    GifImageView call, usercall2, usermail, userlocation;

    SharedPreferences sharedpreferences;
    TextView nav_email;
    TextView ousername, useraddress, usermobile, username, useremail, usrlandmark, userdate, usertime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
        useraddress = findViewById(R.id.admin_address);
        call = findViewById(R.id.admincal);
        usermail = findViewById(R.id.useremail);
        userlocation = findViewById(R.id.userlocation);
        ousername = findViewById(R.id.username);
        usertime = findViewById(R.id.admin_time);
        userdate = findViewById(R.id.admin_date);
        usermobile = findViewById(R.id.admin_mobile);
        username = findViewById(R.id.admin_name);
        useremail = findViewById(R.id.admin_email);
        usrlandmark = findViewById(R.id.admin_landmark);

        setTitle("Admin Profile");
        nav_email = (TextView) findViewById(R.id.nav_mail);
        userlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                String adress = useraddress.getText().toString();
                i.putExtra("addr", adress);
                startActivity(i);
            }
        });
        sharedpreferences = getSharedPreferences("admindetails", MODE_PRIVATE);
        String uname = sharedpreferences.getString("aemail", null);
        if (sharedpreferences != null) {
            if (uname != null || uname == "") {
            } else {
                Intent it = new Intent(AdminOrder.this, MainActivity.class);
                startActivity(it);
            }
        }
        sharedpreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
        String admname = sharedpreferences.getString("custname", null);
        String admmobile = sharedpreferences.getString("usermno", null);
        String admemail = sharedpreferences.getString("useremail", null);
        String admaddress = sharedpreferences.getString("useraddress", null);
        String admlandmark = sharedpreferences.getString("userlandmark", null);
        String admdate = sharedpreferences.getString("userdate", null);

        useraddress.setText(admaddress);
        username.setText(admname);
        usermobile.setText(admmobile);
        useremail.setText(admemail);
        usrlandmark.setText(admlandmark);
        userdate.setText(admdate);
        usertime.setText(sharedpreferences.getString("usertime", ""));

        usermail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setType("message/rfc822");
                    i.setData(Uri.parse("mailto:sateesh.itech@gmail.com"));
                    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    i.putExtra(Intent.EXTRA_TEXT, "body of email");
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Log.d("exception", "There are no email clients installed.");
                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = usermobile.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(AdminOrder.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

    public void details(View v) {
        Intent i2 = new Intent(AdminOrder.this, AdminOrderViewActivity.class);
        startActivity(i2);
    }

    public void odetails(View v) {
        Intent i3 = new Intent(AdminOrder.this, AdminOrderViewActivity.class);
        startActivity(i3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navigation_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                getApplicationContext().getSharedPreferences("admindetails", 0).edit().clear().apply();
                Intent i2 = new Intent(AdminOrder.this, NavigationMainActivity.class);
                startActivity(i2);
        }
        return true;
    }

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else {
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }

    public void call_action() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9010990285"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent chooser = Intent.createChooser(intent, "Complete Action using..");
        startActivity(chooser);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
    }
}






