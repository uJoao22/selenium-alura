package br.com.alura.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
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

	public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		//Recuperando elementos do HTML usando seletor CSS e salvando este elemento em um objeto do tipo WebElement
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)")); 
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)")); 
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)")); 
		
		//Verificando se o leilão foi cadastrado através do nome, valor e data do ultimo leilão da tabela de leilões
		return colunaNome.getText().equals(nome) 
				&& colunaDataAbertura.getText().equals(dataAbertura) 
				&& colunaValorInicial.getText().equals(valorInicial);
	}

	public boolean isPaginaAtual() {
		//Verificando se a URL que o navegador está é a mesma da variavel URL_LEILOES
		return browser.getCurrentUrl().equals(URL_LEILOES);
	}
}