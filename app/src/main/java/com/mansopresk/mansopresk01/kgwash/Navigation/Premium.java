package com.mansopresk.mansopresk01.kgwash.Navigation;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mansopresk.mansopresk01.kgwash.R;

public class Premium extends AppCompatActivity {
    TextView cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);

        cost=(TextView)findViewById(R.id.basiccost);
       cost.setPaintFlags(cost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
