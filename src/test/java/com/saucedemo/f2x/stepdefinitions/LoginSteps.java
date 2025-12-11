package com.saucedemo.f2x.stepdefinitions;


import com.saucedemo.f2x.tasks.Autenticar;
import com.saucedemo.f2x.tasks.Login;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginSteps {
    
    @Dado("el usuario navega a la pagina autenticador")
    public void el_usuario_navega_a_la_pagina_autenticador() {

        theActorInTheSpotlight().wasAbleTo(
                Login.cloud()
        );
    }

    @Cuando("el usuario ingresa las credenciales para autenticacion {string}")
    public void elUsuarioIngresaLasCredencialesParaAutenticacion(String actor) {
        theActorInTheSpotlight().wasAbleTo(
                Autenticar.cloud(actor)
        );
    }


    @Entonces("el usuario visualiza pagina de inicio")
    public void elUsuarioVisualizaPaginaDeInicio() {
        theActorInTheSpotlight().
                should(
                        seeThat(com.saucedemo.f2x.questions.HomePageVisible.isVisible())
                );
    }

    @Dado("que se ejecuta el caso de prueba {string}")
    public void queSeEjecutaElCasoDePrueba(String testCase) {
        Serenity.setSessionVariable("CURRENT_TEST_CASE").to(testCase);
    }


}
