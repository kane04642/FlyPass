package com.calidda.ov.tasks.pagarRecibo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.calidda.ov.userinterface.pagoRecibos.PagoRecibos.BTN_PAGO_RECIBO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MenuPagoRecibo implements Task {
    public static MenuPagoRecibo seleccionar(){
        return instrumented(MenuPagoRecibo.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PAGO_RECIBO)
        );

    }
}
