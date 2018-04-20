package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.R;


public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView amail,acall,aweb,backab;
    LinearLayout panel1,panel2,panel3;
    TextView text1,text2,text3,textView;
    View openLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarabt);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(AboutUsActivity.this,NavigationMainActivity.class);
                startActivity(i2);
                finish();
            }
        });
        amail=findViewById(R.id.aemail);
        acall=findViewById(R.id.acall);
        aweb = findViewById(R.id.awebsite);
        panel1 = findViewById(R.id.panel1);
        panel2 = findViewById(R.id.panel2);
        panel3 = findViewById(R.id.panel3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        amail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setType("message/rfc822");
                    i.setData(Uri.parse("mailto:info@mansopresk.com"));
                    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Log.d("exception", "There are no email clients installed.");
                }
            }
        });

        acall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPermissionGranted()){
                    call_action();
                }
            }
        });
        aweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",Uri.parse("http://mansopresk.com/"));
                startActivity(viewIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(AboutUsActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v)
    {
        hideOthers(v);
    }
    private void hideThemAll() {
        if (openLayout == null) return;
        if (openLayout == panel1)
            panel1.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
        if (openLayout == panel2)
            panel2.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
        if (openLayout == panel3)
            panel3.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
    }
    private void hideOthers(View layoutView) {
        {
            int v;
            if (layoutView.getId() == R.id.text1) {
                v = panel1.getVisibility();
                if (v != View.VISIBLE) {
                    panel1.setVisibility(View.VISIBLE);
                    Log.v("CZ", "height..." + panel1.getHeight());
                }
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel1.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
                }
            } else if (layoutView.getId() == R.id.text2) {
                v = panel2.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel2.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
                }
            } else if (layoutView.getId() == R.id.text3) {
                v = panel3.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel3.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
                }
            }
        }
    }

    public class ScaleAnimToHide extends ScaleAnimation
    {
        private View mView;
        private LinearLayout.LayoutParams mLayoutParams;
        private int mMarginBottomFromY, mMarginBottomToY;
        private boolean mVanishAfter = false;
        public ScaleAnimToHide(float fromX, float toX, float fromY, float toY, int duration, View view,boolean vanishAfter)
        {
            super(fromX, toX, fromY, toY);
            setDuration(duration);
            openLayout = null;
            mView = view;
            mVanishAfter = vanishAfter;
            mLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int height = mView.getHeight();
            mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin - height;
            mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) - height;
            Log.v("CZ","height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY  + " , mMarginBottomToY.." +mMarginBottomToY);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t)
        {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f)
            {
                int newMarginBottom = mMarginBottomFromY + (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime);
                mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                mView.getParent().requestLayout();
            }
            else if (mVanishAfter)
            {
                mView.setVisibility(View.GONE);
            }
        }
    }
    public class ScaleAnimToShow extends ScaleAnimation {

        private View mView;
        private LinearLayout.LayoutParams mLayoutParams;
        private int mMarginBottomFromY, mMarginBottomToY;
        private boolean mVanishAfter = false;
        public ScaleAnimToShow(float toX, float fromX, float toY, float fromY, int duration, View view, boolean vanishAfter) {
            super(fromX, toX, fromY, toY);
            openLayout = view;
            setDuration(duration);
            mView = view;
            mVanishAfter = vanishAfter;
            mLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            mView.setVisibility(View.VISIBLE);
            int height = mView.getHeight();
            mMarginBottomFromY = 0;
            mMarginBottomToY = height;

            Log.v("CZ", ".................height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY + " , mMarginBottomToY.." + mMarginBottomToY);
        }
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t)
        {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f)
            {
                int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime) - mMarginBottomToY;
                mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                mView.getParent().requestLayout();
            }
        }
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
    public void call_action(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9000379005"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent chooser  = Intent.createChooser(intent, "Complete Action using..");
        startActivity(chooser);
    }
}
