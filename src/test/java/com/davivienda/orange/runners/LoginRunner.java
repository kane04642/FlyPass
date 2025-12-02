package com.davivienda.orange.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Login",
        features = "src/test/resources/features",
        glue = "com.calidda.ov"
)

public class LoginRunner {
}
