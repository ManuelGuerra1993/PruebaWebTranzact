package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Definicion de la ejecución del testrunner con cucumber
@RunWith(Cucumber.class)
//Definicion del cucumber a ejecutar
//features tiene la ruta donde encontrar los casos de prueba
//glue tiene acceso a los definitios
//tags se define mediante etiquetas que casos de pruebas ejecutar. 1 a 1 o todos los que sean igual al tag definido.
@CucumberOptions(features = "src/test/resources/feature",glue = "definitions", tags = "@FlujoPrincipal",
        monochrome = true)

public class TestRunner {
}
