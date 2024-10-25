package com.wangyousong.practice.whatever;

import org.apache.commons.validator.routines.DateValidator;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class CommonValidatorTest {

    @Test
    void givenDate_whenValidationIsCalled_thenChecksDate() {
        DateValidator validator = DateValidator.getInstance();
        String validDate = "28/01/2024";
        String invalidDate = "28/13/2024";

        assertNotNull(validator.validate(validDate, "dd/MM/yyyy"));
        assertTrue(validator.isValid(validDate, "dd/MM/yyyy"));

        assertNull(validator.validate(invalidDate, "dd/MM/yyyy"));
        assertFalse(validator.isValid(invalidDate, "dd/MM/yyyy"));

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2024, Calendar.JANUARY, 28, 10, 30);
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = gregorianCalendar.getTime();

        assertEquals("28-Jan-2024", validator.format(date, "dd-MMM-yyyy"));

        TimeZone timeZone = TimeZone.getTimeZone("GMT+5");
        assertEquals("28/01/2024 15:30", validator.format(date, "dd/MM/yyyy HH:mm", timeZone));
    }
}
