package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BienContratado implements Task {
    private final Map<String, String> tipoBien;

    public BienContratado(Map<String, String> tipoBien) {
        this.tipoBien = tipoBien;
    }

    public static BienContratado tipo(Map<String, String> tipoBien){
        return instrumented(BienContratado.class, tipoBien);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LIS_TIPO_BIEN),
                Click.on(SLC_TIPO_BIEN.of(tipoBien.get("bienContratado"))),
                Enter.theValue(tipoBien.get("bienDescripcion")).into(TXT_BIEN)

        );
    }
}
