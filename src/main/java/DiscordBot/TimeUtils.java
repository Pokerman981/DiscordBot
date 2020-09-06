package DiscordBot;

import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static int timeAmount(String time) {
        TimeUnit unit = TimeUnit.SECONDS;
        char[] t = time.toCharArray();
        int breakPoint = 0;
        String amount = "";
        int parsedAmount = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 's' || t[i] == 'S') {
                unit = TimeUnit.SECONDS;
                breakPoint = i;
                break;
            }	else if (t[i] == 'm' || t[i] == 'M') {
                unit = TimeUnit.MINUTES;
                breakPoint = i;
                break;
            }	else if (t[i] == 'h' || t[i] == 'H') {
                unit = TimeUnit.HOURS;
                breakPoint = i;
                break;
            }	else if (t[i] == 'd' || t[i] == 'D') {
                unit = TimeUnit.DAYS;
                breakPoint = i;
                break;
            }
        }

        for (int i = 0; i < breakPoint; i++) {
            amount += t[i];
        }
        parsedAmount = Integer.parseInt(amount);
        return parsedAmount;
    }


    public static TimeUnit timeUnit(String time) {
        TimeUnit unit = TimeUnit.SECONDS;
        char[] t = time.toCharArray();
        String amount = "";
        int parsedAmount = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 's' || t[i] == 'S') {
                unit = TimeUnit.SECONDS;
                break;
            }	else if (t[i] == 'm' || t[i] == 'M') {
                unit = TimeUnit.MINUTES;
                break;
            }	else if (t[i] == 'h' || t[i] == 'H') {
                unit = TimeUnit.HOURS;
                break;
            }	else if (t[i] == 'd' || t[i] == 'D') {
                unit = TimeUnit.DAYS;
                break;
            }
        }
        return unit;
    }

}
