package br.com.b3.sinacor.stepDefinition;

import br.com.b3.sinacor.actions.ActionsSinacor;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SinacorStep {
	
	private ActionsSinacor actionsSinacor = new ActionsSinacor();
	
	@Given("^Que eu digito o numero (.*)$")
	public void que_eu_digito_o_numero(String numero) throws InterruptedException {
		
		actionsSinacor.digitarNumero(numero);
	}
	
	@And("^Que eu digito o sinal de (.*)$")
	public void que_eu_digito_o_sinal_de(String sinal) {
		
		actionsSinacor.digitarSinal(sinal);
	}
	
	@Then("^Recebo o resultado de (.*)$")
	public void recebo_o_resultado_de(String resultado) {
		
		actionsSinacor.validarResultado(resultado);
	}
	
}
