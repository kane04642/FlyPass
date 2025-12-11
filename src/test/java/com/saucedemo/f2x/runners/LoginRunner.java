package com.saucedemo.f2x.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@AgregarProducto",
        features = "src/test/resources/features",
        glue = "com.saucedemo.f2x"
)

public class LoginRunner {
}
