package com.maximapps.kalashnikovtesttask.utils;

import static com.maximapps.kalashnikovtesttask.utils.DateUtil.formatDate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtilTest {

    @Test
    public void verify_date_formatted_correctly() throws Exception {
        String expected = "19.02.1950";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        assertEquals(expected, formatDate(format.parse("19.02.1950")));
    }
}
