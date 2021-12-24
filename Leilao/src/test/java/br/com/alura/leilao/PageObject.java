package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		//Informando o caminho do executavel do drive do google chrome
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		//Abrindo o navegador
		if(browser == null) {
			//Criando uma variavel do tipo WebDriver que recebe uma instancia de ChromeDriver
			this.browser = new ChromeDriver(); 
		} else {
			//Se já existir uma instancia de ChromeDriver ele aproveita ela
			this.browser = browser; 
		}
	}
	
	public void fechar() {
		//Fechando o navegador
		this.browser.quit();
	}

}
