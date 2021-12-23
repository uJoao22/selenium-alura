package br.com.alura.leiloes;

//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
	
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) { //Recebe em seu constructor o navegador que está sendo usado nos teste anteriores
		this.browser = browser; //Define como seu navegador
	}

	public void fechar() {
		this.browser.quit();
	}
}
