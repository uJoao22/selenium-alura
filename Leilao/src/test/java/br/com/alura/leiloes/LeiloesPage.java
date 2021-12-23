package br.com.alura.leiloes;

//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private WebDriver browser;
	
	public LeiloesPage(WebDriver browser) { //No constructor da class LeiloesPage ela recebe o navegador que estava sendo usado nos testes de login
		this.browser = browser; //E o navegador dela começa a ser o mesmo
	}

	public void fechar() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() { //Quando este método for chamado...
		this.browser.navigate().to(URL_CADASTRO_LEILAO); //O navegador será redirecionado para a URL de cadastrar um novo leilão
		return new CadastroLeilaoPage(browser); //E o método irá retornar uma instancia de CadastroLeilaoPage passando o navegador em uso como parametro
	}
}