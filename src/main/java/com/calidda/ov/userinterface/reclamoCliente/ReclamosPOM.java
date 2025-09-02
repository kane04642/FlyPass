package com.calidda.ov.userinterface.reclamoCliente;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReclamosPOM extends PageObject {
    public static final Target MEN_OPERCIONES= Target.the("Seleccionar menù Operaciones").located(By.id("dropdownOperaciones"));
    public static final Target SUB_RECLAMO_CLIENTE= Target.the("Registrar reclamo Osinergmin").located(By.xpath("//a[normalize-space()='Registrar reclamo Osinergmin']"));
    public static final Target LIS_NUMERO_CLIENTE= Target.the("Click en el numero de cliente").located(By.id("mat-select-7"));
    public static final Target SLC_NUMERO_CLIENTE= Target.the("Seleccionar el numero de cliente").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target CHK_POLITICA_PRIVA= Target.the("Aceptar politica de privacidad").located(By.cssSelector(".mat-slide-toggle-bar"));
    public static final Target BTN_SIGUi_RECLAMANTE= Target.the("Siguiente en pantalla datos del reclamante").located(By.cssSelector("div[id='cdk-step-content-0-0'] button[type='button']"));
    public static final Target CHK_DATOS_REPRESENTANTE= Target.the("Check ingresar datos del representante legal").located(By.cssSelector("label[for='mat-checkbox-1-input'] div[class='mat-checkbox-inner-container']"));
    public static final Target LIS_TIPO_RELACION= Target.the("Click en tipo de relaciòn").located(By.id("mat-select-5"));
    public static final Target SLC_TIPO_RELACION= Target.the("Seleccionar el tipo de relaciòn").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NOMBRE_REPRE= Target.the("Nombre del representante legal").located(By.id("mat-input-7"));
    public static final Target TXT_APELLIDO_REPRE= Target.the("Apellido del representante legal").located(By.id("mat-input-8"));
    public static final Target LIS_TIPO_DOCU_REPRE= Target.the("Click en tipo de documento del representante").located(By.id("mat-select-6"));
    public static final Target SLC_TIPO_DOCU_REPRE= Target.the("Seleccionar el tipo de documento del representante").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NUM_DOCU_REPRE= Target.the("Numero documento del representante legal").located(By.id("mat-input-9"));
    public static final Target TXT_TELE_FIJO_REPRE= Target.the("Telefono fijo del representante legal").located(By.id("mat-input-10"));
    public static final Target TXT_CELU_REPRE= Target.the("Numero celular representante legal").located(By.id("mat-input-11"));
    public static final Target TXT_EMAIL_REPRE= Target.the("Email del representante legal").located(By.id("mat-input-12"));
    public static final Target BTN_SIGUIENTE_REPRE= Target.the("Boton siguiente pantalla representante legal").located(By.xpath("//div[@id='cdk-step-content-0-1']//button[@type='button'][normalize-space()='Siguiente']"));
    public static final Target LIS_MOTIVO= Target.the("Lista de motivos").located(By.id("mat-select-2"));
    public static final Target SLC_MOTIVO= Target.the("Dar click en motivo").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_SUB_MOTIVO= Target.the("Lista de sub-motivos").located(By.id("mat-select-3"));
    public static final Target SLC_SUB_MOTIVO= Target.the("Seleccionar sub-motivo").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_DES_RECLAMO= Target.the("Descripciòn del reclamo").located(By.id("mat-input-0"));
    public static final Target BTN_SIGUIENTE_MOTI= Target.the("Boton siguiente pantalla motivo reclamo").located(By.cssSelector("div[id='cdk-step-content-0-2'] button:nth-child(1)"));
    public static final Target CHK_RECLAMO_EMAIL= Target.the("Acepto notificaciòn por correo").located(By.id("inlineRadio1"));
    public static final Target TXT_EMAIL_RECLAMO= Target.the("Ingreso email notificaciòn").located(By.cssSelector("input[placeholder='Correo para la notificación']"));
    public static final Target BTN_EMAIL_ACEPTAR= Target.the("Boton guardar email").located(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
    public static final Target BTN_EMAIL_SERVICIO= Target.the("Boton error servicio email").located(By.cssSelector("button[class='swal2-confirm swal2-styled']"));
    public static final Target BTN_ENVIAR_RECLAMO= Target.the("Boton enviar reclamo cliente").located(By.cssSelector("div[id='cdk-step-content-0-3'] button[class='sendBtnColor mat-flat-button mat-button-base'] span[class='mat-button-wrapper']"));
    public static final Target BTN_ENVIAR_CONFIRMAR= Target.the("Boton confirmo reclamo cliente").located(By.cssSelector("button[class='swal2-confirm swal2-styled']"));


}
