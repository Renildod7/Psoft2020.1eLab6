package lab6;

import java.util.List;

import lab6.estagiovacinacao.EstagioVacinacao;
import lab6.estagiovacinacao.HabilitadaPrimeiraDose;
import lab6.estagiovacinacao.HabilitadaSegundaDose;
import lab6.estagiovacinacao.NaoHabilitada;
import lab6.estagiovacinacao.TomouPrimeiraDose;
import lab6.estagiovacinacao.VacinacaoFinalizada;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private int idade;
	private String endereco;
	private String cartaoSus;
	private String email;
	private String telefone;
	private String profissao;
	private List<String> doencas;
	private EstagioVacinacao estagioVacinacao;
	
	public Pessoa(String nome, String cpf, int idade, String endereco, String cartaoSus, String email, String telefone,
			String profissao, List<String> doencas) {

		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.cartaoSus = cartaoSus;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.doencas = doencas;
		
		this.estagioVacinacao = new NaoHabilitada();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setProfisao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public void adicionarDoencas(List<String> doencas) {
		this.doencas.addAll(doencas);
		
	}
	
	public void setEstagioVacinacao(EstagioVacinacao estagioVacinacao) {
		this.estagioVacinacao = estagioVacinacao;
	}
	
	public int getIdade() {
		return idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public List<String> getDoencas() {
		return doencas;
	}

	public boolean estagioNaoHabilitado() {
		return this.estagioVacinacao instanceof NaoHabilitada;
	}
	
	public boolean estagioHabilitadaPrimeiraDose() {
		return this.estagioVacinacao instanceof HabilitadaPrimeiraDose;
	}
	
	public boolean estagioTomouPrimeiraDose() {
		return this.estagioVacinacao instanceof TomouPrimeiraDose;
	}
	
	public boolean estagioHabilitadaSegundaDose() {
		return this.estagioVacinacao instanceof HabilitadaSegundaDose;
	}
	
	public boolean estagioVacinacaoFinalizada() {
		return this.estagioVacinacao instanceof VacinacaoFinalizada;
	}
	
	public void verificaHabilitacaoParaVacina(int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas) {
		((NaoHabilitada) this.estagioVacinacao).verificaHabilitacao(idadeMinima, comorbidades, profissoesHabilitadas, this);
	}

	public void tomarPrimeiraDoseDaVacina() {
		((HabilitadaPrimeiraDose) this.estagioVacinacao).tomarPrimeiraDose(this);
		
	}

	public void habilitarSergundaDose() {
		((TomouPrimeiraDose) this.estagioVacinacao).habilitarSegundaDose(this);;
		
	}

	public void tomarSegundaDoseDaVacina() {
		((HabilitadaSegundaDose) this.estagioVacinacao).tomarSegundaDose(this);
		
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.cpf;
	}
	
	
	

}
