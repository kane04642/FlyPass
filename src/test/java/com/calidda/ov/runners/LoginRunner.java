package com.calidda.ov.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@ReclamoCliente",
        features = "src/test/resources/features",
        glue = "com.calidda.ov"
)

public class LoginRunner {
}
