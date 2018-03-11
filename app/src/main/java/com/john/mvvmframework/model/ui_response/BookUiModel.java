package com.john.mvvmframework.model.ui_response;

import java.util.Collections;
import java.util.List;

/**
 * Created by john on 3/9/18.
 */

public final class BookUiModel {

    public final List<BookDate> bookDates;
    public final Boolean inProgress;
    public final String errorMessage;

    public BookUiModel(List<BookDate> bookDates, Boolean inProgress, String errorMessage) {
        this.bookDates = bookDates;
        this.inProgress = inProgress;
        this.errorMessage = errorMessage;
    }

    public static final class BookDate{
        public final String bookTime;
        public final String checkOutTime;
        public final String user;

        public BookDate(String bookTime,String checkOutTime, String user) {
            this.bookTime = bookTime;
            this.checkOutTime = checkOutTime;
            this.user = user;
        }
    }


}
