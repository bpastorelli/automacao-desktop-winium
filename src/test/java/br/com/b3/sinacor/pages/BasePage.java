package br.com.b3.sinacor.pages;

import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.b3.sinacor.commons.SetupEnviroment;

public class BasePage extends SetupEnviroment {
	
	public static WebElement element;
	public static HashMap<String, Object> mapElements = new HashMap<String, Object>();
	
	public void addElement(String name, By by) {
		
		mapElements.put(name, by);
	}
	
	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return Elemento
	 */
	protected WebElement getElement(String name) {
		
		try {
			By by = (By) mapElements.get(name);
			element = driver.findElement(by);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertFalse(true);
		}
		
		return element;
	}
	
	protected WebElement findElement(By by) {
		
		element = null;
		try {
			element = driver.findElement(by);	
		}catch(Exception e) {
			new Exception("Elemento " + by.toString() + "não encontrado.");
		}
		
		return element;
	}
	
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
			new Exception("Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}
	
	
	protected void clickElement(By by) {
		
		try {
			findElement(by).click();
		}catch(Exception e) {
			new Exception("Falha ao clicar no elemento " + element.getTagName() + ".");
		}		
	}
	
	protected void moveToElementClick(String name) {
	
		try {
			element = getElement(name);
			new Actions(driver).moveToElement(element).click().perform();
		}catch(Exception e) {
			new Exception("Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}
}
