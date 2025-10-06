package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;

import java.util.Map;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NotificacionReclamo implements Task {

    private final Map<String, String> emailT;

    public NotificacionReclamo(Map<String, String> emailT) {
        this.emailT = emailT;
    }

    public static NotificacionReclamo email(Map<String, String> emailT){
        return instrumented(NotificacionReclamo.class, emailT);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHK_RECLAMO_EMAIL),
                Enter.theValue(emailT.get("email")).into(TXT_EMAIL_RECLAMO),
                Click.on(BTN_EMAIL_ACEPTAR)
        );

        if (actor.asksFor(Visibility.of(BTN_EMAIL_SERVICIO))) {
            actor.attemptsTo(
                    Click.on(BTN_EMAIL_SERVICIO)
            );
        }

    }
}
