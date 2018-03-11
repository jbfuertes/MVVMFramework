package com.john.mvvmframework.model.ui_request;

/**
 * Created by john on 3/9/18.
 */

public final class CheckTimeEvent extends BookEvent{

    public final String time;
    public final String timeOut;

    public CheckTimeEvent(String time,String timeOut) {
        this.time = time;
        this.timeOut = timeOut;
    }
}
