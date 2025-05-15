package com.Goibibo;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
         loginPage.Login();
    }
}
