/**
 * 
 */
package com.ss.asgn5.DateTime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author dlance
 *
 */
public class DateTime {

	/*
	 * 1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
	 * 		LocalDateTime
	 */
	
	// 2. Given a random date, how would you find the date of the previous Thursday?
	LocalDate previousThursday(LocalDate date) {
		return date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
	}
	
	/*
	 * 3. What is the difference between a ZoneId and a ZoneOffset?
	 * 		ZoneId describes a time-zone identifier
	 * 		ZoneOffset describes the amount of time in hours by which a time zone differs from the UTC time zone
	 */
	
	// 5. Write an example that, for the given year, reports the length of each month within that year
	void reportMonthLengths(Year year) {
		for (int month = 1; month <= 12; month++) {
			int length = year.atMonth(month).lengthOfMonth();
			System.out.format("%s has %d days\n", year.atMonth(month).getMonth(), length);
		}
	}
	
	// 6. Write an example that, for the given month of the current year, lists all of the Mondays in that month.
	void reportAllMondays(YearMonth month) {
		System.out.println("Mondays:");
		
		LocalDate firstMonday = month.atDay(1).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		for (LocalDate day = firstMonday; !day.isAfter(month.atEndOfMonth()); day = day.plusWeeks(1)) {
			System.out.println(day.format(DateTimeFormatter.ofPattern("MMMM dd")));
		}
	}
	
	// Write an example that tests whether a given date occurs on Friday the 13th.
	boolean isFriday13th(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
	}
	
	public static void main(String[] args) {
		// 4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an instant?
		Instant instant = Instant.now();
		ZonedDateTime zoned = instant.atZone(ZoneId.of("America/Los_Angeles"));
		
		// convert back to instant
		zoned.toInstant();
	}
}
