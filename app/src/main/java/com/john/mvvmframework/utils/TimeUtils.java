package com.john.mvvmframework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class TimeUtils {

    private TimeUtils(){

    }

    public static String getTime(String format){
        /*"dd-MMM-yyyy"*/
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    public static boolean isBeforeNow(String format,String date){
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String timeNow = sdf.format(calendar.getTime());
            Date strDate = sdf.parse(date);
            Date currentDate = sdf.parse(timeNow);
            if (currentDate.getTime() > strDate.getTime()) {
                return true;
            }
            else return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int compareTime(String format,String date1,String date2){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date strDate1 = sdf.parse(date1);
            Date strDate2 = sdf.parse(date2);
            if (strDate1.after(strDate2)) {
                return 1;
            }
            else return 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Date getDate(String format,String date){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDate(String format,int year,int month,int day){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return sdf.format(cal.getTime());
    }

    public static String getDate(String format,int year,int month,int day,int hour,int minute){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,minute);
        return sdf.format(cal.getTime());
    }

    public static String formatDate(String format,String fromFormat,String date){
        SimpleDateFormat fromDate = new SimpleDateFormat(fromFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date dateToFormat = fromDate.parse(date);
            return sdf.format(dateToFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    //yyyy-MM-dd hh:mm:ss
    public static String elapsedTime(String startDate){
        long elapsedHour,remainderMins;
        if (elapsedMins(startDate) == 0) {
            return "A moment ago";
        } else if (elapsedMins(startDate) >= 60) {
            elapsedHour = elapsedMins(startDate) / 60;
            remainderMins = elapsedMins(startDate) % 60;
            String hours = ((elapsedHour>1)?" hours":" hour");
            String mins = ((remainderMins>1)?" mins":" min");
            return (elapsedHour + hours+" and\n" + remainderMins + mins+" ago");
        } else {
            String mins = ((elapsedMins(startDate)>1)?" mins":" min");
            return (elapsedMins(startDate) + mins +" ago");
        }
    }

    public static long elapsedMins(String startDate){
        /*Calendar calendar;
        int day,hour,min;
        int startMins,currentMins;
        calendar = Calendar.getInstance();
        day = Math.abs(calendar.get(Calendar.DAY_OF_MONTH) - Integer.parseInt(startDate.substring(8, 10)));
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        startMins = (Integer.parseInt(startDate.substring(11, 13)) * 60) + Integer.parseInt(startDate.substring(14, 16));
        currentMins = ((day>0)? ((day * 24 * 60) + (hour*60) + min):((hour * 60) + min));
        return currentMins - startMins;*/

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {

            Date oldDate = dateFormat.parse(startDate);
            System.out.println(oldDate);

            Date currentDate = new Date();

            long diff = currentDate.getTime() - oldDate.getTime();
            long seconds = diff / 1000;
            long minutes = seconds / 60;

            return minutes;


        } catch (ParseException e) {

            e.printStackTrace();
            return 0;
        }

    }


}
