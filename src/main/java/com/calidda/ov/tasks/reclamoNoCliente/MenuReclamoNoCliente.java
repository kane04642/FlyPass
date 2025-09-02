package com.calidda.ov.tasks.reclamoNoCliente;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.Login.BTN_COOKIES;
import static com.calidda.ov.userinterface.reclamoNoCliente.ReclamosNoClientePOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class MenuReclamoNoCliente implements Task {

    public static MenuReclamoNoCliente navega(){
        return instrumented(MenuReclamoNoCliente.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_COOKIES, isPresent()).forNoMoreThan(15).seconds(),
                Click.on(BTN_COOKIES),
                WaitUntil.the(LINK_ATENCION_CLIENTE, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(LINK_ATENCION_CLIENTE),
                WaitUntil.the(LNK_RECLAMOS, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(LNK_RECLAMOS),
                WaitUntil.the(LINK_REGISTRAR_RECLAMO, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(LINK_REGISTRAR_RECLAMO),
                WaitUntil.the(BTN_NO_SOY_CLIENTE, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(BTN_NO_SOY_CLIENTE)

                );
        Serenity.takeScreenshot();

    }
}
