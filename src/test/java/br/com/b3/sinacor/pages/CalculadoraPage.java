package br.com.b3.sinacor.pages;

import org.openqa.selenium.By;

public class CalculadoraPage extends BasePage {
	
	public CalculadoraPage() {
		
		this.addElement("btnAdicao", By.name("Adicionar"));
	}
	
	public void clicarNumero(String numero) {
		
		if(numero.length() > 1) {
			for (int i = 0; i < numero.length(); i++) {
				char c = numero.charAt(i);
				clickElement(By.name(String.valueOf(c)));
			}
		} else {
			clickElement(By.name(numero));
		}
	}
	
	public void clicarSinalAdicao(String sinal) {
		
		clickElement(By.name(sinal));
	}
	
	public String retornaValorDisplay(String resultado) {
		
		return findElement(By.id("150")).getAttribute("Name");
	}

}
