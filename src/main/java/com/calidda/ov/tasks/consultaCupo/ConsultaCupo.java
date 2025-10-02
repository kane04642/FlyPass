package com.calidda.ov.tasks.consultaCupo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.Login.BTN_COOKIES;
import static com.calidda.ov.userinterface.consultaCupo.ConsultaCupoInter.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ConsultaCupo implements Task {
    public static ConsultaCupo credito(){
        return instrumented(ConsultaCupo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_COOKIES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BTN_COOKIES),
                Click.on(BTN_CREDICALIDA),
                WaitUntil.the(BTN_CONOCE_CREDITO, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CONOCE_CREDITO),
                Click.on(CHK_CAPTCHA)
        );

    }
}
