package com.grupoemi.socloud.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.model.util.EnvironmentVariables;

import static com.grupoemi.socloud.userinterface.Login.*;
import static com.grupoemi.socloud.userinterface.Login.IMG_PAIS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AutenticarSO implements Task {

    private final String actorName;
    private EnvironmentVariables environmentVariables;
    public AutenticarSO(String actorName) {
        this.actorName = actorName;
    }

    public static AutenticarSO cloud(String actorName){
        return instrumented(AutenticarSO.class, actorName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String usernameKey = "users." + actorName + ".username";
        String passwordKey = "users." + actorName + ".password";
        // Lee el usuario y la contraseña desde serenity.conf
        String username = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(usernameKey);
        String password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(passwordKey);

        actor.attemptsTo(
                Enter.keyValues(username).into(TXT_USER),
                Click.on(BTN_SIGUIENTE),
                Enter.keyValues(password).into(TXT_CLAVE),
                Click.on(BTN_INICIAR_SESION),
                Click.on(BTN_INICIAR_CONFIRMAR)
        );
        if (IMG_PAIS.resolveFor(actor).isVisible()) {
            // Si es visible, entonces el actor intenta hacer clic en él pais
            actor.attemptsTo(
                    Click.on(IMG_PAIS)
            );
        }
    }
}
