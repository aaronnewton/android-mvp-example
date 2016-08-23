package com.aamvpexample.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aamvpexample.android.R;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        resumePresenter();
    }

    @Override
    public void onPause() {
        super.onPause();
        pausePresenter();
    }

    private void resumePresenter() {
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    private void pausePresenter() {
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    protected int goToNextFragment(Fragment fragment, String backStackTag) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(getParentContainer(), fragment);

        if (backStackTag != null) {
            fragmentTransaction.addToBackStack(backStackTag);
        }

        return fragmentTransaction.commitAllowingStateLoss();
    }

    protected abstract int getLayoutResId();

    protected abstract BasePresenter getPresenter();

    protected int getParentContainer() {
        return R.id.content;
    }


}

