package com.john.mvvmframework.model.ui_request;

/**
 * Created by john on 3/9/18.
 */

public final class SubmitEvent extends BookEvent{

    public final String time;
    public final String timeOut;
    public final String user;

    public SubmitEvent(String time,String timeOut,String user) {
        this.time = time;
        this.timeOut = timeOut;
        this.user = user;
    }
}
