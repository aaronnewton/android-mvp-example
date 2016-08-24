package com.aamvpexample.android.ui.login;

import com.aamvpexample.android.ui.BaseView;
import com.aamvpexample.android.ui.ShowErrorBehaviour;
import com.aamvpexample.android.ui.WaitingBehaviour;

public interface LoginView extends BaseView, WaitingBehaviour, ShowErrorBehaviour {

    void loginSuccessful();

    void displayEmailErrorMessage();
    
    void displayPasswordErrorMessage();
}
