package lab6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaController {
	
	
	private Map<String,Pessoa> pessoas;
	
	public PessoaController() {
		this.pessoas = new HashMap<String,Pessoa>();
	}
	
	public void adicionarPessoa(Pessoa pessoa) {
		String cpf = pessoa.getCpf();
		if(!cpfCadastrado(cpf)) {
			this.pessoas.put(cpf, pessoa);			
		} else {
			System.out.println("O cpf " + cpf + " já foi cadastrado.");
		}
	}
	
	public boolean existemPessoasCadastradas() {
		return !this.pessoas.isEmpty();
	}


	public boolean cpfCadastrado(String cpf) {
		return this.pessoas.keySet().contains(cpf);
	}
	
	public boolean verificaCadastroPessoa(String cpf) {
		boolean cadastrado = cpfCadastrado(cpf);
		if(!cadastrado) {
			System.out.println("O cpf " + cpf + " não foi cadastrado.");
		}
		return cadastrado;
	}


	public void alterarNome(String cpf, String nome) {
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setNome(nome);
			this.pessoas.put(cpf,pessoa);
		}


	}


	public void alterarIdade(String cpf, int idade, int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas) {
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setIdade(idade);
			pessoa.verificaHabilitacaoParaVacina(idadeMinima, comorbidades, profissoesHabilitadas);
			this.pessoas.put(cpf,pessoa);
		}

		
	}


	public void alterarEndereco(String cpf, String endereco) {
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setEndereco(endereco);
			this.pessoas.put(cpf,pessoa);
		}
		
	}


	public void alterarCartaoSus(String cpf, String cartaoSus) {
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setCartaoSus(cartaoSus);
			this.pessoas.put(cpf,pessoa);
		}
		
	}


	public void alterarEmail(String cpf, String email) {
		
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setEmail(email);
			this.pessoas.put(cpf,pessoa);
		}
		
	}


	public void alterarTelefone(String cpf, String telefone) {
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setTelefone(telefone);
			this.pessoas.put(cpf,pessoa);
		}
		
	}


	public void alterarProfissao(String cpf, String profissao, int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas) {
		
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.setProfisao(profissao);
			pessoa.verificaHabilitacaoParaVacina(idadeMinima, comorbidades, profissoesHabilitadas);
			this.pessoas.put(cpf,pessoa);
		}
		
	}


	public void adicionarDoencas(String cpf, List<String> doencas, int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas) {
		
		if(verificaCadastroPessoa(cpf)) {
			
			Pessoa pessoa = this.pessoas.get(cpf);
			pessoa.adicionarDoencas(doencas);
			pessoa.verificaHabilitacaoParaVacina(idadeMinima, comorbidades, profissoesHabilitadas);
			this.pessoas.put(cpf,pessoa);
			
		}
		

		
	}

	public void verificaHabilitacaoParaVacina(int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas) {
		for (Pessoa pessoa : this.pessoas.values()) {
			if(pessoa.estagioNaoHabilitado()) {
				pessoa.verificaHabilitacaoParaVacina(idadeMinima, comorbidades, profissoesHabilitadas);
				this.pessoas.put(pessoa.getCpf(), pessoa);
			}
		}
		
	}

	public void tomarPrimeiraDoseDaVacina(String cpf) {
		
		if(verificaCadastroPessoa(cpf)) {
				
			Pessoa pessoa = this.pessoas.get(cpf);
			if(pessoa.estagioHabilitadaPrimeiraDose()) {
				pessoa.tomarPrimeiraDoseDaVacina();
				this.pessoas.put(cpf, pessoa);
			} else if (pessoa.estagioNaoHabilitado()){
				System.out.println(pessoa.toString() + " não está habilitada a receber a vacina.");
			} else if(pessoa.estagioVacinacaoFinalizada()){
				System.out.println(pessoa.toString() + " já finalizou a vacinação.");
			} else {
				System.out.println(pessoa.toString() + " já recebeu a primeira dose da vacina.");
			}
		}
		
	}

	public void simularPassagemDeVinteDias() {
		for (Pessoa pessoa : this.pessoas.values()) {
			if(pessoa.estagioTomouPrimeiraDose()) {
				pessoa.habilitarSergundaDose();
				this.pessoas.put(pessoa.getCpf(), pessoa);
			}
		}
		
	}

	public void tomarSegundaDoseDaVacina(String cpf) {
		
		if(verificaCadastroPessoa(cpf)) {
			Pessoa pessoa = this.pessoas.get(cpf);
			if(pessoa.estagioHabilitadaSegundaDose()) {
				pessoa.tomarSegundaDoseDaVacina();
				this.pessoas.put(cpf, pessoa);
			} else if (pessoa.estagioVacinacaoFinalizada()){
				System.out.println(pessoa.toString() + " já concluio a vacinação.");
			} else {
				System.out.println(pessoa.toString() + " não está abilitado para receber a segunda dose da vacina.");
			}
		
		}
		
	}
}
