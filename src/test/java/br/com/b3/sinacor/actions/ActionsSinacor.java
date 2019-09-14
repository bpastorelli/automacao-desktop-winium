package br.com.b3.sinacor.actions;

import static org.junit.Assert.assertTrue;

import java.util.Objects;
import br.com.b3.sinacor.pages.CalculadoraPage;

public class ActionsSinacor {

	private CalculadoraPage calculadoraPage = new CalculadoraPage();
	
	public void digitarNumero(String numero) throws InterruptedException {
		
		calculadoraPage.clicarNumero(numero);
	}
	
	public void digitarSinal(String sinal) {
		
		calculadoraPage.clicarSinalAdicao(sinal);
	}
	
	public void validarResultado(String resultado) {
		
		assertTrue("Validar resultado da conta", Objects.equals(resultado, calculadoraPage.retornaValorDisplay(resultado)));
	}
	
}
