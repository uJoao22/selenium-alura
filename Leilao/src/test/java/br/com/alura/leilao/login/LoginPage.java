package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject{
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() { //Criando um constructor do Object Page
		super(null); //Chamando o constructor da class Pai, o login irá passar null
		//Acessando o endereço da aplicação
		this.browser.navigate().to(URL_LOGIN); //Chrome, navegue para o endereço determinado
	}

	public void preencheFormularioDeLogin(String username, String password) {
		//Buscando os elementos input na página pelo ID deles e inserindos os dados de login neles para o teste
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuarLogin() {		
		//Buscando o formulario pelo seu ID e submetendo ele
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser); //Quando este método for chamado ele irá retornar uma nova instancia de LeiloesPage, passando o navegador que já está aberto como parametro 
	}

	public boolean isPaginaDeLogin() {
		//Pegando a url em que estou e verificar se ela é igual a url comparada
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		//Recuperando o texto do elemento com o ID determinado
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch(NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(URL_LOGIN+"?error");
	}
	
}