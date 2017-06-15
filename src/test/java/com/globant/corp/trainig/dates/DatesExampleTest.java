package com.globant.corp.trainig.dates;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;

public class DatesExampleTest {

   @Before
   public void setUp() throws Exception {
   }

   @Test
   public void getLocalDateTimeTest() {
      final LocalDateTime result = DatesExample.getLocalDateTime();
      System.out.println(result);
      assertNotNull(result);
   }

   @Test
   public void getLocalDateTest() {
      final LocalDate result = DatesExample.getLocalDate();
      System.out.println(result);
      assertNotNull(result);
   }

   @Test
   public void formatLocalDateTest() {
      final String result = DatesExample.formatLocalDate(LocalDate.now());
      System.out.println(result);
      assertNotNull(result);
   }

   @Test
   public void formatLocalDateTimeTest() {
      final String result = DatesExample.formatLocalDateTime(LocalDateTime.now());
      System.out.println(result);
      assertNotNull(result);
   }

   @Test
   public void formatZonedDateTimeTest() {
      final String result = DatesExample.formatZonedDateTime(ZonedDateTime.now());
      System.out.println(result);
      assertNotNull(result);
   }

   @Test
   public void isLocalDateTimeBeforeNowTest() {
      assertTrue(DatesExample.isLocalDateTimeAfterNow(LocalDateTime.now().plusNanos(-1L)));
   }

   @Test
   public void printTwoInstantsAfterASecodTest() {
      DatesExample.printTwoInstantsAfterASecod();
      assertTrue(true);
   }

   @Test
   public void printPeriodFromTimestampUnixTest() {
      DatesExample.printPeriodFromTimestampUnix();
      assertTrue(true);
   }

   @Test
   public void printNowGMT05AndGMTTest() {
      DatesExample.printNowGMT05AndGMT();
      assertTrue(true);
   }

   @Test
   public void printDatePlusTest() {
      DatesExample.printDatePlus(32, 25);
      assertTrue(true);
   }

}
