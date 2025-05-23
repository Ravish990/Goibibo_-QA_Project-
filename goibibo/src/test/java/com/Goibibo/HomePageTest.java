package com.Goibibo;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Base;
import pages.HomePage;

public class HomePageTest extends Base {

    @BeforeMethod
    public void setDriverInContext(ITestContext context) {
        initialise();
        context.setAttribute("driver", driver); 
    }

    @Test(priority = 1)
    public void test1() {
        HomePage windows = new HomePage();
        windows.testHomePageElements();
       
    }
    @Test(priority = 2)
    public void test2() {
    	HomePage windows = new HomePage();
    	 windows.test1();
    }
}
