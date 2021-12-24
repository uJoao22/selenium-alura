package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

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
		
		//Definindo um timeout, um tempo de espera, defininfo que o selenium vai ter um determinado tempo de espera pra buscar um elemento até dar errp
		//Ou um determinado tempo de espera para a página carregar, pageLoadTimeout()
		//(tempo, tipo da contagem)
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	public void fechar() {
		//Fechando o navegador
		this.browser.quit();
	}

}
