package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    //precondition: login and add contact
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("altyn@gm.com")
                .setPassword("Altyn1234!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Bahar")
                .setLastname("Allakova")
                .setPhone("1234567890")
                .setEmail("bahar@gm.com")
                .setAddress("Murgap")
                .setDescription("pupil"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on the card
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //assert size of contact equals -1
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
