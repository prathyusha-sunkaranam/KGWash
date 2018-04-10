package com.mansopresk.mansopresk01.kgwash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import com.mansopresk.mansopresk01.kgwash.Order.PriceOrderActivity;

public class DeliveryActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        sharedpreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
        String uname1 = sharedpreferences.getString("deliveryemail",null);

        if(sharedpreferences!=null){
            if(uname1!=null||uname1==""){
//                Intent it = new Intent(AdminOrder.this, MainActivity.class);
//                startActivity(it);

//                nav_email.setText(uname);

            }
            else {
                Intent it = new Intent(DeliveryActivity.this, MainActivity.class);
                startActivity(it);

            }
        }

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


            Intent it = new Intent(DeliveryActivity.this, NavigationMainActivity.class);
            getApplicationContext().getSharedPreferences("admindetails", 0).edit().clear().apply();
            startActivity(it);

        }

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);

        //Toast.makeText(this, "back key is pressed", Toast.LENGTH_SHORT).show();
    }


}
