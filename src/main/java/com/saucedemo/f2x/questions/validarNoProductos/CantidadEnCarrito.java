package com.saucedemo.f2x.questions.validarNoProductos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.saucedemo.f2x.userinterface.Login.BADGE_CARRITO;

public class CantidadEnCarrito implements Question<Integer> {
    public static CantidadEnCarrito valor() {
        return new CantidadEnCarrito();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        String cantidadTexto = BADGE_CARRITO.resolveFor(actor).getText();
        return Integer.parseInt(cantidadTexto.trim());
    }
}
