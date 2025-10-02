package com.calidda.ov.userinterface.consultaCupo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConsultaCupoInter extends PageObject {
    public static final Target BTN_CREDICALIDA= Target.the("Botòn credicalidda").located(By.xpath("//li[@class='logo-option']//div[@role='button']"));
    public static final Target BTN_CONOCE_CREDITO= Target.the("Link conoce tu linea de crèdito").located(By.xpath("//a[contains(@class,'btn-bg-calidda')]"));
    public static final Target TXT_NUMERO_DOCU= Target.the("Ingresar numero de documento").located(By.id("checkCreditLineNumeroDocumento"));
    public static final Target LIS_TIPO_DOCU= Target.the("Click en tipo de documento").located(By.id("checkCreditLineDescripcionTipoDocumento"));
    public static final Target SLC_TIPO_DOCU= Target.the("Seleccionar el tipo de documento").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target CHK_POLITICA_WEB= Target.the("Check acepto terminos y condiciones y politicas web de privacidad").located(By.id("checkCreditLineAceptaPolitica"));
    public static final Target CHK_FINES_COMER= Target.the("Check acepto uso de informaciòn para fines comerciales").located(By.id("checkCreditLineAceptaFinesComerciales"));
    public static final Target CHK_CAPTCHA= Target.the("Check acepto uso de informaciòn para fines comerciales").located(By.xpath("//iframe[contains(@src, 'recaptcha') and not(@title='recaptcha challenge')]"));

}
