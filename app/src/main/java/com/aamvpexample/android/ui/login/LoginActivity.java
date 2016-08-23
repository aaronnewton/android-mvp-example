package com.aamvpexample.android.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aamvpexample.android.R;
import com.aamvpexample.android.ui.BaseActivity;

public class LoginActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, LoginFragment.newInstance())
                .commit();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.base_activity;
    }
}
