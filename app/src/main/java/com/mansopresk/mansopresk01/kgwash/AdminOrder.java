package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AdminOrder extends AppCompatActivity {
    ImageView phcall,altrphcall;
    EditText mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
        phcall= findViewById(R.id.phcall);
        altrphcall=findViewById(R.id.phcall2);
        mobile=findViewById(R.id.mobile_admin);
        //Performing action on button click
        phcall.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String number=mobile.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);

            }

        });
    }








}





