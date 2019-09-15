package br.com.b3.sinacor.actions;

import java.util.Objects;

import br.com.b3.sinacor.pages.CalculadoraPage;
import br.com.b3.sinacor.reports.LogReport;

public class ActionsSinacor {

	private CalculadoraPage calculadoraPage = new CalculadoraPage();
	
	public void digitarNumero(String numero) throws InterruptedException {
		
		calculadoraPage.clicarNumero(numero);
	}
	
	public void digitarSinal(String sinal) {
		
		calculadoraPage.clicarSinalAdicao(sinal);
	}
	
	public void validarResultado(String resultado, String operacao) {
		
		LogReport.passFail(Objects.equals(resultado, calculadoraPage.retornaValorDisplay(resultado)), "Validar resultado da operacao: " + operacao + "<br>-Esperado: " + resultado + "<br>-Retornado: " + calculadoraPage.retornaValorDisplay(resultado));
	}
	
}
