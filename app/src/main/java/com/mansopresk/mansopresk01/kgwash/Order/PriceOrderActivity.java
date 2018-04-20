package com.mansopresk.mansopresk01.kgwash.Order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;



import com.mansopresk.mansopresk01.kgwash.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PriceOrderActivity extends AppCompatActivity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    Spinner spinner;
    Button saveorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_order);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(PriceOrderActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        saveorder=findViewById(R.id.ordersave);
        saveorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PriceOrderActivity.this,TypeOfPaymentActivity.class);
                startActivity(i);
            }
        });

        spinner=findViewById(R.id.spinner);


        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                showToastMsg(group_name + "n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;


        child_list = new ArrayList<Child>();
        Group gru1 = new Group();
        gru1.setName("Men");

        Child ch1_1 = new Child();
        ch1_1.setName("shirt");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("Phant");
        child_list.add(ch1_2);

        Child ch1_3 = new Child();
        ch1_3.setName("T-shitrs");
        child_list.add(ch1_3);

        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("Women");

        Child ch2_1 = new Child();
        ch2_1.setName("dress");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("night dress ");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("tops");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("phants");
        child_list.add(ch2_4);

        gru2.setItems(child_list);

        child_list = new ArrayList<Child>();
        Group gru3 = new Group();
        gru3.setName("kid");

        Child ch3_1 = new Child();
        ch3_1.setName("shirt");
        child_list.add(ch1_1);

        Child ch3_2 = new Child();
        ch3_2.setName("Phant");
        child_list.add(ch1_2);

        Child ch3_3 = new Child();
        ch3_3.setName("T-shitrs");
        child_list.add(ch1_3);

        gru3.setItems(child_list);


        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(gru3);

        return group_list;
    }

    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }

}
