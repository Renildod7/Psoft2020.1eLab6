package lab6;

import java.util.ArrayList;
import java.util.List;

public class SistemaVacinacao {
	
	private PessoaController pessoaController;
	private int idadeMinima;
	private List<String> comorbidades;
	private List<String> profissoesHabilitadas;
	
	
	
	public SistemaVacinacao() {
		this.pessoaController = new PessoaController();
		this.idadeMinima = 65;
		this.comorbidades = new ArrayList<String>();
		this.profissoesHabilitadas = new ArrayList<String>();
		
		this.comorbidades.add("d1");
		this.comorbidades.add("d2");
		this.comorbidades.add("d3");
		
		this.profissoesHabilitadas.add("p1");
		this.profissoesHabilitadas.add("p2");
		this.profissoesHabilitadas.add("p3");
		this.profissoesHabilitadas.add("p4");
	}


	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
		this.pessoaController.verificaHabilitacaoParaVacina(this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
	}
	
	public void adicionarNovasDoencasQueCausamComorbidade(List<String> doencas) {
		this.comorbidades.addAll(doencas);
		this.pessoaController.verificaHabilitacaoParaVacina(this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
	}
	
	public void adicionarNovasProfissoesHabilitadasReceberVacina(List<String> profissoes) {
		this.profissoesHabilitadas.addAll(profissoes);
		this.pessoaController.verificaHabilitacaoParaVacina(this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
	}
	
	public void adicionarPessoa(Pessoa pessoa) {
		pessoa.verificaHabilitacaoParaVacina(this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
		this.pessoaController.adicionarPessoa(pessoa);
	}
	


	public boolean existemPessoasCadastradas() {
		return this.pessoaController.existemPessoasCadastradas();
	}


	public boolean cpfCadastrado(String cpf) {
		return this.pessoaController.cpfCadastrado(cpf);
	}


	public void alterarNome(String cpf, String nome) {
		this.pessoaController.alterarNome(cpf, nome);

	}


	public void alterarIdade(String cpf, int idade) {
		this.pessoaController.alterarIdade(cpf, idade, this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
		
	}


	public void alterarEndereco(String cpf, String endereco) {
		this.pessoaController.alterarEndereco(cpf, endereco);		
	}


	public void alterarCartaoSus(String cpf, String cartaoSus) {
		this.pessoaController.alterarCartaoSus(cpf, cartaoSus);		
	}


	public void alterarEmail(String cpf, String email) {
		this.pessoaController.alterarEmail(cpf, email);		
	}


	public void alterarTelefone(String cpf, String telefone) {
		this.pessoaController.alterarTelefone(cpf, telefone);		
	}


	public void alterarProfissao(String cpf, String profissao) {
		this.pessoaController.alterarProfissao(cpf, profissao, this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);	
	}


	public void adicionarDoencas(String cpf, List<String> doencas) {
		this.pessoaController.adicionarDoencas(cpf, doencas, this.idadeMinima, this.comorbidades, this.profissoesHabilitadas);
		
	}


	public void tomarPrimeiraDoseDaVacina(String cpf) {
		this.pessoaController.tomarPrimeiraDoseDaVacina(cpf);
		
	}


	public void simularPassagemDeVinteDias() {
		this.pessoaController.simularPassagemDeVinteDias();
		
	}


	public void tomarSegundaDoseDaVacina(String cpf) {
		this.pessoaController.tomarSegundaDoseDaVacina(cpf);		
	}
	
	
	
	

}
