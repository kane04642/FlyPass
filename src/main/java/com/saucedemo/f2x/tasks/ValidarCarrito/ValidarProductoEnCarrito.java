package com.saucedemo.f2x.tasks.ValidarCarrito;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.saucedemo.f2x.userinterface.Login.LNK_CARRITO;
import static com.saucedemo.f2x.userinterface.Login.PRODUCTO_EN_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidarProductoEnCarrito implements Task {

    private final String nombreProducto;

    public ValidarProductoEnCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static ValidarProductoEnCarrito conNombre(String nombreProducto) {
        return instrumented(ValidarProductoEnCarrito.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LNK_CARRITO),
                Ensure.that(PRODUCTO_EN_CARRITO(nombreProducto))
                        .isDisplayed()
        );
    }

}
