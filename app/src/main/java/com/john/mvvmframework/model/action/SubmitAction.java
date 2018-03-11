package com.john.mvvmframework.model.action;

/**
 * Created by john on 3/9/18.
 */

public class SubmitAction {

    public final String checkInTime;
    public final String checkOutTime;
    public final String user;

    public SubmitAction(String checkInTime, String checkOutTime, String user) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.user = user;
    }
}
