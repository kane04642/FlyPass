package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MotivoReclamo implements Task {
    private final Map<String, String> datosMotivo;

    public MotivoReclamo(Map<String, String> datosMotivo) {
        this.datosMotivo = datosMotivo;
    }
    public static MotivoReclamo cliente(Map<String, String> datosMotivo){
        return instrumented(MotivoReclamo.class, datosMotivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LIS_MOTIVO),
                Click.on(SLC_MOTIVO.of(datosMotivo.get("motivo"))),
                Click.on(LIS_SUB_MOTIVO),
                Click.on(SLC_SUB_MOTIVO.of(datosMotivo.get("submotivo"))),
                Enter.theValue(datosMotivo.get("descripcionReclamo")).into(TXT_DES_RECLAMO),
                Click.on(BTN_SIGUIENTE_MOTI)
        );
    }
}
