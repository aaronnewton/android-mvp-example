package com.aamvpexample.android.ui;

public interface ShowErrorBehaviour {
    void showError(int resId, Object ... args);

    void showError(String errorMessage);
}