package com.mansopresk.mansopresk01.kgwash;

import android.Manifest;
import android.app.Activity;
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

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import com.mansopresk.mansopresk01.kgwash.Order.PriceOrderActivity;

import pl.droidsonroids.gif.GifImageView;

public class AdminOrder extends AppCompatActivity {
    GifImageView usercall1,usercall2,usermail,userlocation;
    EditText mobile;
    SharedPreferences sharedpreferences;
    TextView oname;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
        usercall1 = findViewById(R.id.phcall1);
        usermail=findViewById(R.id.useremail);
        userlocation=findViewById(R.id.userlocation);
        oname = findViewById(R.id.oname);
        setTitle("Admin Profile");
//        sharedPreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
//        String adminuname = sharedPreferences.getString("aemail",null);
//        if(sharedPreferences==null){
//            if(adminuname==null|adminuname=="") {
//                Intent i = new Intent(this,NavigationMainActivity.class );
//                startActivity(i);
//            }
//        }
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
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_main, menu);
        return true;
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        Intent i2 = new Intent(AdminOrder.this, NavigationMainActivity.class);
//        getApplicationContext().getSharedPreferences("admindetails", 0).edit().clear().commit();
//        startActivity(i2);
//        return true;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Intent logout = new Intent(getApplicationContext(), NavigationMainActivity.class);
                getApplicationContext().getSharedPreferences("admindetails", 0).edit().clear().commit();
                startActivity(logout);

        }
        return true;
    }
//
//        sharedpreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
//        String ordername = sharedpreferences.getString("oname",null);
//
//        oname.setText(ordername);
//
//    }
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
        else { //permission is automatically granted on sdk<23 upon installation
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
        // super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);

}
}






