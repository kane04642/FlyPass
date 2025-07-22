package com.grupoemi.socloud.tasks.menuPrincipal;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.grupoemi.socloud.userinterface.MenuPrincipal.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MenuRecepcionLlamada implements Task {

    public static  MenuRecepcionLlamada crear(){
        return instrumented(MenuRecepcionLlamada.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(LNK_MENU_PRINCIPAL),
                Click.on(BTN_INICIAR_LLAMADA)

        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Serenity.takeScreenshot();
    }
}
