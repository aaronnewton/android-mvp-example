package com.aamvpexample.android.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.aamvpexample.android.App;
import com.aamvpexample.android.R;
import com.aamvpexample.android.ui.BaseFragment;
import com.aamvpexample.android.ui.BasePresenter;
import com.aamvpexample.android.ui.ShowErrorBehaviour;
import com.aamvpexample.android.ui.SnackBarShowErrorBehaviour;
import com.aamvpexample.android.ui.WaitingBehaviour;

import org.greenrobot.eventbus.EventBus;

public class LoginFragment extends BaseFragment implements LoginView {

    private LoginPresenter mPresenter;
    private ShowErrorBehaviour mShowErrorBehaviour;
    private WaitingBehaviour mWaitingBehaviour;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new LoginPresenter(this, EventBus.getDefault(),
                App.get(getContext()).getJobManager(),
                App.get(getContext()).getJobFactory());

        mShowErrorBehaviour = new SnackBarShowErrorBehaviour(getView());
//        mHideKeyboardBehaviour = new HideKeyboardBehaviour(getView());
//
//        mEmailInput.addTextChangedListener(mTextWatcher);
//        mPasswordInput.addTextChangedListener(mTextWatcher);
//        mSubmitButton.setEnabled(false);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.login_fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }


    @Override
    public void loginSuccessful() {

    }

    @Override
    public void displayEmailErrorMessage() {

    }

    @Override
    public void displayPasswordErrorMessage() {

    }

    @Override
    public void showError(int resId, Object... args) {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showWaiting() {

    }

    @Override
    public void hideWaiting() {

    }
}
