package com.grupoemi.seguridad.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        features = "src/test/resources/features/seguridad/Login.feature",
        glue = "com.grupoemi.seguridad.stepdefinitions"
//        plugin = {"rerun:target/rerunFailed/FailedScenariosRerun.txt"},
//        tags = "@Titular_Beneficiario_Producto_Virtual_No"
)

public class SeguridadLogin {
}
