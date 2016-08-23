package com.aamvpexample.android.job;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;

import org.greenrobot.eventbus.EventBus;

public class JobFactory {

    public static final int LOW_PRIORITY = 0;
    public static final int NORMAL_PRIORITY = 1;
    public static final int HIGH_PRIORITY = 2;

    private final EventBus mEventBus;
//    private final DomainStorage mDomainStorage;
//    private final RestClient mRestClient;


    public JobFactory(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public Job getLoginJob(String email, String password) {
        Params params = new Params(HIGH_PRIORITY).requireNetwork();
        return new LoginJob(params, mEventBus, email, password);
    }
}
