package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

		features= {"src/test/java/featureFiles"}, 
		glue= {"src","test","java","stepdef"},
		dryRun = false,
		strict = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE




		

)

public class MainTestRunner {



}
