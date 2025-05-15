package com.Goibibo;

import org.testng.annotations.Test;

import pages.FlightBooking;

public class FlightAutomation {

	@Test
	public void test1() {
		FlightBooking fl = new FlightBooking();
		fl.bookFlight("Bengaluru", "Patna");
	}
}
