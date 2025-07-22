package com.grupoemi.socloud.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearClientePOM extends PageObject {
    public static final Target LST_TIPO_SOLICITANTE= Target.the("Tipo solicitante").located(By.cssSelector("#patientInformationForm > div > div > div:nth-child(1) > div > div.col-lg-4 > mat-form-field"));
    public static final Target SLC_TIPO_SOLICITANTE= Target.the("Seleccionar el tipo de solicitante").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LST_TIPO_DOCUMENTO= Target.the("Selector tipos de documentos").located(By.xpath("//div[@id='mat-select-value-3']"));
    public static final Target SLC_TIPO_DOCUMENTO= Target.the("Seleccionar el tipo").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NO_DOCUMENTO= Target.the("Numero de documento").located(By.id("documentoInput"));
    public static final Target TXT_TELEFONO= Target.the("Ingresar numero de telefono").located(By.id("telefonoInput"));
    public static final Target TXT_CELULAR= Target.the("Ingresar numero de celular").located(By.id("celularInput"));
    public static final Target LNK_EMAIL= Target.the("Dar click en email").located(By.cssSelector("#patientInformationForm > div > div > div:nth-child(3) > div > div:nth-child(5) > mat-form-field"));
    public static final Target LNK_NO_EMAIL= Target.the("Dar click en no tiene email").located(By.cssSelector("#mat-checkbox-1"));
    public static final Target TXT_EMAIL= Target.the("Digitar el email del usuario").located(By.id("emailInput"));
    public static final Target TXT_NOMBRE= Target.the("Digitar el nombre del usuario").located(By.id("nombreInput"));
    public static final Target TXT_EDAD= Target.the("Digitar edad del usuario").located(By.id("edadInput"));
    public static final Target LIS_TIPO_EDAD= Target.the("dar click en  tipo de edad").located(By.xpath("//*[@id=\"patientInformationForm\"]/div/div/div[5]/div/div[2]/mat-form-field/div/div[1]/div"));
    public static final Target SLC_TIPO_EDAD= Target.the("Seleccionar tipo de edad ").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_SEXO= Target.the("dar click en sexo").located(By.cssSelector("#patientInformationForm > div > div > div:nth-child(5) > div > div:nth-child(3) > mat-form-field"));
    public static final Target LST_SEXO= Target.the("Seleccionar sexo").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_PAIS= Target.the("dar click en país").located(By.cssSelector("#patientInformationForm > div > div > div:nth-child(5) > div > div:nth-child(4) > mat-form-field > div"));
    public static final Target SLC_PAIS= Target.the("Seleccionar país").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_MOTIVO= Target.the("Ingresar numero de motivo").located(By.id("motivoLlamadoCodigoINput"));
    public static final Target TXT_CUADRO_CLINICO= Target.the("Ingresar información cuadrio clinico").located(By.cssSelector("#otrosDatosTextarea"));
    public static final Target TXT_CLASIFICACION= Target.the("Ingresar codigo de clasificación").located(By.id("clasificacionCodigoINput"));
    public static final Target LIS_CIUDAD= Target.the("dar click en la ciudad").located(By.cssSelector("#geographicInformationForm > div > div > div:nth-child(2) > div > div.col-lg-7 > div > div:nth-child(1) > div > div:nth-child(1) > mat-form-field"));
    public static final Target SLC_CIUDAD= Target.the("Seleccionar ciudad").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_BARRIO= Target.the("Dar click en la barrio").located(By.cssSelector("#geographicInformationForm > div > div > div:nth-child(2) > div > div.col-lg-7 > div > div:nth-child(1) > div > div:nth-child(2) > mat-form-field > div"));
    public static final Target SLC_BARRIO= Target.the("Seleccionar barrio").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_DIRRECCION= Target.the("Ingresar dirección de usuario").located(By.id("direccionInput"));
    public static final Target BTN_GENERAR_SERVICIO= Target.the("Dar click en generar servicio").located(By.cssSelector("#falck-controlbar > div > div > div:nth-child(3) > div.m-0 > button"));
    public static final Target BTN_ENVIAR_SERVICIO= Target.the("Dar click para confirmar creación de servicio").located(By.xpath("//*[@id=\"mat-dialog-0\"]/app-sent-information/form/div/div[3]/button[2]"));

}
