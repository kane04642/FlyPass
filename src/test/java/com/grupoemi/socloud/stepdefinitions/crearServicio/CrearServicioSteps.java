package com.grupoemi.socloud.stepdefinitions.crearServicio;

import com.grupoemi.socloud.tasks.LoginSO;
import com.grupoemi.socloud.tasks.crearServicio.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearServicioSteps {


    @Cuando("El paramedico ingresa los datos de informacion del cliente {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void elParamedicoIngresaLosDatosDeInformacionDelCliente(String tipoSolicitante, String tipoDocumento, String numeroDocumento, String telefono, String celular, String email, String nombre, String edad, String tipoEdad, String sexo, String pais) {
        theActorInTheSpotlight().wasAbleTo(
                InformacionPaciente.crearIP(tipoSolicitante, tipoDocumento, numeroDocumento, telefono, celular, email, nombre, edad, tipoEdad, sexo, pais)
        );
    }
    @Cuando("El paramedico ingresa datos motido de consulta {string} {string}")
    public void el_paramedico_ingresa_datos_motido_de_consulta(String motivo, String cuadroClinico) {
        theActorInTheSpotlight().wasAbleTo(
                MotivoConsulta.motivo(motivo, cuadroClinico)
        );
    }

    @Cuando("El paramedico ingresa clasificacion de la atencion {string}")
    public void el_paramedico_ingresa_clasificacion_de_la_atencion(String clasificacion) {

        theActorInTheSpotlight().wasAbleTo(
                Clasificacion.casifica(clasificacion)
        );
    }

    @Cuando("El paramedico ingresa informacion geografica {string} {string} {string}")
    public void el_paramedico_ingresa_informacion_geografica(String ciudad, String barrio, String direccion) {

        theActorInTheSpotlight().wasAbleTo(
                InformacionGeografica.deUsuario(ciudad, barrio, direccion)
        );
    }

    @Cuando("El paramedico da click en generar servicio")
    public void el_paramedico_da_click_en_generar_servicio() {

        theActorInTheSpotlight().wasAbleTo(
                BotonGenerarServicio.asServicio()
        );
    }

    @Entonces("El paramedico visualiza mensaje exitoso")
    public void el_paramedico_visualiza_mensaje_exitoso() {

    }

}
