package com.saucedemo.f2x.tasks.agregarProducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.saucedemo.f2x.userinterface.Login.BOTON_AGREGAR_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProducto implements Task {

    private final String nombreProducto;

    public AgregarProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static AgregarProducto alCarrito(String nombreProducto) {
        return instrumented(AgregarProducto.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_AGREGAR_PRODUCTO(nombreProducto))
        );
    }


}
