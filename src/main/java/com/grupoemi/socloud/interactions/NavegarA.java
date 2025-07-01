package com.grupoemi.socloud.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavegarA {

    private NavegarA() {
        throw new UnsupportedOperationException("This class is not meant to be instantiated");
    }
    public static Performable seguridadHomePage() {
        return Task.where("abre la pagina de SO  Cloud",
                Open.browserOn().the(authenticationHomePage.class)
        );
    }
}
