package com.john.mvvmframework.utils;

/**
 * Created by john on 11/23/17.
 */

public final class AppConstants {



    private AppConstants(){

    }

    public static final int VIEW_TYPE_FAILED = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    public static final int VIEW_TYPE_MESSAGE_FAILED = 4;

    public static final int VIEW_TYPE_MESSAGE_SENDING = 5;

    public static final int VIEW_TYPE_MESSAGE_RIGHT = 6;

    public static final int VIEW_TYPE_MESSAGE_LEFT = 7;

    public static final int VIEW_TYPE_MESSAGE_PROGRESS = 8;

    public static final int VIEW_TYPE_SOCIAL_MAIN = 9;

    public static final int VIEW_TYPE_SOCIAL_REPLY = 10;

    public static final int VIEW_TYPE_SOCIAL_PROGRESS = 11;

    public static final int VIEW_TYPE_SOCIAL_REPLY_SENDING = 11;

    public static final int VIEW_TYPE_SOCIAL_SENDING = 12;

    public static final String STATUS_CODE_SUCCESS = "success";

    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String PREF_NAME = "enguest_pref";

    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String DATE_FORMAT = "MM/dd/yyyy";

    public static final String DATE_FORMAT_1 = "MMMM dd,yyyy";

    public static final String DATE_FORMAT_2 = "yyyy-MM-dd";

    public static final String DATE_FORMAT_3 = "yyyy-MM-dd hh:mm a";

    public static final String DATE_FORMAT_4 = "yyyy-MM-dd hh:mm:ss";

    public static final String DATE_FORMAT_5 = "MMMM dd,yyyy hh:mm a";

    public static final String DATE_FORMAT_6 = "yyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final String DATE_FORMAT_7 = "hh:mm a";

    public static final String MIN_BIRTH_DAY = "12/31/1999";

    public static final String WEBSOCKET_TYPE_CONNECTION = "connection";

    public static final String WEBSOCKET_TYPE_DUTY_POINTS = "duty_points";

    public static final String WEBSOCKET_TYPE_REQUEST = "request";

    public static final String WEBSOCKET_TYPE_FOLLOW_UP = "follow_up";

    public static final String WEBSOCKET_TYPE_MESSAGE = "message";

    public static final String BUNDLE_CONVO_ID = "convoID";

    public static final String BUNDLE_CONVO_NAME = "name";

    public static final int CONVO_LIMIT = 20;

    public static final int SOCIAL_LIMIT = 10;

    public static final int SOCIAL_POSTED_AS = 0;


}
