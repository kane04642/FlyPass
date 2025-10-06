package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.BTN_SIG_NOTIFICA;
import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.CHK_RECLAMO_NO_EMAIL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RespuestaNoEmail implements Task {

    public static RespuestaNoEmail notifica(){
        return instrumented(RespuestaNoEmail.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHK_RECLAMO_NO_EMAIL),
                Scroll.to(BTN_SIG_NOTIFICA),
                Click.on(BTN_SIG_NOTIFICA)
        );
    }
}
