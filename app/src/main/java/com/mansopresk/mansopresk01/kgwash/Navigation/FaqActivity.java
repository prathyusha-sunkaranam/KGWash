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
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.R;

public class FaqActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView amail, acall, aweb,backimage;
    LinearLayout panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9,panel10,panel11;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9,text10,text11;
    View openLayout;

@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        amail = (ImageView) findViewById(R.id.aemail);
        acall = (ImageView) findViewById(R.id.acall);
        aweb = (ImageView) findViewById(R.id.awebsite);
        panel1 = (LinearLayout) findViewById(R.id.panel1);
        panel2 = (LinearLayout) findViewById(R.id.panel2);
        panel3 = (LinearLayout) findViewById(R.id.panel3);
        panel4 = (LinearLayout) findViewById(R.id.panel4);
        panel5 = (LinearLayout) findViewById(R.id.panel5);
        panel6 = (LinearLayout) findViewById(R.id.panel6);
        panel7 = (LinearLayout) findViewById(R.id.panel7);
        panel8 = (LinearLayout) findViewById(R.id.panel8);
        panel9 = (LinearLayout) findViewById(R.id.panel9);
        panel10 = (LinearLayout) findViewById(R.id.panel10);
        panel11 = (LinearLayout) findViewById(R.id.panel11);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);
        text8 = (TextView) findViewById(R.id.text8);
        text9 = (TextView) findViewById(R.id.text9);
        text10 = (TextView) findViewById(R.id.text10);
        text11 = (TextView) findViewById(R.id.text11);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);
        text5.setOnClickListener(this);
        text6.setOnClickListener(this);
        text7.setOnClickListener(this);
        text8.setOnClickListener(this);
        text9.setOnClickListener(this);
        text10.setOnClickListener(this);
        text11.setOnClickListener(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarfaq);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
}
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent i = new Intent(FaqActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return true;
    }
    @Override
    public void onClick(View v) {
        hideOthers(v);
    }
    private void hideThemAll() {
        if (openLayout == null) return;
        if (openLayout == panel1)
            panel1.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
        if (openLayout == panel2)
            panel2.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
        if (openLayout == panel3)
            panel3.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
        if (openLayout == panel4)
            panel4.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
        if (openLayout == panel5)
            panel5.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));
        if (openLayout == panel6)
            panel6.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel6, true));

        if (openLayout == panel7)
            panel7.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));
        if (openLayout == panel8)
            panel8.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel8, true));
        if (openLayout == panel9)
            panel9.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel9, true));

        if (openLayout == panel10)
            panel10.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel10, true));
        if (openLayout == panel11)
            panel11.startAnimation(new FaqActivity.ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel11, true));

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
                    panel1.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
                }
            } else if (layoutView.getId() == R.id.text2) {
                v = panel2.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel2.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
                }
            } else if (layoutView.getId() == R.id.text3) {
                v = panel3.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel3.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
                }
            } else if (layoutView.getId() == R.id.text4) {
                v = panel4.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel4.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
                }
            } else if (layoutView.getId() == R.id.text5) {
                v = panel5.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel5.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));
                }
            } else if (layoutView.getId() == R.id.text6) {
                v = panel6.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel6.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel6, true));
                }
            } else if (layoutView.getId() == R.id.text7) {
                v = panel7.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel7.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));
                }
            } else if (layoutView.getId() == R.id.text8) {
                v = panel8.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel8.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel8, true));
                }
            } else if (layoutView.getId() == R.id.text9) {
                v = panel9.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel9.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel9, true));
                }
            } else if (layoutView.getId() == R.id.text10) {
                v = panel10.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel10.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel10, true));
                }
            } else if (layoutView.getId() == R.id.text11) {
                v = panel11.getVisibility();
                hideThemAll();
                if (v != View.VISIBLE) {
                    panel11.startAnimation(new FaqActivity.ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel11, true));
                }
            }
        }
    }

    public class ScaleAnimToHide extends ScaleAnimation {
        private View mView;
        private LinearLayout.LayoutParams mLayoutParams;
        private int mMarginBottomFromY, mMarginBottomToY;
        private boolean mVanishAfter = false;
        public ScaleAnimToHide(float fromX, float toX, float fromY, float toY, int duration, View view, boolean vanishAfter) {
            super(fromX, toX, fromY, toY);
            setDuration(duration);
            openLayout = null;
            mView = view;
            mVanishAfter = vanishAfter;
            mLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int height = mView.getHeight();
            mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin - height;
            mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) - height;

            Log.v("CZ", "height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY + " , mMarginBottomToY.." + mMarginBottomToY);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                int newMarginBottom = mMarginBottomFromY + (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime);
                mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin, mLayoutParams.rightMargin, newMarginBottom);
                mView.getParent().requestLayout();
                //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
            } else if (mVanishAfter) {
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
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime) - mMarginBottomToY;
                mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin, mLayoutParams.rightMargin, newMarginBottom);
                mView.getParent().requestLayout();
            }
        }
    }
    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {
                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else {
            Log.v("TAG", "Permission is granted");
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
