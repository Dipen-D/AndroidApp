package com.example.mtech.listview;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    StickyListHeadersListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.accompressor ,R.drawable.belttensioner,R.drawable.bumper,R.drawable.doorhandle,R.drawable.accontrols,R.drawable.accompressor,R.drawable.bumper,R.drawable.doorhandle,R.drawable.accondensercoolingfan};
    public static String [] prgmNameList={"AC compressor","Belt tensioner","Bumper","Door handle","AC controls","AC compressor","Bumper","Door handler","Cooling fan"};
    public static int [] prgmTimeDuration={39, 39, 39, 39, 3, 3, 3, 5, 5 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(StickyListHeadersListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(this, prgmNameList, prgmImages, prgmTimeDuration);
        lv.setAdapter(customAdapter);

        FloatingActionButton myFab = (FloatingActionButton)  findViewById(R.id.myFAB);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextActivity = new Intent(MainActivity.this,RequestPart.class);
                startActivity(nextActivity);
                //push from bottom to top
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}