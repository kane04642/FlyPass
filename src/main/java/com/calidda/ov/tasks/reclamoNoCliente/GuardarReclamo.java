package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class GuardarReclamo implements Task {

    public static GuardarReclamo noCliente(){
        return instrumented(GuardarReclamo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GUARDAR_RECLAMO),
                Click.on(BTN_CONFIRMAR),
                WaitUntil.the(BTN_DESCARGAR_PDF, isPresent()).forNoMoreThan(25).seconds(),
                Click.on(BTN_DESCARGAR_PDF)
        );
    }

}
