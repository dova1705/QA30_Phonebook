package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    //precondition: login and add contact
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "altyn@gm.com");
        type(By.name("password"), "Altyn1234!");
        click(By.name("login"));

        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Bahar");
        type(By.cssSelector("input:nth-child(2)"), "Allakova");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "bahar@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Murgap");
        type(By.cssSelector("input:nth-child(6)"), "pupil");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }
    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        //click on the card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on the Remove button
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        //assert size of contact equals -1
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

}
