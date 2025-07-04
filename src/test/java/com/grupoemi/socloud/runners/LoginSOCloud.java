package com.grupoemi.socloud.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@LoginSO",
        features = "src/test/resources/features",
        glue = "com.grupoemi.socloud"
)

public class LoginSOCloud {
}
