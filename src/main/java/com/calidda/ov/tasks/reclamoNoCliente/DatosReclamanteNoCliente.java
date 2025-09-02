package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DatosReclamanteNoCliente implements Task {
    private final Map<String, String> datosReclamanteNoCliente;

    public DatosReclamanteNoCliente(Map<String, String> datosReclamanteNoCliente) {
        this.datosReclamanteNoCliente = datosReclamanteNoCliente;
    }

    public static DatosReclamanteNoCliente ingresa(Map<String, String> datosReclamanteNoCliente){
        return instrumented(DatosReclamanteNoCliente.class, datosReclamanteNoCliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBRE, isPresent()).forNoMoreThan(30).seconds(),
                Enter.theValue(datosReclamanteNoCliente.get("nombre")).into(TXT_NOMBRE),
                Enter.theValue(datosReclamanteNoCliente.get("apellidos")).into(TXT_APELLIDO),
                Click.on(LIS_TIPO_DOCUMENTO),
                Click.on(SLC_TIPO_DOCUMENTO.of(datosReclamanteNoCliente.get("tipoDocumento"))),
                Enter.theValue(datosReclamanteNoCliente.get("numeroDocumento")).into(TXT_NUM_DOCUMENTO),
                Enter.theValue(datosReclamanteNoCliente.get("telefono")).into(TXT_TELEFONO),
                Enter.theValue(datosReclamanteNoCliente.get("celular")).into(TXT_CELULAR),
                Enter.theValue(datosReclamanteNoCliente.get("correo")).into(TXT_CORREO)
        );

    }
}
