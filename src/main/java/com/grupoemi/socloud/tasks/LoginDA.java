package com.grupoemi.socloud.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static com.grupoemi.socloud.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class LoginDA implements Task {

    private Map<String, String> datosAccesos;

    public LoginDA(Map<String, String> datosAccesos){
        this.datosAccesos = datosAccesos;
    }

    public static LoginDA directorio(Map<String, String> datosAccesos) {
        return instrumented(LoginDA.class, datosAccesos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues((datosAccesos.get("usuario"))).into(TXT_USER),
                Click.on(BTN_SIGUIENTE),
                Enter.keyValues((datosAccesos.get("password"))).into(TXT_CLAVE),
                Click.on(BTN_INICIAR_SESION),
                Click.on(BTN_INICIAR_CONFIRMAR)
        );
        if (IMG_PAIS.resolveFor(actor).isVisible()) {
            // Si es visible, entonces el actor intenta hacer clic en él
            actor.attemptsTo(
                    Click.on(IMG_PAIS)
            );
        }
    }
}
