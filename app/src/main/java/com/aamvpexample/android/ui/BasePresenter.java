package com.aamvpexample.android.ui;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BasePresenter<T extends BaseView> {

    protected EventBus mEventBus;
    protected T mView;

    public BasePresenter(T view, EventBus eventBus) {
        mView = view;
        mEventBus = eventBus;
    }

    public void setView(T view) {
        mView = view;
    }

    public void onResume() {
        mEventBus.register(this);
    }

    public void onPause() {
        mEventBus.unregister(this);
    }

    @Subscribe
    public void onNullEvent(NullEvent e) {
        // Empty method - this is just to stop green robot complaining because of
        // sub classes not actually subscribing to events.
    }

    private class NullEvent {
    }

}
