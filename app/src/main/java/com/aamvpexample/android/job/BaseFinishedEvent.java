package com.aamvpexample.android.job;

public abstract class BaseFinishedEvent {

    private boolean mSuccess;

    public BaseFinishedEvent(boolean success) {
        mSuccess = success;
    }

    public boolean isSuccess() {
        return mSuccess;
    }

    public void setSuccess(boolean success) {
        mSuccess = success;
    }
}

