package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mansopresk.mansopresk01.kgwash.Order.PriceOrderActivity;

public class DeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.delivery, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itemorder) {
            Intent i = new Intent(DeliveryActivity.this, PriceOrderActivity.class);
            startActivity(i);


            return true;
        }

        else if (id == R.id.itemlog){

            getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();

        }

        return super.onOptionsItemSelected(item);
    }

}
