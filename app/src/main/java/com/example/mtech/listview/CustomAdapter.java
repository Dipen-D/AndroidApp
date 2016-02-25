package com.example.mtech.listview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.util.Random;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class CustomAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    String [] result;
    Context context;
    int [] imageId;
    int [] timeDuration;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages, int[] prgmTimeDuration) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        timeDuration=prgmTimeDuration;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return result[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.header_view_holder, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //set header text as first char in name

        String headerText = null;
        switch (timeDuration[position])
        {
            case 39: headerText = "Today";
                        break;
            case 3: headerText = "Yesterday";
                        break;
            case 5:
            case 7: headerText = "Earlier";
                        break;
        }

        //String headerText = "" + result[position].subSequence(0, 1).charAt(0);
        holder.text.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int i) {
        Random random = new Random();
        Log.d("Time", MilisecondsConverter.msToString(1456229372005L));
        //Log.d("myTag", String.valueOf(timeDuration[i]));
        return timeDuration[i];
    }

    public class Holder
    {
        TextView tv;
        TextView textView;
        ImageView img;
    }

    class HeaderViewHolder {
        TextView text;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.program_list, parent, false);
            holder.tv = (TextView) convertView.findViewById(R.id.textView1);
            holder.img=(ImageView) convertView.findViewById(R.id.imageView1);
            holder.textView = (TextView) convertView.findViewById(R.id.textView3);
            holder.tv.setText(result[position]);
            holder.img.setImageResource(imageId[position]);

            holder.textView.setText(String.valueOf(timeDuration[position]));
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(result[position]);
        bindClick(holder);
        return convertView;
    }

    private void bindClick(Holder holder) {
        try {
            holder.img.setOnClickListener(new View.OnClickListener() {
                //@Override
                public void onClick(View v) {
                    Intent nextActivity = new Intent(context,SupplierListActivity.class);
                    Activity activity = (Activity) context;
                    activity.startActivity(nextActivity);
                    //push from bottom to top
                    activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
