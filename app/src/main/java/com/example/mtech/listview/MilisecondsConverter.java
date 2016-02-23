package com.example.mtech.listview;

import java.util.Calendar;

/**
 * Created by Mtech on 2/23/2016.
 */
public class MilisecondsConverter {

    public static String msToString(long ms) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        return mDay + "/" + mMonth + "/" + mYear;
    }
}
