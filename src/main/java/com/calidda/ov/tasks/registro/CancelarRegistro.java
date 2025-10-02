package com.calidda.ov.tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.calidda.ov.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CancelarRegistro implements Task {

    public static CancelarRegistro newUsuario(){
        return instrumented(CancelarRegistro.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CAMPOS_OBLI_OK),
                Click.on(BTN_CANCELAR_REGIS)
        );
    }
}
