package com.mansopresk.mansopresk01.kgwash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import com.mansopresk.mansopresk01.kgwash.Navigation.NavigationMainActivity;
import java.util.Timer;
import java.util.TimerTask;


public class BookNowActivity extends AppCompatActivity {
    RadioButton washfold,washiron,iron;
    Button order;
    ViewPager viewPager;
    private BookPageAdapter myViewPagerAdapter;
    private int[] layouts;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        viewPager = (ViewPager) findViewById(R.id.indicator_image);
        washfold = (RadioButton) findViewById(R.id.washfold_button);
        washiron = (RadioButton) findViewById(R.id.washiron_button);
        iron = (RadioButton) findViewById(R.id.iron_button);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarbook);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BookNowActivity.this, NavigationMainActivity.class);
                startActivity(i);
            }
        });
        layouts = new int[]{
                R.layout.wash_iron,
                R.layout.wash_fold,
                R.layout.iron};
        myViewPagerAdapter = new BookPageAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
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
        findViewById(R.id.placeorder).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(BookNowActivity.this,ScheduleActivity.class);
         startActivity(i);
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
        Intent i = new Intent(BookNowActivity.this,NavigationMainActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
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
