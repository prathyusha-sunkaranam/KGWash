package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.mansopresk.mansopresk01.kgwash.AdminOrder;
import com.mansopresk.mansopresk01.kgwash.BookNowActivity;
import com.mansopresk.mansopresk01.kgwash.DeliveryActivity;
import com.mansopresk.mansopresk01.kgwash.MainActivity;
import com.mansopresk.mansopresk01.kgwash.R;
import com.mansopresk.mansopresk01.kgwash.RegistrationActivity;
import com.mansopresk.mansopresk01.kgwash.ScheduleActivity;
import com.mansopresk.mansopresk01.kgwash.ViewProfileActivity;
import com.mansopresk.mansopresk01.kgwash.YourOrdersActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView nav_signin1,nav_signup, textView,nav_email,jhonno,premium;
    SharedPreferences sharedPreferences;
    LinearLayout loginsignup;
    ViewPager viewPager;
    private BookPageAdapter myViewPagerAdapters;
    private int[] layouts;
    Timer timer;
    Button odernow;
    String uname;
    Animation animZoomIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        setTitle("KG Wash");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        premium = findViewById(R.id.premium);
        odernow = (Button) findViewById(R.id.ordernow);
        textView = (TextView) findViewById(R.id.toolbartext);
        viewPager = (ViewPager) findViewById(R.id.content_viewer);
        jhonno=findViewById(R.id.johnno);
        textView.setText("KG Wash");

       // final Button buttonPlayVideo2 = (Button)findViewById(R.id.button_click);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        //displays a video file
    //   VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView);



//        String uriPath2 = "android.resource://com.mansopresk.mansopresk01.kgwash/"+R.raw.kgvideos;
//        Uri uri2 = Uri.parse(uriPath2);
//        mVideoView2.setVideoURI(uri2);
//        mVideoView2.requestFocus();

//
//        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView);
//
//                String uriPath = "android.resource://com.mansopresk.mansopresk01.kgwash/" + R.raw.kgvideos;
////                Uri uri2 = Uri.parse(uriPath);
////                mVideoView2.setVideoURI(uri2);
//               // mVideoView2.requestFocus();
//               // mVideoView2.start();
//
//                if(mVideoView2.isPlaying()){
//                    mVideoView2.pause();
//                    buttonPlayVideo2.setBackgroundResource(R.drawable.platbtn);
//                } else {
//                    mVideoView2.start();
//                    buttonPlayVideo2.setBackgroundResource(R.drawable.pbtn);
//                }
//            }
//        });

        int images[] = {R.drawable.booking, R.drawable.washinggirl, R.drawable.washingview, R.drawable.payment};

        layouts = new int[]{
                R.layout.booking,
                R.layout.washinggirl,
                R.layout.washingview,
                R.layout.payment};
        myViewPagerAdapters = new BookPageAdapter();
        viewPager.setAdapter(myViewPagerAdapters);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable(){
                    @Override
                    public void run() {
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%layouts.length);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 3000, 3000);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        premium.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(NavigationMainActivity.this,Premium.class);
                startActivity(ip);
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        nav_signin1 =header.findViewById(R.id.nav_signin1);
        nav_signup=header.findViewById(R.id.nav_signup);
        sharedPreferences = getSharedPreferences("admindetails",MODE_PRIVATE);
        String uname = sharedPreferences.getString("aemail",null);
        TapTargetView.showFor(this,TapTarget.forView(findViewById(R.id.ordernow), "This is Shedule Now", "Click to schedule the pick up")
        .tintTarget(false)
        .outerCircleColor(R.color.bg_screen1));
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
        if (uname == null || uname == "") {
                    loginsignup =(LinearLayout)header.findViewById(R.id.nav_loginll);
                    loginsignup.setVisibility(View.VISIBLE);
                    Menu menuNav=navigationView.getMenu();
                    MenuItem nav_logout = menuNav.findItem(R.id.nav_logout);
                    nav_logout.setVisible(false);
                    MenuItem nav_profile = menuNav.findItem(R.id.nav_profile);
                    nav_profile.setVisible(false);
                    MenuItem nav_orders = menuNav.findItem(R.id.nav_orders);
                    nav_orders.setVisible(true);
                    nav_email=(TextView)header.findViewById(R.id.nav_mail);
                    nav_email.setVisibility(View.GONE);
                }
                else {
                loginsignup =(LinearLayout)header.findViewById(R.id.nav_loginll);
                loginsignup.setVisibility(View.GONE);
                Menu menuNav=navigationView.getMenu();
                MenuItem nav_logout = menuNav.findItem(R.id.nav_logout);
                nav_logout.setVisible(true);
                MenuItem nav_profile = menuNav.findItem(R.id.nav_profile);
                nav_profile.setVisible(true);
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
        else {
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    public void ordernow(View v){
        //odernow.startAnimation(animZoomIn);
    Intent ip = new Intent(this, BookNowActivity.class);
    startActivity(ip);
}
    public void basic(View v) {
        Intent ipr = new Intent(this, ScheduleActivity.class);
        startActivity(ipr);
    }
    public void silver(View v) {
        Intent ipr1 = new Intent(this, ScheduleActivity.class);
        startActivity(ipr1);
    }
    public void gold(View v) {
        Intent ipr2 = new Intent(this, ScheduleActivity.class);
        startActivity(ipr2);
    }
    public void diamond(View v) {
        Intent ipr3 = new Intent(this, ScheduleActivity.class);
        startActivity(ipr3);
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
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
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
        } else if (id == R.id.nav_basic) {
            Intent i = new Intent(NavigationMainActivity.this,Premium.class);
            startActivity(i);

        } else if (id == R.id.nav_faq) {
            Intent i2 = new Intent(NavigationMainActivity.this,FaqActivity.class);
            startActivity(i2);

        }

        else if (id == R.id.nav_credits) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
            return true;

        }

        else if (id == R.id.crediteone) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
            return true;

        }
        else if (id == R.id.credittwo) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
            return true;

        }else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your App is here";
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


    public class BookPageAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        public BookPageAdapter() {
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
