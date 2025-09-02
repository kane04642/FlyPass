package com.calidda.ov.userinterface.reclamoNoCliente;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReclamosNoClientePOM extends PageObject {

    public static final Target LINK_ATENCION_CLIENTE= Target.the("Link atenciòn cliente").located(By.xpath("//a[normalize-space()='Atención al Cliente']"));
    public static final Target LNK_RECLAMOS= Target.the("Dar click en link reclamos").located(By.xpath("//a[@href='/atencion-al-cliente/registrar-reclamos#seccion']//div[@class='icon']//div[@class='icono-navhover']"));
    public static final Target LINK_REGISTRAR_RECLAMO= Target.the("Link registra tu reclamo").located(By.id("RegistraReclamo"));
    public static final Target BTN_NO_SOY_CLIENTE = Target.the("Boton no soy cliente Càlidda").located(By.id("buttonLoginDos"));

    public static final Target TXT_NOMBRE = Target.the("Ingresar nombre o razòn social").located(By.id("mat-input-1"));
    public static final Target TXT_APELLIDO = Target.the("Ingresar apellido").located(By.id("mat-input-2"));
    public static final Target LIS_TIPO_DOCUMENTO= Target.the("Click en tipo de documento").located(By.id("mat-select-1"));
    public static final Target SLC_TIPO_DOCUMENTO= Target.the("Seleccionar el tipo de documento").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NUM_DOCUMENTO = Target.the("Ingresar numero de documento").located(By.id("mat-input-3"));
    public static final Target TXT_TELEFONO = Target.the("Ingresar numero de telefono").located(By.id("mat-input-4"));
    public static final Target TXT_CELULAR = Target.the("Ingresar numero de celular").located(By.id("mat-input-5"));
    public static final Target TXT_CORREO= Target.the("Ingresar email").located(By.id("mat-input-6"));

    public static final Target LIS_TIPO_CALLE= Target.the("Click en tipo de calle").located(By.id("mat-select-2"));
    public static final Target SLC_TIPO_CALLE= Target.the("Seleccionar el tipo calle").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NOM_CALLE= Target.the("Ingresar nombre de la calle").located(By.id("mat-input-7"));
    public static final Target TXT_NRO_CALLE= Target.the("Ingresar numero de la calle").located(By.id("mat-input-8"));
    public static final Target LIS_TIPO_EDIFICIO= Target.the("Click en tipo de edificio").located(By.id("mat-select-12"));
    public static final Target SLC_TIPO_EDIFICIO= Target.the("Seleccionar el tipo edificio").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_EDIFICIO= Target.the("Ingresar edificio").located(By.id("mat-input-21"));
    public static final Target LIS_TIPO_VIVIENDA= Target.the("Click en tipo de vivienda").located(By.id("mat-select-13"));
    public static final Target SLC_TIPO_VIVIENDA= Target.the("Seleccionar el tipo vivienda").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NOM_VIVIENDA= Target.the("Ingresar nombre vivienda").located(By.id("mat-input-22"));
    public static final Target TXT_PISO= Target.the("Ingresar piso").located(By.id("mat-input-9"));
    public static final Target LIS_TIPO_INTERIOR= Target.the("Click en tipo de interior").located(By.id("mat-select-3"));
    public static final Target SLC_TIPO_INTERIOR= Target.the("Seleccionar el tipo interior").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_INTERIOR= Target.the("Ingresar interior").located(By.id("mat-input-10"));
    public static final Target LIS_TIPO_COMITE= Target.the("Click en tipo de comite").located(By.id("mat-select-4"));
    public static final Target SLC_TIPO_COMITE= Target.the("Seleccionar el tipo comite").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_COMITE= Target.the("Ingresar comite").located(By.id("mat-input-11"));
    public static final Target TXT_MZ= Target.the("Ingresar MZ").located(By.id("mat-input-12"));
    public static final Target TXT_LT= Target.the("Ingresar LT").located(By.id("mat-input-13"));
    public static final Target LIS_TIPO_CONJUNTO= Target.the("Click en tipo de conjunto").located(By.id("mat-select-5"));
    public static final Target SLC_TIPO_CONJUNTO= Target.the("Seleccionar el tipo conjunto").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target TXT_NOM_CONJUNTO= Target.the("Ingresar nombre conjunto").located(By.id("mat-input-14"));
    public static final Target LIS_DEPARTAMENTO= Target.the("Click en tipo de departamento").located(By.id("mat-select-6"));
    public static final Target SLC_DEPARTAMENTO= Target.the("Seleccionar el tipo departamwento").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_TIPO_PROVINCIA= Target.the("Click en tipo de provincia").located(By.id("mat-select-7"));
    public static final Target SLC_TIPO_PROVINCIA= Target.the("Seleccionar el tipo provincia").locatedBy("//mat-option[contains(.,'{0}')]");
    public static final Target LIS_TIPO_DISTRITO= Target.the("Click en tipo de distrito").located(By.id("mat-select-8"));
    public static final Target SLC_TIPO_DISTRITO= Target.the("Seleccionar el tipo distrito").locatedBy("//mat-option[contains(.,'{0}')]");

}
