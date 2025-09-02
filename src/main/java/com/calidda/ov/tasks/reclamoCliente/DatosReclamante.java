package com.calidda.ov.tasks.reclamoCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.calidda.ov.userinterface.reclamoCliente.ReclamosPOM.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DatosReclamante implements Task {

    private final String numeroCliente;

    public DatosReclamante(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public static DatosReclamante cliente(String numeroCliente){
        return instrumented(DatosReclamante.class, numeroCliente);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(LIS_NUMERO_CLIENTE),
                WaitUntil.the(LIS_NUMERO_CLIENTE, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(LIS_NUMERO_CLIENTE),
                Click.on(SLC_NUMERO_CLIENTE.of(numeroCliente)),
                Click.on(CHK_POLITICA_PRIVA),
                Click.on(BTN_SIGUi_RECLAMANTE)
        );
    }
}
