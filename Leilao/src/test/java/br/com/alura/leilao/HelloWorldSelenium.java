package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

	@Test
	public void hello() {
		//Informando o caminho do executavel do drive do google chrome
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		//Abrindo o navegador
		WebDriver browser = new ChromeDriver(); //Criando uma variavel do tipo WebDriver que recebe uma instancia de ChromeDriver
		
		//Acessando o endereço da aplicação
		browser.navigate().to("http://localhost:8080/leiloes"); //Chrome, navegue para o endereço determinado
		
		//Fechando o navegador
//		browser.quit();
	}
}
