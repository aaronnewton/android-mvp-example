package com.aamvpexample.android.ui.login;

import com.aamvpexample.android.R;
import com.aamvpexample.android.job.JobFactory;
import com.aamvpexample.android.job.LoginJob;
import com.aamvpexample.android.ui.BasePresenter;
import com.birbit.android.jobqueue.JobManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginPresenter extends BasePresenter<LoginView> {

    private JobManager mJobManager;
    private JobFactory mJobFactory;

    public LoginPresenter(LoginView view, EventBus eventBus, JobManager jobManager, JobFactory jobFactory) {
        super(view, eventBus);
        mJobManager = jobManager;
        mJobFactory = jobFactory;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    void onLoginJobFinished(LoginJob.FinishedEvent event) {
        mView.hideWaiting();
        if (!event.isSuccess()) {
            mView.showError(R.string.generic_error_reason);
            return;
        }
        mView.loginSucceful();
    }
}
