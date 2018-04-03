package com.example.mansopresk01.Washing.Indicator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.mansopresk01.Washing.NavigationMainActivity;
import com.example.mansopresk01.kgshopping.R;

public class SplashActivity extends Activity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;


    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "indicator";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        if(isFirstTimeLaunch())
        {
            Intent i=new Intent(this, com.example.mansopresk01.Washing.Indicator.WelcomeActivity.class);
           setFirstTimeLaunch(true);
            startActivity(i);
        }
        else {

            int SPLASH_TIME_OUT = 3000;
            new Handler().postDelayed(new Runnable()

            {
                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    // Start your app main activity

                    Intent i = new Intent(com.example.mansopresk01.Washing.Indicator.SplashActivity.this, NavigationMainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
    public boolean isFirstTimeLaunch()
    {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
    }

