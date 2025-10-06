package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.BTN_ENVIAR_CONFIRMAR;
import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.BTN_ENVIAR_RECLAMO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarReclamo implements Task {
    public static RegistrarReclamo cliente(){
        return instrumented(RegistrarReclamo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ENVIAR_RECLAMO),
                Click.on(BTN_ENVIAR_CONFIRMAR)
        );
    }
}
