package com.Goibibo;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest {
	
	@Test(priority = 1)
	public void test1() {
		 HomePage windows = new HomePage();
		windows.testHomePageElements();
	}
}
