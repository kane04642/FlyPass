package com.calidda.ov.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;

import static com.calidda.ov.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AutenticarOV implements Task {

    private final String actorName;
    private EnvironmentVariables environmentVariables;
    public AutenticarOV(String actorName) {
        this.actorName = actorName;
    }

    public static AutenticarOV cloud(String actorName){
        return instrumented(AutenticarOV.class, actorName);
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
                WaitUntil.the(BTN_COOKIES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BTN_COOKIES),
                Enter.keyValues(username).into(TXT_USER),
                Enter.keyValues(password).into(TXT_CLAVE),
                Click.on(BTN_INICIAR_SESION)/*,
                WaitUntil.the(BTN_ACTUALIZAR, isPresent()).forNoMoreThan(40).seconds(),
                Click.on(BTN_ACTUALIZAR),
                Scroll.to(TXT_NUMERO),
                Enter.keyValues("123134").into(TXT_NUMERO)
                */
                );
        Serenity.takeScreenshot();

    }
}
