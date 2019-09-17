package br.com.b3.sinacor.stepDefinition;

import br.com.b3.sinacor.reports.LogReport;
import cucumber.api.java.en.Given;

public class GlobalSteps {

	@Given("^Que eu quero testar \"([^\"]*)\"$")
	public void que_eu_quero_testar(String arg1) throws Throwable {
		LogReport.createTest("Iniciando o Teste: " + arg1);
	}
}
