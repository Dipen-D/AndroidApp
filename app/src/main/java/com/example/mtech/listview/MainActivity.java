package com.example.mtech.listview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

import android.widget.ListView;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends Activity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.accompressor ,R.drawable.belttensioner,R.drawable.bumper,R.drawable.doorhandle,R.drawable.accontrols,R.drawable.accompressor,R.drawable.bumper,R.drawable.doorhandle,R.drawable.accondensercoolingfan,R.drawable.doorhandle,R.drawable.accontrols,R.drawable.accompressor};
    public static String [] prgmNameList={"AC compressor","Belt tensioner","Bumper","Door handle","AC controls","AC compressor","Bumper","Door handler","Cooling fan","Door handler","AC controls","AC compressor"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

        /*StickyListHeadersListView stickyList = (StickyListHeadersListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this);
        stickyList.setAdapter(adapter);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}