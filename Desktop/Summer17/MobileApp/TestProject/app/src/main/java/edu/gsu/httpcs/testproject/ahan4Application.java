package edu.gsu.httpcs.testproject;

import android.app.Application;

import edu.gsu.httpcs.testproject.util.UtilLog;
/**
 * Created by spri0 on 6/21/17.
 */

public class ahan4Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}