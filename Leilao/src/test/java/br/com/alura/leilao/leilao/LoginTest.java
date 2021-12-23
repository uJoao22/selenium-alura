package br.com.alura.leilao.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		//Informando o caminho do executavel do drive do google chrome
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		//Abrindo o navegador
		WebDriver browser = new ChromeDriver(); //Criando uma variavel do tipo WebDriver que recebe uma instancia de ChromeDriver
		
		//Acessando o endereço da aplicação
		browser.navigate().to("http://localhost:8080/login"); //Chrome, navegue para o endereço determinado
		
		//Buscando os elementos input na página pelo ID deles e inserindos os dados de login neles para o teste
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		
		//Buscando o formulario pelo seu ID e submetendo ele
		browser.findElement(By.id("login-form")).submit();
		
		//Usando assertiva do JUnit 
		//Pegando a url em que estou e verificar se ela é igual a url comparada, esperamos que retorne false
		Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
		
		//Comparando se o texto escrito no elemento recuperado com o ID é o mesmo texto que determinamos
		Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
		
		//Fechando o navegador
		browser.quit();
	}
}