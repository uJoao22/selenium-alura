package br.com.alura.leiloes;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) { //Recebe em seu constructor o navegador que está sendo usado nos teste anteriores
		this.browser = browser; //Define como seu navegador
	}

	public void fechar() {
		this.browser.quit();
	}

	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		//Recuperando os inputs pelo seus ID's e inserindo uma informação nele
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		this.browser.findElement(By.id("button-submit")).submit(); //Submetendo o formulario
		return new LeiloesPage(browser); //Retornando uma instancia de LeiloesPage com o navegador como parametro
	}

	public boolean isPaginaAtual() {
		//Verificando se URL em que o navegador está é a mesma de URL_CADASTRO_LEILAO
		return this.browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
	}

	public boolean isMensagemDeValidacaoVisiveis() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("não deve estar em branco")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
