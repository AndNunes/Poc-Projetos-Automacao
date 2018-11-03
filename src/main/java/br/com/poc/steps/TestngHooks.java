package br.com.poc.steps;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.poc.utils.Driver;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

public class TestngHooks {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		
		Driver.setUpDriver();
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}
 
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
	
		Driver.finalizaDriver();
		testNGCucumberRunner.finish();
	}

}
	