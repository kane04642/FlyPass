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
    public static final Target BTN_REGISTRARME= Target.the("Botòn registrar nuevo usuario").located(By.id("registrarPersona"));
    public static final Target TXT_NOMBRE_APELLIDO= Target.the("Ingresar nombres y apellidos").located(By.xpath("//input[@formcontrolname='clientName']"));
    public static final Target TXT_EMAIL= Target.the("Ingresar email de registro").located(By.xpath("//input[@formcontrolname='clientEmail']"));
    public static final Target TXT_TELEFONO_REGISTRO= Target.the("Ingresar telèfono registro").located(By.xpath("//input[@formcontrolname='clientPhone']"));
    public static final Target TXT_CELULAR= Target.the("Ingresar celular de registro").located(By.xpath("//input[@formcontrolname='clientCellPhone']"));
    public static final Target TXT_CLAVE_REGISTRO= Target.the("Ingresar clave de registro").located(By.xpath("//input[@formcontrolname='clientPassword']"));
    public static final Target TXT_CLAVE_CONFIRMAR= Target.the("Ingresar confirmo clave de registro").located(By.xpath("//input[@formcontrolname='clientConfirmPassword']"));
    public static final Target TXT_NUM_CLIENTE= Target.the("Ingresar numero de cliente").located(By.xpath("//input[@formcontrolname='clientCode']"));
    public static final Target TXT_NUM_RECIBO= Target.the("Ingresar numero de recibo").located(By.xpath("//input[@formcontrolname='clientReceiptNumber']"));
    public static final Target CHK_POLI_WEB = Target.the("Check politica web de privacidad").located(By.xpath("(//div[@class='mat-slide-toggle-thumb-container'])[1]"));
    public static final Target CHK_FINES_COMER = Target.the("Check acepto fines comerciales").located(By.id("mat-slide-toggle-2-input"));
    public static final Target CHK_RECIBO = Target.the("Check recibo digital").located(By.id("mat-slide-toggle-3-input"));
    public static final Target BTN_REGIS_USUARIO= Target.the("Botòn registrar el nuevo usuario").located(By.xpath("//button[@class='btnRegister mat-flat-button mat-button-base']"));
    public static final Target BTN_ACEPTO_FINES= Target.the("Botòn acepto fines comerciales").located(By.xpath("//button[@class='blue-bg whiteText mat-button mat-button-base']"));
    public static final Target BTN_CONFIRMAR_REGIS= Target.the("Botòn confirmar el registro de nuevo usuario").located(By.xpath("//button[normalize-space()='Sí']"));
    public static final Target BTN_ERROR_REGISTRO= Target.the("Botòn error de registro").located(By.xpath("//button[normalize-space()='OK']"));
    public static final Target LNK_CAMPOS_OBLIGA= Target.the("Mensaje de campos obligatorios").located(By.xpath("//h2[@id='swal2-title']"));
    public static final Target BTN_CANCELAR_REGIS= Target.the("Botòn cancelar registro de usuario").located(By.xpath("//button[@class='mr-2 mat-flat-button mat-button-base mat-warn']"));
    public static final Target LNK_CANCELAR_REGISTRO= Target.the("Mensaje confirmo deseo cancelar el registro").located(By.xpath("//div[@id='swal2-content']"));
    public static final Target BTN_CAMPOS_OBLI_OK= Target.the("Botòn campos obligatorios Ok").located(By.xpath("//button[text()='OK']"));
    public static final Target LNK_EMPRESA= Target.the("Seleccionar pestaña empresa").located(By.cssSelector("#mat-tab-label-0-1"));
    public static final Target TXT_RUC= Target.the("Ingresar RUC de empresa").located(By.xpath("//input[@formcontrolname='businessRuc']"));
    public static final Target TXT_RAZON_SOCIAL= Target.the("Ingresar razòpn social de la empresa").located(By.xpath("//input[@formcontrolname='businessName']"));
    public static final Target TXT_EMAIL_EMPRESA= Target.the("Ingresar email de nueva empresa").located(By.xpath("//input[@formcontrolname='businessEmail']"));
    public static final Target TXT_TELEFO_EMPRESA= Target.the("Ingresar telefono de nueva empresa").located(By.xpath("//input[@formcontrolname='businessPhone']"));
    public static final Target TXT_CELULAR_EMPRESA= Target.the("Ingresar celular de nueva empresa").located(By.xpath("//input[@formcontrolname='businessCellPhone']"));
    public static final Target TXT_CLAVE_EMPRESA= Target.the("Ingresar clave de nueva empresa").located(By.xpath("//input[@formcontrolname='businessPassword']"));
    public static final Target TXT_CLAVE_CON_EMPRESA= Target.the("Ingresar confirmar clave de nueva empresa").located(By.xpath("//input[@formcontrolname='businessConfirmPassword']"));
    public static final Target TXT_NoCLIENTE_EMPRESA= Target.the("Ingresar Nro cliente empresa").located(By.xpath("//input[@formcontrolname='businessCode']"));
    public static final Target TXT_NoRECIBO_EMPRESA= Target.the("Ingresar Nro recibo empresa").located(By.xpath("//input[@formcontrolname='businessReceiptNumber']"));
    public static final Target LIS_TIPO_DOCUMENTO= Target.the("Click en tipo de documento").located(By.cssSelector("#mat-select-0"));
    public static final Target SLC_TIPO_DOCUMENTO= Target.the("Seleccionar el tipo de documento").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_No_DOCUMENTO= Target.the("Ingresar Nro de documento del titular").located(By.xpath("//input[@formcontrolname='clientDocumentNumber']"));

}
