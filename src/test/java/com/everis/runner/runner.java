package com.everis.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

//---------------------------------------------------------
//Cucumber+Serenity Runner Configurations
//---------------------------------------------------------
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin =  {"json:target/cucumber_json/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = { "com.everis.step_definitions" }
)
public class runner {

}
