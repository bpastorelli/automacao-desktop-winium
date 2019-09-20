package br.com.b3.sinacor.pages;

import org.openqa.selenium.By;

import br.com.b3.sinacor.util.Utils;

public class CalculadoraPage extends BasePage {
	
	public CalculadoraPage() {
		
		this.addElement("btnMaximize", By.id("Maximize"));
	}
	
	public void clicarNumero(String numero) {
		
		if(Utils.isNumeric(numero)) {
			if(numero.length() > 1) {
				for (int i = 0; i < numero.length(); i++) {
					char c = numero.charAt(i);
					clickElement(By.name(Utils.convertNumeroToNome(String.valueOf(c))));
				}
			} else {
				clickElement(By.name(Utils.convertNumeroToNome(numero)));
			}
		}
	}
	
	public void clicarSinal(String sinal) {
		
		clickElement(By.name(sinal));
	}
	
	public void clicarOpcao(String opcao) {
		
		clickElement(By.name(opcao));
	}
	
	public String retornaValorDisplay(String resultado) {
		
		return findElement(By.name(resultado)).getAttribute("Name");
	}
}
