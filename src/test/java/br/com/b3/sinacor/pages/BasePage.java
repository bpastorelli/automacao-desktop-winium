package br.com.b3.sinacor.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.b3.sinacor.commons.SetupEnviroment;
import br.com.b3.sinacor.reports.LogReport;
import br.com.b3.sinacor.util.Utils;

public class BasePage extends SetupEnviroment {
	
	private static WebElement element;
	
	private static HashMap<String, Object> mapElements = new HashMap<String, Object>();
	
	/**
	 * Adiciona um elemento mapeado ao mapa de elementos.
	 * 
	 * @param name Nome que será atribuido ao elemento.
	 * @param by Condição de busca Id, Name e etc.
	 */
	public void addElement(String name, By by) {
		
		mapElements.put(name, by);
	}
	
	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return WebElemento
	 */
	protected WebElement getElement(String name) {
		
		try {
			By by = (By) mapElements.get(name);
			element = driver.findElement(by);
		}catch(Exception e) {
			LogReport.fail(e.getMessage());
		}
		
		return element;
	}
	
	/**
	 * Busca elemento pelo By (name, id, xpath...)
	 * 
	 * @param by By.Id, By.Name, By.Xpath...
	 * @return WebElement
	 */
	protected WebElement findElement(By by) {
		
		element = null;
		try {
			element = driver.findElement(by);	
		}catch(Exception e) {
			LogReport.fail("[FALHA]Elemento " + by.toString() + " nao encontrado.");
		}
		
		return element;
	}
	
	/**
	 * Busca elementos pela ClassName CSS
	 * 
	 * @param className Classe CSS
	 * @return Lista de elementos
	 */
	protected List<WebElement> findElementsByClassName(String className){
		
		return driver.findElementsByClassName(className);
	}
	
	/**
	 * Clica um elemento pelo nome informado no mapElements
	 * 
	 * @param name Nome do elemento
	 */
	protected void clickElementByName(String name) {
		
		try {
			element = getElement(name);
			element.click();	
		}catch(Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}
	
	/**
	 * Clica no elemento a partir do By.
	 * 
	 * @param by Id, Name, Xpath...
	 */
	protected void clickElement(By by) {
		
		try {
			findElement(by).click();
		}catch(Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + by.toString() + ".");
		}		
	}
	
	/**
	 * Move o mouse para o elemento e clica.
	 * 
	 * @param name nome do elemento no mapa de elementos.
	 */
	protected void moveToElementClick(String name) {
	
		try {
			element = getElement(name);
			new Actions(driver).moveToElement(element).click().perform();
		}catch(Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}
	
	/**
	 * Aguarda o elemento visível
	 *  
	 * @param elemento Elemento a ser aguardado
	 * @param time Tempo limite de espera
	 * @return Retorna true caso esteja visível ou false caso não esteja visível.
	 */
    public static boolean waitDisplayed(WebElement elemento, int time) {
    	
    	boolean retorno = false;
    	for(int i = 0; i < time; i++) {
    		if(!elemento.isDisplayed())
    			Utils.wait(1);
    		else
    			return true;
    	}
    	
    	if(!retorno)
    		LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (timeout = " + time + ").");
    	return retorno;
    }
    
    /**
     * Aguarda um determinado texto ser aprensentado na tela.
     * 
     * @param elemento Elemento que contém o texto esperado.
     * @param texto Texto a ser apresentado.
     * @param time Tempo limite de espera.
     * @return Retorna true caso o texto esteja presente e false caso não esteja presente. 
     */
    public static boolean waitText(WebElement elemento, String texto, int time) {
    	
    	//Aguarda por determinado texto por ate o tempo informado na vari�vel time.
    	boolean retorno = false;
    	for(int i = 0; i < time; i++) {
    		if(!elemento.getText().contains(texto))
    			Utils.wait(1);
    		else
    			return true;
    	}
    	
    	if(!retorno)
    		LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + time + ").");
    	return retorno;
    }
}
