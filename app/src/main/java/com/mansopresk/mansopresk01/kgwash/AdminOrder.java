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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class AdminOrder extends AppCompatActivity {
    GifImageView usercall1,usercall2,


    usermail,userlocation;
    EditText mobile;
    SharedPreferences sharedpreferences;
    TextView oname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
//        phcall= findViewById(R.id.phcall);

        usercall1 = findViewById(R.id.phcall1);

        usermail=findViewById(R.id.useremail);
        userlocation=findViewById(R.id.userlocation);

//        altrphcall=findViewById(R.id.phcall2);
        oname = findViewById(R.id.oname);
//        mobile=findViewById(R.id.mobile_admin);
//        //Performing action on button click
//        phcall.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View arg0) {
//                String number=mobile.getText().toString();
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:"+number));
//                startActivity(callIntent);
//
//            }
//
//        });
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
}





