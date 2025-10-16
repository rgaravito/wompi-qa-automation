package co.com.wompi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner para ejecutar los escenarios BDD de Cucumber
 * Configura la ejecución de las features y genera reportes
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/pse_payment.feature",
        glue = "co.com.wompi.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml"
        },
        monochrome = true,
        publish = false
)
public class TestRunner {
}