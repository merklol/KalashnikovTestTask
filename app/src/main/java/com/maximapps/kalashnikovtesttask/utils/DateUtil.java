package com.maximapps.kalashnikovtesttask.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String formatDate(Date date) {
        var pattern = "dd.MM.yyyy";
        var simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return simpleDateFormat.format(date);
    }
}
