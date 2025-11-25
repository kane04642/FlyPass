package com.calidda.ov.tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static com.calidda.ov.userinterface.Login.*;
import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.LIS_TIPO_DOCU_REPRE;
import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.SLC_TIPO_DOCU_REPRE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class RegistrarCliente implements Task {
    private final Map<String, String> registroCliente;

    public RegistrarCliente(Map<String, String> registroCliente) {
        this.registroCliente = registroCliente;
    }

    public static RegistrarCliente nuevoUsuario(Map<String, String> registroCliente){
        return instrumented(RegistrarCliente.class, registroCliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_COOKIES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BTN_COOKIES),
                Click.on(BTN_REGISTRARME),
                WaitUntil.the(TXT_NOMBRE_APELLIDO, isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(registroCliente.get("NombreApellido")).into(TXT_NOMBRE_APELLIDO),
                Click.on(LIS_TIPO_DOCUMENTO),
                Click.on(SLC_TIPO_DOCUMENTO.of(registroCliente.get("tipoDocumento"))),
                Enter.theValue(registroCliente.get("NoDocumento")).into(TXT_No_DOCUMENTO),
                Enter.theValue(registroCliente.get("email")).into(TXT_EMAIL),
                Enter.theValue(registroCliente.get("telefono")).into(TXT_TELEFONO_REGISTRO),
                Enter.theValue(registroCliente.get("celular")).into(TXT_CELULAR),
                Enter.theValue(registroCliente.get("clave")).into(TXT_CLAVE_REGISTRO),
                Enter.theValue(registroCliente.get("confirmarClave")).into(TXT_CLAVE_CONFIRMAR),
                Enter.theValue(registroCliente.get("numCliente")).into(TXT_NUM_CLIENTE),
                //Enter.theValue(registroCliente.get("numRecibo")).into(TXT_NUM_RECIBO),
                WaitUntil.the(CHK_POLI_WEB, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(CHK_POLI_WEB),
                //Click.on(CHK_FINES_COMER),
                //Click.on(CHK_RECIBO),
                Click.on(BTN_REGIS_USUARIO)

        );

        // Validar BTN_CONFIRMAR_REGIS aparece
        if (BTN_CONFIRMAR_REGIS.resolveFor(actor).isVisible()) {
            actor.attemptsTo(Click.on(BTN_CONFIRMAR_REGIS));
        }
    }
}
