package br.com.alura.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.login.LoginPage;

public class LeiloesTest {
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage(); //Instanciando a class de LoginPage para ter acesso aos seus métodos
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass"); //Chamando o método de prencher o formulario com os dados
		this.paginaDeLeiloes = paginaDeLogin.efetuarLogin(); //A paginaDeLeiloes recebe o resultado do método efetuarLogin, que é uma instancia do navegador usado nos teste de login
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario(); //A paginaDeCadastro recebe o resultado do método carregarFromulario, que é uma instancia de CadastroLeilaoPage 
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		//Recuperando a data do dia atual e formatando para o formato dia/mês/ano
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
		String nome = "Leilão do dia: " + hoje;
		String valor = "500.00";
		
		//A paginaDeLeiloes recebe o resultado do método que é uma instancia de LeiloesPage com o navegador como parametro
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje); 
		
		//Verificando se o leilao foi cadastrado corretamente
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		//Chamando o método de cadastrarLeilao e passando strings em branco como parametro e recebendo como retorno o navegador usado 
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual()); //Verificando se a URL é false
		Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual()); //Verificando se a URL é verdadeira
		Assert.assertTrue(this.paginaDeCadastro.isMensagemDeValidacaoVisiveis()); //Verificando se as mensagens de validação aparecerem
	}
}
