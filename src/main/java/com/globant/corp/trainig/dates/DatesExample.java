package com.globant.corp.trainig.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DatesExample {

   public static final String DATE_FORMAT = "yyyy-MM-dd";
   public static final String DATE_TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSS";

   public static LocalDateTime getLocalDateTime() {
      return LocalDateTime.now();
   }

   public static LocalDate getLocalDate() {
      return LocalDate.now();
   }

   public static String formatLocalDate(final LocalDate localDate) {
      return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
   }

   public static String formatLocalDateTime(final LocalDateTime localDateTime) {
      return localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
   }

   public static String formatZonedDateTime(final ZonedDateTime zonedDateTime) {
      return zonedDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
   }

   public static boolean isLocalDateTimeAfterNow(final LocalDateTime localDateTime) {
      return LocalDateTime.now().isAfter(localDateTime);
   }

   public static boolean isLocalDateTimeBeforeNow(final LocalDateTime localDateTime) {
      return LocalDateTime.now().isBefore(localDateTime);
   }

   public static void printTwoInstantsAfterASecod() {
      final Instant start = Instant.now();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      final Instant end = Instant.now();
      System.out.println(String.format("Start: %s to End %s", start, end));
      System.out.println(String.format("Duration: %s", Duration.between(start, end)));
      System.out.println(String.format("Duration Millis: %s", Duration.between(start, end).toDays()));
      System.out.println(String.format("Duration Days: %s", Duration.between(start, end).toDays()));
      System.out.println(String.format("Duration Hours: %s", Duration.between(start, end).toHours()));
      System.out.println(String.format("Duration Minutes: %s", Duration.between(start, end).toMinutes()));
   }

   public static void printPeriodFromTimestampUnix() {
      final LocalDate start = LocalDate.of(1970, 1, 1);
      final LocalDate now = LocalDate.now();
      final Period period = Period.between(start, now);
      System.out.println(String.format("Was %s years with %s monthds and %s days sinse %s to now %s", period.getYears(), period.getMonths(),
            period.getDays(), formatLocalDate(start), formatLocalDate(now)));
   }

   public static void printNowGMT05AndGMT() {
      final LocalDateTime now = LocalDateTime.now();
      final ZonedDateTime now05 = now.atZone(ZoneId.of("US/Central"));
      final ZonedDateTime nowUTC = now05.withZoneSameInstant(ZoneId.of("UTC"));
      System.out.println(String.format("Now: %s and UTC: %s", formatZonedDateTime(now05), formatZonedDateTime(nowUTC)));
   }

   public static void printDatePlus(final int days, final int hous) {
      final LocalDateTime now = LocalDateTime.now();
      final LocalDateTime newDate = now.plusDays(days).plusHours(hous);
      System.out.println(String.format("Now: %s becomes %s", formatLocalDateTime(now), formatLocalDateTime(newDate)));
   }

}
