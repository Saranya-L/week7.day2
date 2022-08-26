package runner;

import io.cucumber.testng.CucumberOptions;
import stepdefinition.ProjectSpecificMethod;
@CucumberOptions(features="src/test/java/features",glue={"stepdefinition","hooks"},monochrome=true,publish=true,tags="@smoke or @sanity")
public class RunCucumberTests extends ProjectSpecificMethod {
}
