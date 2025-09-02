package com.calidda.ov.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login  extends PageObject {

    public static final Target TXT_USER= Target.the("Ingresar usuario").located(By.id("personEmail"));
    public static final Target TXT_CLAVE= Target.the("Ingresar clave").located(By.id("personPassword"));
    public static final Target BTN_INICIAR_SESION= Target.the("Inicicar sesion").located(By.id("personLogin"));
    public static final Target BTN_COOKIES= Target.the("Acepto cookies").located(By.cssSelector("#body > div.cky-consent-container.cky-banner-bottom > div > div > div > div.cky-notice-btn-wrapper > button.cky-btn.cky-btn-accept"));
    public static final Target BTN_ACTUALIZAR= Target.the("Confirmar pais").located(By.cssSelector("div[class='container'] button[class='yellow-bg mat-flat-button mat-button-base']"));
    public static final Target LBL_SALUD_OV= Target.the("Mensaje bienvenida").located(By.cssSelector(".py-2.d-none.d-md-inline-block"));
    public static final Target TXT_NUMERO = Target.the("Campo Teléfono Fijo")
            .located(By.cssSelector("input[formcontrolname='homePhone']"));
}
