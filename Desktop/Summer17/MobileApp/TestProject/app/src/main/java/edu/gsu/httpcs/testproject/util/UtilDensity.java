package edu.gsu.httpcs.testproject.util;

import android.content.Context;

/**
 * Created by spri0 on 6/21/17.
 */

public class UtilDensity {

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}