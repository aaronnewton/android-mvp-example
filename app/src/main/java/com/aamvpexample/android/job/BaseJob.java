package com.aamvpexample.android.job;

import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;


public abstract class BaseJob extends Job {

    public BaseJob(Params params) {
        super(params);
    }

    @Override
    public void onAdded() {

    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

}
