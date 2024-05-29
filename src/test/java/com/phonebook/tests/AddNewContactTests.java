package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("altyn@gm.com").setPassword("Altyn1234!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Bahar")
                .setLastname("Allakova")
                .setPhone("1234567890")
                .setEmail("bahar@gm.com")
                .setAddress("Murgap")
                .setDescription("pupil"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Bahar"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }
}
