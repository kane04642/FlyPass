package com.grupoemi.socloud.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login  extends PageObject {

    public static final Target TXT_USER= Target.the("Ingresar usuario").located(By.cssSelector("#i0116"));
    public static final Target BTN_SIGUIENTE= Target.the("Dar siguiente").located(By.cssSelector("#idSIButton9"));
    public static final Target TXT_CLAVE= Target.the("Ingresar clave").located(By.cssSelector("#i0118"));
    public static final Target BTN_INICIAR_SESION= Target.the("Inicicar sesion").located(By.cssSelector("#idSIButton9"));
    public static final Target BTN_INICIAR_CONFIRMAR= Target.the("Confirmo inicio de sesion").located(By.cssSelector("#idSIButton9"));
    public static final Target IMG_PAIS= Target.the("Confirmar pais").located(By.cssSelector("#save_configuration > div.falck-country-section-container > div > div:nth-child(2) > a > div > img"));
    public static final Target LBL_SALUD_SO= Target.the("Mensaje bienvenida SO Cloud").located(By.cssSelector("#kt_app_content_container > app-dashboard > div.col-12.pt-6.pb-10.text-center > h1"));

}
