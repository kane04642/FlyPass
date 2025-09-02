package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.Login.BTN_ACTUALIZAR;
import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class MenuReclamoCliente implements Task {

    public static MenuReclamoCliente operaciones(){
       return instrumented(MenuReclamoCliente.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MEN_OPERCIONES, isPresent()).forNoMoreThan(20).seconds(),
                Click.on(MEN_OPERCIONES),
                WaitUntil.the(SUB_RECLAMO_CLIENTE, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(SUB_RECLAMO_CLIENTE)

                );
    }
}
