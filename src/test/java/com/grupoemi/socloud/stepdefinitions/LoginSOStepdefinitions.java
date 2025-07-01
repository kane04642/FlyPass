package com.grupoemi.socloud.stepdefinitions;

import com.grupoemi.socloud.interactions.NavegarA;
import com.grupoemi.socloud.questions.HomePageVisible;
import com.grupoemi.socloud.tasks.LoginDA;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Map;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginSOStepdefinitions {
    
    @Dado("el usuario navega a la pagina autenticador")
    public void el_usuario_navega_a_la_pagina_autenticador() {
        theActorInTheSpotlight().
                wasAbleTo(
                        NavegarA.seguridadHomePage()
                );
    }

    @Cuando("el usuario ingresa las credenciales para autenticacion")
    public void elusuarioingresalascredencialesparaautenticacion(Map<String, String>datosAccesos) {
        theActorInTheSpotlight().
                wasAbleTo(
                        LoginDA.directorio(datosAccesos)
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
