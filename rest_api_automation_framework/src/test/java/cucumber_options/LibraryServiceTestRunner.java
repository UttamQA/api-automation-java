package cucumber_options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/LibraryMicroservice"
,glue= {"stepdefinitions"}
,plugin= {"pretty"
		,"html:target/jsonReports/cucumber-reports.html"
		,"json:target/jsonReports/cucumber-reports.json"})
public class LibraryServiceTestRunner {

}
