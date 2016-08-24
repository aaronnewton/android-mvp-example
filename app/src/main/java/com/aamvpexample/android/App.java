package com.aamvpexample.android;

import android.app.Application;
import android.content.Context;

import com.aamvpexample.android.job.JobFactory;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;

import org.greenrobot.eventbus.EventBus;

public class App extends Application {

    private JobManager mJobManager;
    private JobFactory mJobFactory;
//    private DomainStorage mDomainStorage;
//    private RestClient mRestClient;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        initAPIService();
//        initDomainStorage();
        initJobManager();
//        if (mDomainStorage != null && mRestClient != null) {
//            initJobFactory();
//        }
    }

    private void initJobManager() {
        Configuration.Builder builder = new Configuration.Builder(this);
        mJobManager = new JobManager(builder.build());
    }

    public synchronized JobManager getJobManager() {
        return mJobManager;
    }

    private void initJobFactory() {
        if (mJobFactory == null) {
//            mJobFactory = new JobFactory(EventBus.getDefault(), mDomainStorage, mRestClient);
            mJobFactory = new JobFactory(EventBus.getDefault());
        }
    }

    public JobFactory getJobFactory() {
        return mJobFactory;
    }
}
