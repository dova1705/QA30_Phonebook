package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTests extends TestBase{

    // log in
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "altyn@gm.com");
        type(By.name("password"), "Altyn1234!");
        click(By.name("login"));
    }

    @Test
    public void addNewContactPositiveTest(){
        //click Add link
        click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Bahar");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), "Allakova");
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "bahar@gm.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Murgap");
        //enter description
        type(By.cssSelector("input:nth-child(6)"), "pupil");
        //click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert contact iss added by text
        Assert.assertTrue(isContactCreated("Bahar"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

}
