package com.example.mtech.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SupplierListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_list);

        ImageView previousActivity = (ImageView) findViewById(R.id.back_action);
        previousActivity.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                Log.v("cancel", " click");
            }
        });
    }
}
