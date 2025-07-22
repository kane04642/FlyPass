package com.grupoemi.socloud.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPrincipal extends PageObject {
    public static final Target LNK_MENU_PRINCIPAL= Target.the("Desplegar menú principal").located(By.cssSelector("#kt_app_content_container > app-dashboard > div.falck-wellcome-page.container > div > app-start-menu > div > nav > ul > li:nth-child(1) > a"));
    public static final Target LNK_GESTION_LLAMADA= Target.the("Desplegar gestión de llamadas").located(By.cssSelector("#\\#kt_app_sidebar_menu > div.menu-item.menu-accordion.hover.show > span > span.menu-title"));
    public static final Target LNK_MENU_RECEPCION= Target.the("Desplegar menú recepcion").located(By.cssSelector("#\\#kt_app_sidebar_menu > div.menu-item.menu-accordion.hover.show.here > div > div.menu-item.menu-accordion.hover.show.here > span > span.menu-title"));
    public static final Target BTN_INICIAR_LLAMADA= Target.the("Boton iniciar llamada").located(By.cssSelector("#falck-controlbar > div > div > div:nth-child(1) > div:nth-child(1) > div > button"));


}
