package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){ // существует логин линк? если да ничего не делай
            app.getUser().clickOnSignOutButton(); // если нет кликай на clickOnSignOutButton()
        }
    }

    @Test
    public void registerExistedUserNegativeTest(){ // регистрация существующего пользователя (негативный тест)
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("altyn@gm.com").setPassword("Altyn1234!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent()); // проверь алерт, появляется тут можно написать любой getter
    }
}
