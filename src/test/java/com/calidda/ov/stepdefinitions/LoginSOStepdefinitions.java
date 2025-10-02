package com.calidda.ov.stepdefinitions;

import com.calidda.ov.questions.HomePageVisible;
import com.calidda.ov.tasks.AutenticarOV;
import com.calidda.ov.tasks.LoginOV;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginSOStepdefinitions {
    
    @Dado("el usuario navega a la pagina autenticador")
    public void el_usuario_navega_a_la_pagina_autenticador() {

        theActorInTheSpotlight().wasAbleTo(
                LoginOV.cloud()
        );
    }

    @Cuando("el usuario ingresa las credenciales para autenticacion {string}")
    public void elUsuarioIngresaLasCredencialesParaAutenticacion(String actor) {
        theActorInTheSpotlight().wasAbleTo(
                AutenticarOV.cloud(actor)
        );
    }

    @Entonces("el usuario espera la pagina de home")
    public void elusuarioesperalapaginadehome() {
        theActorInTheSpotlight().
                should(
                        seeThat(HomePageVisible.isVisible())
                );
    }


}
