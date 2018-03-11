package com.john.mvvmframework.model.result;

import java.util.Collections;
import java.util.List;

/**
 * Created by john on 3/9/18.
 */

public class BookResult {

    public final boolean inFlight;
    public final boolean hasBooked;
    public final List<BookDate> bookDates;
    public final String errorMessage;

    public BookResult(boolean inFlight,
                      boolean hasBooked,
                      List<BookDate> bookDates,
                      String errorMessage) {
        this.inFlight = inFlight;
        this.hasBooked = hasBooked;
        this.bookDates = Collections.unmodifiableList(bookDates);
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
