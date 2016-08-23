package com.aamvpexample.android;

import android.app.Application;
import android.content.Context;

import com.birbit.android.jobqueue.JobManager;

public class App extends Application {

    private JobManager mJobManager;
//    private JobFactory mJobFactory;
//    private DomainStorage mDomainStorage;
//    private RestClient mRestClient;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
