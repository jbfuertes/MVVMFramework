package com.john.mvvmframework.model.action;

/**
 * Created by john on 3/9/18.
 */

public final class CheckTimeAction {

    public final String bookTime;
    public final String checkOutTime;


    public CheckTimeAction(String bookTime,String checkOutTime) {
        this.bookTime = bookTime;
        this.checkOutTime = checkOutTime;
    }
}
