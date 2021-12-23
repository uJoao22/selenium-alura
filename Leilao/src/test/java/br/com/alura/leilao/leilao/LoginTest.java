package br.com.alura.leilao.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	//Código que será executado antes de começar o primeiro teste
	@BeforeAll
	public static void beforeAll() {
		//Informando o caminho do executavel do drive do google chrome
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	}
	
	//Código que será executado antes de cada um dos testes
	@BeforeEach
	public void beforeEach() {
		//Abrindo o navegador
		this.browser = new ChromeDriver(); //Criando uma variavel do tipo WebDriver que recebe uma instancia de ChromeDriver
		
		//Acessando o endereço da aplicação
		this.browser.navigate().to(URL_LOGIN); //Chrome, navegue para o endereço determinado
	}
	
	//Código que será executado depois de cada um dos testes
	@AfterEach
	public void afterEach() {
		this.browser.quit();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		//Buscando os elementos input na página pelo ID deles e inserindos os dados de login neles para o teste
		browser.findElement(By.id("username")).sendKeys("fulano");
		browser.findElement(By.id("password")).sendKeys("pass");
		
		//Buscando o formulario pelo seu ID e submetendo ele
		browser.findElement(By.id("login-form")).submit();
		
		//Usando assertiva do JUnit 
		//Pegando a url em que estou e verificar se ela é igual a url comparada, esperamos que retorne false
		//Usando o getCurrentUrl para pegar a url em que o navegador está no momento
		Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
		
		//Comparando se o texto escrito no elemento recuperado com o ID é o mesmo texto que determinamos
		Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
		
		//Fechando o navegador
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("123123");
		browser.findElement(By.id("login-form")).submit();
		
		//Pegando a url do navegador e comparando com a url determinada, esperando que retorne true 
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		
		//Pegando o código fonta de página e verificando se nele contém a mensagem determinada, esperando que retorne true
		//Usando getPageSource para me retornar todo o código fonta da página em formato de sting
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		
		//Esperando um erro, buscando um ID que não contém no código e esperando que retorne a exception determianda
		Assert.assertThrows(NoSuchElementException.class,  () -> browser.findElement(By.id("usuario-logado")));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestridaSemEstarLogado() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");

		Assert.assertTrue(browser.getCurrentUrl().equals(URL_LOGIN));
		Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}
}