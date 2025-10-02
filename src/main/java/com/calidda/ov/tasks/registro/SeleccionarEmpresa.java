package com.calidda.ov.tasks.registro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SeleccionarEmpresa implements Task{
    public static SeleccionarEmpresa nueva(){
        return instrumented(SeleccionarEmpresa.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_COOKIES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BTN_COOKIES),
                Click.on(BTN_REGISTRARME),
                WaitUntil.the(LNK_EMPRESA, isPresent()).forNoMoreThan(5).seconds(),
                Click.on(LNK_EMPRESA)
        );

    }
}
