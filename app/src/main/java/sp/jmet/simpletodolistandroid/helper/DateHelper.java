package sp.jmet.simpletodolistandroid.helper;

import java.util.Calendar;
import java.util.Date;

import sp.jmet.simpletodolistandroid.model.DateModel;

public class DateHelper {

    public static DateModel getCurrentDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return new DateModel(year, month, day);
    }

    public static String parseDateToString(int year, int month, int day) {
        return day + " " + getMonthToStringFormat(month) + " " + year;
    }

    private static String getMonthToStringFormat(int month) {
        switch(month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                throw new Error("Month has to be along 1 to 12");
        }
    }

    private static int getMonthToIntFormat(String month) {
        switch (month) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    public static Date parseStringToDate(String date, Calendar cal) {
        String[] dateSplit = date.split(" ");

        int dayOfMonth = Integer.parseInt(dateSplit[0]);

        String monthName = dateSplit[1];
        int monthNumber = getMonthToIntFormat(monthName);
        int month = monthNumber - 1;

        int year = Integer.parseInt(dateSplit[2]);

        cal.set(year, month, dayOfMonth);
        return cal.getTime();
    }

}
