package com.example.mtech.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Dipen on 2/24/2016.
 */

public class RequestPart extends Activity {

    public static TextView yearViewObj;
    public static TextView makeViewObj;
    public static TextView modelViewObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_a_part);

        yearViewObj = (TextView) findViewById(R.id.yearTxt);
        makeViewObj = (TextView) findViewById(R.id.makeTxt);
        modelViewObj = (TextView) findViewById(R.id.modelTxt);

        Intent myIntent = getIntent();
        String yearData = myIntent.getStringExtra("yearData");
        String makeData = myIntent.getStringExtra("makeData");
        String modelData = myIntent.getStringExtra("modelData");
        if(modelData != null){
            yearViewObj.setText(yearData);
            makeViewObj.setText(makeData);
            modelViewObj.setText(modelData);
        }
        ImageView previousActivity = (ImageView) findViewById(R.id.cancel_action);
        previousActivity.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(RequestPart.this,MainActivity.class);
                startActivity(nextActivity);
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
            }
        });



        RelativeLayout selectYear = (RelativeLayout) findViewById(R.id.select_a_year);
        selectYear.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(RequestPart.this,VehicleActivity.class);
                nextActivity.putExtra("data","Year");
                startActivity(nextActivity);
                //push from bottom to top
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        RelativeLayout selectMake = (RelativeLayout) findViewById(R.id.select_a_make);
        selectMake.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(RequestPart.this,VehicleActivity.class);
                nextActivity.putExtra("data","Make");
                startActivity(nextActivity);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        RelativeLayout selectModel = (RelativeLayout) findViewById(R.id.select_a_model);
        selectModel.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(RequestPart.this,VehicleActivity.class);
                nextActivity.putExtra("data","Model");
                startActivity(nextActivity);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });
    }
}