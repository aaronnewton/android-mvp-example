package com.aamvpexample.android.job;

import android.support.annotation.NonNull;

import com.aamvpexample.android.R;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import org.greenrobot.eventbus.EventBus;

import timber.log.Timber;

public class LoginJob extends BaseJob {

    private final EventBus mEventBus;

    private final String mEmail;
    private final String mPassword;

    public LoginJob(Params params, EventBus eventBus, String email, String password) {
        super(params);
        mEventBus = eventBus;
        mEmail = email;
        mPassword = password;
    }

    @Override
    public void onRun() throws Throwable {
        //TODO Validate input data, if valid continue else throw LoginException


        //TODO Execute api request
        //TODO check it request isSuccessful

        //TODO If isSuccessful = false then post FinishedEvent(false) on EventBus
        //TODO If isSuccessful = true, persist response data

        //TODO once data is persisted then post FinishedEvent(true) on EventBus
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        Timber.e("resolveThrowable %s %s", runCount, throwable.getMessage());
        mEventBus.post(new FinishedEvent(false));
        return new RetryConstraint(false);
    }

    public static class FinishedEvent extends BaseFinishedEvent {

        public FinishedEvent(boolean success) {
            super(success);
        }
    }

    public enum LoginFailedReason {
        NETWORK_ERROR(R.string.network_error_reason),
        EMAIL_ALREADY_USED(R.string.email_already_used_error_reason),
        EMAIL_ERROR(R.string.invalid_email_error_reason),
        PASSWORD_ERROR(R.string.invalid_password_error_reason);

        private int mResId;

        LoginFailedReason(int resId) {
            mResId = resId;
        }

        public int getStringResource() {
            return mResId;
        }
    }

    public class LoginException extends Exception {
        public LoginException(String s) {
            super(s);
        }

        public LoginException(Throwable throwable) {
            super(throwable);
        }
    }
}
