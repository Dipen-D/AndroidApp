package com.example.mtech.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleActivity extends AppCompatActivity implements java.io.Serializable {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    String activePage = "";
    VehicleMessage vehicleData = new VehicleMessage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Intent myIntent = getIntent();
        activePage = myIntent.getStringExtra("data");
        String listData[] = new String[0];

        String years[] = {"2016", "2015", "2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002",
                "2001","2000","1999","1998","1997","1996","1995"};

        String makes[] = {"Acura","Aston Martin","Audi","Bentley","BMW","Bugatti","Buick","Cadillac","Chevrolet","Chrysler","Dodge","Ferrari","Ford","GMC","Honda","Hyundai","Infiniti","Jaguar","Jeep","Kia","Lamborghini","Land Rover","Lexus","Lincoln","Lotus","Mahindra And Mahindra","Maserati","Maybach","Mazda"};

        String models[] = {"A3","A4","A5","A6","A8","Q7","R8","RS4","S4","S5","S6","S8","Tt"};
        // Listview Data
        switch (activePage){
            case "Year":
                listData = years;
                break;

            case "Make":
                listData = makes;
                break;

            case "Model":
                listData = models;
                break;
        }

        lv = (ListView) findViewById(R.id.vehicle_list);
        inputSearch = (EditText) findViewById(R.id.search_bar);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.vehivle_list, R.id.vehicle_item, listData);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.vehicle_item);
                String selectedData = textView.getText().toString();
                Log.d("selectedData",selectedData);
                Intent nextActivity;
                switch (activePage){
                    case "Year":
                        nextActivity = new Intent(VehicleActivity.this,VehicleActivity.class);
                        nextActivity.putExtra("data","Make");
                        RequestPart.yearViewObj.setText(selectedData);
                        startActivity(nextActivity);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                        break;

                    case "Make":
                        nextActivity = new Intent(VehicleActivity.this,VehicleActivity.class);
                        nextActivity.putExtra("data","Model");
                        RequestPart.makeViewObj.setText(selectedData);
                        startActivity(nextActivity);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                        break;

                    case "Model":
                        nextActivity = new Intent(VehicleActivity.this,RequestPart.class);
                        RequestPart.modelViewObj.setText(selectedData);
                        nextActivity.putExtra("yearData",RequestPart.yearViewObj.getText());
                        nextActivity.putExtra("makeData",RequestPart.makeViewObj.getText());
                        nextActivity.putExtra("modelData",RequestPart.modelViewObj.getText());
                        startActivity(nextActivity);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                        break;
                }
            }});

        ImageView backBtn = (ImageView) findViewById(R.id.back_action);
        backBtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                VehicleActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
