package com.aamvpexample.android.ui.login;

import com.aamvpexample.android.R;
import com.aamvpexample.android.job.LoginJob;
import com.aamvpexample.android.ui.BasePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view, EventBus eventBus) {
        super(view, eventBus);
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
