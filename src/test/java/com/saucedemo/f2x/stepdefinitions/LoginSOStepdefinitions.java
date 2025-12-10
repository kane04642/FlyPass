package com.saucedemo.f2x.stepdefinitions;


import com.saucedemo.f2x.tasks.Autenticar;
import com.saucedemo.f2x.tasks.Login;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginSOStepdefinitions {
    
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

    @Entonces("el usuario espera la pagina de home")
    public void elusuarioesperalapaginadehome() {
        theActorInTheSpotlight().
                should(
                        seeThat(com.saucedemo.f2x.questions.HomePageVisible.isVisible())
                );
    }


}
