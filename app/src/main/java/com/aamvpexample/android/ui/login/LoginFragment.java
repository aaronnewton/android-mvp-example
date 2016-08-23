package com.aamvpexample.android.ui.login;

import android.os.Bundle;

import com.aamvpexample.android.R;
import com.aamvpexample.android.ui.BaseFragment;
import com.aamvpexample.android.ui.BasePresenter;

public class LoginFragment extends BaseFragment {


    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    
    @Override
    protected int getLayoutResId() {
        return R.layout.login_fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
