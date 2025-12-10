package com.saucedemo.f2x.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login  extends PageObject {

    public static final Target TXT_USERNAME = Target.the("Digitar username")
            .located(By.cssSelector("input[placeholder='Username']"));
    public static final Target TXT_PASSWORD = Target.the("Digitar Password")
            .located(By.cssSelector("input[placeholder='Password']"));
    public static final Target BTN_LOGIN = Target.the("Botòn login")
            .located(By.id("login-button"));
    public static final Target LBL_PAGE = Target.the("Titulo ingreso")
            .located(By.cssSelector(".app_logo"));
}
