package br.com.b3.sinacor.stepDefinition;

import br.com.b3.sinacor.actions.ActionsSinacor;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SinacorStep {
	
	private ActionsSinacor actionsSinacor = new ActionsSinacor();
	
	@Given("^Que eu digito o numero (.*)$")
	public void que_eu_digito_o_numero(String numero) throws InterruptedException {
		
		actionsSinacor.digitarNumero(numero);
	}
	
	@When("^Que eu digito o sinal de (.*)$")
	public void que_eu_digito_o_sinal_de(String sinal) {
		
		actionsSinacor.digitarSinal(sinal);
	}
	
	@Then("^Recebo o resultado de (.*) da operacao (.*)$")
	public void recebo_o_resultado_de(String resultado, String operacao) {
		
		actionsSinacor.validarResultado(resultado, operacao);
	}
	
	@And("^Que eu digito a opcao (.*)$")
	public void que_eu_digito_a_opcao(String opcao) {
		
		actionsSinacor.digitarOpcao(opcao);
	}

}
