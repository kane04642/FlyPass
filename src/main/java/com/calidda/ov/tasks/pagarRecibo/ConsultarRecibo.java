package com.calidda.ov.tasks.pagarRecibo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import java.util.Map;
import static com.calidda.ov.userinterface.pagoRecibos.PagoRecibos.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarRecibo implements Task {
    private final Map<String, String> NoRecibo;

    public ConsultarRecibo(Map<String, String> NoRecibo) {
        this.NoRecibo = NoRecibo;
    }


    public static ConsultarRecibo pago(Map<String, String> NoRecibo){
        return instrumented(ConsultarRecibo.class, NoRecibo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LIS_RECIBO),
                Click.on(SLC_RECIBO.of(NoRecibo.get("NoRecibo"))),
                Click.on(CHK_RECIBO_PAGO),
                Click.on(BTN_PAGAR)
        );
    }
}
