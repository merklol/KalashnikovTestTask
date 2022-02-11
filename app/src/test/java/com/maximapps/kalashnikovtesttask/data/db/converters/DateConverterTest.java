package com.maximapps.kalashnikovtesttask.data.db.converters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Date;

public class DateConverterTest {

    @Test
    public void verify_timestamp_converts_to_date_correctly() {
        Date date = new Date();
        assertEquals(date, DateConverter.fromTimestamp(date.getTime()));
    }

    @Test
    public void verify_date_converts_to_timestamp_correctly() {
        Date sampleDate = new Date();
        Long expected = sampleDate.getTime();
        assertEquals(expected, DateConverter.dateToTimestamp(sampleDate));
    }

}