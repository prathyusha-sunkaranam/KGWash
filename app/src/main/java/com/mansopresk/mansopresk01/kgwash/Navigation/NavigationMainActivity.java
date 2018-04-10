package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
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

import com.mansopresk.mansopresk01.kgwash.AdminOrder;
import com.mansopresk.mansopresk01.kgwash.BookNowActivity;
import com.mansopresk.mansopresk01.kgwash.DeliveryActivity;
import com.mansopresk.mansopresk01.kgwash.MainActivity;
import com.mansopresk.mansopresk01.kgwash.R;
import com.mansopresk.mansopresk01.kgwash.RegistrationActivity;
import com.mansopresk.mansopresk01.kgwash.ScheduleActivity;
import com.mansopresk.mansopresk01.kgwash.ViewProfileActivity;
import com.mansopresk.mansopresk01.kgwash.YourOrdersActivity;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView nav_signin1,nav_signup, textView,nav_email,jhonno;
    SharedPreferences sharedPreferences;
    LinearLayout loginsignup;
    Button odernow;
    String uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);

        setTitle("KG Wash");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        odernow = (Button) findViewById(R.id.ordernow);
        textView = (TextView) findViewById(R.id.toolbartext);
        jhonno=findViewById(R.id.johnno);

        textView.setText("KG Wash");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        nav_signin1 =header.findViewById(R.id.nav_signin1);
        nav_signup=header.findViewById(R.id.nav_signup);
        sharedPreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
        String uname = sharedPreferences.getString("aemail",null);

        if(uname!=null){
            Intent i=new Intent(this,AdminOrder.class);
            startActivity(i);
        }

        String uname1 = sharedPreferences.getString("deliveryemail",null);
        if(uname1!=null){
            Intent i2=new Intent(this,DeliveryActivity.class);
            startActivity(i2);
        }





        nav_signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(NavigationMainActivity.this,MainActivity.class);
                startActivity(it);


            }
        });

        nav_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(NavigationMainActivity.this,RegistrationActivity.class);
                startActivity(it);

            }
        });
        sharedPreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
        uname = sharedPreferences.getString("email", null);
       // String mname = sharedPreferences.getString("username", null);
       // nav_email.setText(mname);

//            if (sharedPreferences != null) {
//                sharedPreferences = getSharedPreferences("admindetails", MODE_PRIVATE);
//                String adminuname = sharedPreferences.getString("aemail", null);
//                if (adminuname == null || adminuname == "") {
//                    Intent i = new Intent(this, NavigationMainActivity.class);
//                    startActivity(i);
//                } else {
//                    Intent i = new Intent(this, AdminOrder.class);
//                    startActivity(i);
//                }
//            }
//        sharedPreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
//        String adminuname = sharedPreferences.getString("aemail",null);
//        if(sharedPreferences==null){
//            if(adminuname==null|adminuname=="") {
//                Intent i = new Intent(this,NavigationMainActivity.class );
//                startActivity(i);
//            }else {
//                    Intent i = new Intent(this, AdminOrder.class);
//                    startActivity(i);
//                }
//        }
                if (uname == null || uname == "") {
//                 nav_signin1.setText(uname);
                    loginsignup =(LinearLayout)header.findViewById(R.id.nav_loginll);
                    loginsignup.setVisibility(View.VISIBLE);
                    Menu menuNav=navigationView.getMenu();
                    MenuItem nav_logout = menuNav.findItem(R.id.nav_logout);
                    nav_logout.setVisible(false);
                    MenuItem nav_profile = menuNav.findItem(R.id.nav_profile);
                    nav_profile.setVisible(false);
                    MenuItem nav_orders = menuNav.findItem(R.id.nav_orders);
                    nav_orders.setVisible(false);
                    nav_email=(TextView)header.findViewById(R.id.nav_mail);
                    nav_email.setVisibility(View.GONE);


                }

               // }
                else {
//                    Intent i = new Intent(this, MainActivity.class);
//                    Toast.makeText(this, "Logout completely", Toast.LENGTH_SHORT).show();
//                    startActivity(i);
                loginsignup =(LinearLayout)header.findViewById(R.id.nav_loginll);
                loginsignup.setVisibility(View.GONE);
                Menu menuNav=navigationView.getMenu();
                MenuItem nav_logout = menuNav.findItem(R.id.nav_logout);
                nav_logout.setVisible(true);
                MenuItem nav_profile = menuNav.findItem(R.id.nav_profile);
                nav_profile.setVisible(true);
                MenuItem nav_orders = menuNav.findItem(R.id.nav_orders);
                    nav_orders.setVisible(true);
                nav_email=(TextView)header.findViewById(R.id.nav_mail);
                    nav_email.setVisibility(View.VISIBLE);
                nav_email.setText(uname);

                }
        jhonno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPermissionGranted()) {
                    call_action();
                }
            }
        });
        }
    public void call_action() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9000379005"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent chooser = Intent.createChooser(intent, "Complete Action using..");
        startActivity(chooser);
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
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
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
           // super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
            startActivity(intent);
            finish();
            System.exit(0);

        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//          //  getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();
//
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

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
            Intent intent = new Intent(getApplicationContext(), NavigationMainActivity.class);
           getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();
            startActivity(intent);



        }
        else if (id == R.id.nav_profile){
            Intent i3 = new Intent(NavigationMainActivity.this,ViewProfileActivity.class);
            startActivity(i3);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
