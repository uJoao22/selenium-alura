package br.com.alura.leiloes;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
	
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) { //Recebe em seu constructor o navegador que está sendo usado nos teste anteriores
		this.browser = browser; //Define como seu navegador
	}

	public void fechar() {
		this.browser.quit();
	}

	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);	
		this.browser.findElement(By.id("button-submit")).submit();
		return new LeiloesPage(browser); //Retornando uma instancia de LeiloesPage com o navegador como parametro
	}
}
