package com.aamvpexample.android.ui;

import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackBarShowErrorBehaviour implements ShowErrorBehaviour {

    private View mView;

    public SnackBarShowErrorBehaviour(View view) {
        mView = view;
    }

    @Override
    public void showError(String message) {
        final Snackbar snackbar = Snackbar.make(mView, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(android.R.string.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public void showError(int resId, Object... args) {
        final Snackbar snackbar = Snackbar.make(mView, mView.getResources().getString(resId, args), Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(android.R.string.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

}
