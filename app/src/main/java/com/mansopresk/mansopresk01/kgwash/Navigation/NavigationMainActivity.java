package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mansopresk.mansopresk01.kgwash.BookNowActivity;
import com.mansopresk.mansopresk01.kgwash.MainActivity;
import com.mansopresk.mansopresk01.kgwash.R;
import com.mansopresk.mansopresk01.kgwash.RegistrationActivity;
import com.mansopresk.mansopresk01.kgwash.ScheduleActivity;
import com.mansopresk.mansopresk01.kgwash.YourOrdersActivity;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView navsignin,navsignup,navuname,toolbartext,textviewname;
    SharedPreferences sharedPreferences;
    Button odernow;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);


        setTitle("KG Wash");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        odernow = (Button) findViewById(R.id.ordernow);
        toolbartext = (TextView) findViewById(R.id.toolbartext);
        linearLayout=(LinearLayout)findViewById(R.id.nav_loginll);
        toolbartext.setText("KG Wash");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        navuname = header.findViewById(R.id.uname);
        navsignin = header.findViewById(R.id.nav_signin);
        navsignup = header.findViewById(R.id.nav_signup);

        navsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NavigationMainActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        navsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NavigationMainActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });



        sharedPreferences = getSharedPreferences("userdetails", MODE_PRIVATE);

        String uname = sharedPreferences.getString("email", null);
        //String mname = sharedPreferences.getString("username", null);
        navuname.setText(uname);
//
            if (sharedPreferences != null) {

                }
//
//
//                } else {
//                    Intent i = new Intent(this, MainActivity.class);
//                    Toast.makeText(this, "Logout completely", Toast.LENGTH_SHORT).show();
//                    startActivity(i);
//
//                }
//            }
    }


public void ordernow(View v){
    Intent ip = new Intent(this, BookNowActivity.class);
    startActivity(ip);
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_orders) {
            Intent i = new Intent(NavigationMainActivity.this, YourOrdersActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_aboutus) {
            Intent i = new Intent(NavigationMainActivity.this, AboutUsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_tcapply) {
                Intent i = new Intent(NavigationMainActivity.this,TermsConditionsActivity.class);
                startActivity(i);

        } else if (id == R.id.nav_faq) {
            Intent i2 = new Intent(NavigationMainActivity.this,FaqActivity.class);
            startActivity(i2);

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));

            }

         else if (id == R.id.nav_logout) {

//         getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();
//
//
//            nav_text.setText("Login | Signup");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
