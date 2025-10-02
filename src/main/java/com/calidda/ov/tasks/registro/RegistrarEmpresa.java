package com.calidda.ov.tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.calidda.ov.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarEmpresa implements Task {
    private final Map<String, String> datosEmpresa;

    public RegistrarEmpresa(Map<String, String> datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }
    public static RegistrarEmpresa nueva(Map<String, String> datosEmpresa){
        return instrumented(RegistrarEmpresa.class, datosEmpresa);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(datosEmpresa.get("ruc")).into(TXT_RUC),
                Enter.theValue(datosEmpresa.get("razonSocial")).into(TXT_RAZON_SOCIAL),
                Enter.theValue(datosEmpresa.get("email")).into(TXT_EMAIL_EMPRESA),
                Enter.theValue(datosEmpresa.get("telefono")).into(TXT_TELEFO_EMPRESA),
                Enter.theValue(datosEmpresa.get("celular")).into(TXT_CELULAR_EMPRESA),
                Enter.theValue(datosEmpresa.get("clave")).into(TXT_CLAVE_EMPRESA),
                Enter.theValue(datosEmpresa.get("confirmarClave")).into(TXT_CLAVE_CON_EMPRESA),
                Enter.theValue(datosEmpresa.get("numCliente")).into(TXT_NoCLIENTE_EMPRESA),
                Enter.theValue(datosEmpresa.get("numRecibo")).into(TXT_NoRECIBO_EMPRESA),
                Click.on(CHK_POLI_WEB),
                Click.on(BTN_REGIS_USUARIO)
        );

    }
}
