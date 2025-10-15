package com.calidda.ov.userinterface.pagoRecibos;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PagoRecibos extends PageObject {

    public static final Target BTN_PAGO_RECIBO= Target.the("Menù pago de recibos").located(By.cssSelector("div[class='nav-item dropdown col-md-3 p-0'] span[class='mat-button-wrapper'] span"));
    public static final Target LIS_RECIBO= Target.the("Click en lista de recibos").located(By.id("mat-select-2"));
    public static final Target SLC_RECIBO= Target.the("Seleccionar recibo para pago").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target CHK_RECIBO_PAGO= Target.the("Dar check en recibo para pago").located(By.id("mat-checkbox-1"));
    public static final Target BTN_PAGAR= Target.the("Click en botòn pagar").located(By.cssSelector(".style-button-1.mat-flat-button.mat-button-base"));

}
