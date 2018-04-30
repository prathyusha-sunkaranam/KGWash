package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import android.support.v7.app.AlertDialog;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.mansopresk.mansopresk01.kgwash.AdminOrder;
import com.mansopresk.mansopresk01.kgwash.BookNowActivity;
import com.mansopresk.mansopresk01.kgwash.DeliveryActivity;
import com.mansopresk.mansopresk01.kgwash.Indicator.PrefManager;
import com.mansopresk.mansopresk01.kgwash.Indicator.TapTargetManger;
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
    SharedPreferences sharedPreferences, prefs;
    LinearLayout loginsignup;
    ViewPager viewPager;
    private BookPageAdapter myViewPagerAdapters;
    private int[] layouts;
    Timer timer;
    SharedPreferences.Editor editors;
    Button odernow;
    String uname;
    private TapTargetManger tapTargetManger;

    Animation animZoomIn;
     private static final String PREF_NAME = "taptarget";
        private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";


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
        tapTargetManger = new TapTargetManger(this);

         prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
              editors = prefs.edit();

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

        final int images[] = {R.drawable.booking, R.drawable.washinggirl, R.drawable.ironboyy, R.drawable.payment,R.drawable.delivery};

//        layouts = new int[]{
//                R.layout.booking,
//                R.layout.washinggirl,
//                R.layout.washingview,
//                R.layout.payment};
        myViewPagerAdapters = new BookPageAdapter(NavigationMainActivity.this, images);
        viewPager.setAdapter(myViewPagerAdapters);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable(){
                    @Override
                    public void run() {
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%images.length);
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

         if(tapTargetManger.isFirstTimeLaunch())
         {

//             TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.ordernow), "This is Shedule Now", "Click to schedule the pick up")
//                 .tintTarget(false)
//                 .outerCircleColor(R.color.bg_screen1));
//
//             TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.premium), "This is Shedule Now", "Click to schedule the pick up")
//                     .tintTarget(false)
//                     .outerCircleColor(R.color.bg_screen1));


             new TapTargetSequence(this)
                     .targets(
                             TapTarget.forView(findViewById(R.id.ordernow), "Gonna")
                                    // .tintTarget(false)

                                     .outerCircleColor(R.color.bg_screen1),

                             TapTarget.forView(findViewById(R.id.premium), "You", "Up")

                                     //.tintTarget(false)
                                     .outerCircleColor(R.color.bg_screen1))

//                             TapTarget.forBounds(rickTarget, "Down", ":^)")
//                                     .cancelable(false)
//                                     .icon(rick))
                     .listener(new TapTargetSequence.Listener() {
                         // This listener will tell us when interesting(tm) events happen in regards
                         // to the sequence
                         @Override
                         public void onSequenceFinish() {
                             // Yay
                            // ((TextView) findViewById(R.id.educated)).setText("Congratulations! You're educated now!");
                         }

                         @Override
                         public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                         }


                         @Override
                         public void onSequenceCanceled(TapTarget lastTarget) {
                             // Boo
                         }
                     });
             setFirstTimeLaunch(true);
             tapTargetManger.setFirstTimeLaunch(false);

//             final TapTargetSequence sequence = new TapTargetSequence(this)
//                     .targets(
//                             // This tap target will target the back button, we just need to pass its containing toolbar
//                           //  TapTarget.forToolbarNavigationIcon(toolbar, "This is the Navigation button", "Check it").id(1),
//                             // Likewise, this tap target will target the search button
////                             TapTarget.forToolbarMenuItem(toolbar, R.id.ic_, "This is a search icon", "As you can see, it has gotten pretty dark around here...")
////                                     .dimColor(android.R.color.black)
////                                     .outerCircleColor(R.color.colorAccent)
////                                     .targetCircleColor(android.R.color.black)
////                                     .transparentTarget(true)
////                                     .textColor(android.R.color.black)
////                                     .id(2),
//                             // You can also target the overflow button in your toolbar
//                            // TapTarget.forToolbarOverflow(toolbar, "This will show more options", "But they're not useful :(").id(3),
//                             // This tap target will target our droid buddy at the given target rect
//                             TapTarget.forView(findViewById(R.id.ordernow), "Oh look!", "You can point to any part of the screen. You also can't cancel this one!")
//                                     .cancelable(false)
//                                    // .icon(findViewById(R.id.ordernow)
//                                     .id(1),
//                             TapTarget.forView(findViewById(R.id.premium), "Oh look!", "You can point to any part of the screen. You also can't cancel this one!")
//                                     .cancelable(false).id(2)
//                     )
//
//                     .listener(new TapTargetSequence.Listener() {
//                         // This listener will tell us when interesting(tm) events happen in regards
//                         // to the sequence
//                         @Override
//                         public void onSequenceFinish() {
//                             ((TextView) findViewById(R.id.premium)).setText("Congratulations! You're educated now!");
//                         }
//
//                         @Override
//                         public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
//                             Log.d("TapTargetView", "Clicked on " + lastTarget.id());
//                         }
//
//                         @Override
//                         public void onSequenceCanceled(TapTarget lastTarget) {
//                             final AlertDialog dialog = new AlertDialog.Builder(NavigationMainActivity.this)
//                                     .setTitle("Uh oh")
//                                     .setMessage("You canceled the sequence")
//                                     .setPositiveButton("Oops", null).show();
//                             TapTargetView.showFor(dialog,
//                                     TapTarget.forView(dialog.getButton(DialogInterface.BUTTON_POSITIVE), "Uh oh!", "You canceled the sequence at step " + lastTarget.id())
//                                             .cancelable(false)
//                                             .tintTarget(false), new TapTargetView.Listener() {
//                                         @Override
//                                         public void onTargetClick(TapTargetView view) {
//                                             super.onTargetClick(view);
//                                             dialog.dismiss();
//                                         }
//                                     });
//                         }
//                     });
//             setFirstTimeLaunch(true);
//            tapTargetManger.setFirstTimeLaunch(false);
         }





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
        tapTargetManger.setFirstTimeLaunch(false);
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
        Context context;
        int images[];
        LayoutInflater layoutInflater;


        public BookPageAdapter(Context context, int images[]) {
            this.context = context;
            this.images = images;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = layoutInflater.inflate(R.layout.booking, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewpager);
            imageView.setImageResource(images[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
    public boolean isFirstTimeLaunch()
    {
        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editors.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editors.commit();
    }

}
