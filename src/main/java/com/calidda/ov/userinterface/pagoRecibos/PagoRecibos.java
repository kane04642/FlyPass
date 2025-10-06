package com.calidda.ov.userinterface.pagoRecibos;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PagoRecibos extends PageObject {

    public static final Target BTN_PAGO_RECIBO= Target.the("Menù pago de recibos").located(By.cssSelector("div[class='nav-item dropdown col-md-3 p-0'] span[class='mat-button-wrapper']"));

}
