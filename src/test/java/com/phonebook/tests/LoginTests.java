package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginRegisteredUserPositiveTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "altyn@gm.com");
        //enter password
        type(By.name("password"), "Altyn1234!");
        //click on Login button
        click(By.name("login"));
        //Assert Log Out button is present
        Assert.assertTrue(isElementPresent(By.cssSelector("button")));
    }
}
