package com.mansopresk.mansopresk01.kgwash;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.Maps.MapsActivity;
import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import com.mansopresk.mansopresk01.kgwash.Order.PriceOrderActivity;

import pl.droidsonroids.gif.GifImageView;

public class AdminOrder extends AppCompatActivity {
    GifImageView usercall1,usercall2,usermail,userlocation;
    EditText mobile;
    SharedPreferences sharedpreferences;
    TextView ousername;
    SharedPreferences sharedPreferences;
    TextView nav_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);

        usercall1 = findViewById(R.id.phcall1);
        usermail=findViewById(R.id.useremail);
        userlocation=findViewById(R.id.userlocation);
        ousername= findViewById(R.id.username);
        setTitle("Admin Profile");
        nav_email=(TextView)findViewById(R.id.nav_mail);

        userlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });


        sharedpreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
        String uname = sharedpreferences.getString("aemail",null);

        if(sharedpreferences!=null){
            if(uname!=null||uname==""){

            }
            else {
                Intent it = new Intent(AdminOrder.this, MainActivity.class);
                startActivity(it);

            }
        }
         usermail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 try {
                     Intent i = new Intent(Intent.ACTION_SENDTO);
                     i.setType("message/rfc822");
                     i.setData(Uri.parse("mailto:sateesh.itech@gmail.com"));
                     i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                     i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                     i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     startActivity(Intent.createChooser(i, "Send mail..."));
                 } catch (android.content.ActivityNotFoundException ex) {
                     Log.d("exception", "There are no email clients installed.");
                 }
             }
         });
        usercall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted()) {
                    call_action();
                }

            }
        });

        sharedpreferences = getSharedPreferences("userdetails", MODE_PRIVATE);

        String username =sharedpreferences.getString("custname", null);
      ousername.setText(username);

    }


    public void details(View v){
        Intent i2 = new Intent(AdminOrder.this,AdminOrderViewActivity.class);
        startActivity(i2);
    }
    public void odetails(View v){
        Intent i3 = new Intent(AdminOrder.this,AdminOrderViewActivity.class);
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

    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else {
            Log.v("TAG","Permission is granted");
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






