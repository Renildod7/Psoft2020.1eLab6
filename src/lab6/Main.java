package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		SistemaVacinacao sistemaVacinacao = new SistemaVacinacao();
		
		Scanner sc = new Scanner(System.in);
		exibeEstadoInicial();
		boolean sair = false;
		while(!sair) {
			exibeMenu();
			int opcao = sc.nextInt();
			sc.nextLine();
			
			if(!opcaoValida(opcao)) {
				opcaoInvalida();
			} else if(opcao == 9){
				sair = true;
			} else {
				processaOpcao(sistemaVacinacao, opcao, sc);				
			}
		}
		
		sc.close();
	}

	private static void exibeEstadoInicial() {
		System.out.println("\nIdade minima inicial: 65"
				+ "\nProfissões habilitadas a receber a vacina iniciais: p1, p2, p3 e p4"
				+ "\nDoenças que causam comorbidade iniciais: d1, d2 e d3");
		
	}

	private static void exibeMenu() {
		System.out.println("\n1) Cadastrar pessoa."
				+ "\n2) Alterar Cadastro."
				+ "\n3) Alterar idade minima."
				+ "\n4) Adicionar novas doenças que causam comorbidade."
				+ "\n5) Adicionar novas profissões habilitadas a receber a vacina."
				+ "\n6) Tomar primeira dose da vacina."
				+ "\n7) Simular passagem de 20 dias."
				+ "\n8) Tomar segunda dose da vacina."
				+ "\n9) Sair.");
		
	}
	
	private static void opcaoInvalida() {
		System.out.println("Opção Inválida!\n");
	}
	
	
	


	
	
	//  FALTA ARRUMAR
	private static boolean opcaoValida(int opcao) {
		return opcao>=1 && opcao<=9;
	}
	
	private static void processaOpcao(SistemaVacinacao sistemaVacinacao, int opcao, Scanner sc) {
		switch (opcao) {
		case 1:
			cadastrarPessoa(sistemaVacinacao, sc);
			break;
		case 2:
			alterarCadastro(sistemaVacinacao, sc);
			break;
		case 3:
			alterarIdadeMinima(sistemaVacinacao, sc);
			break;
		case 4:
			adicionarNovasDoencasQueCausamComorbidade(sistemaVacinacao, sc);
			break;
		case 5:
			adicionarNovasProfissoesHabilitadasReceberVacina(sistemaVacinacao, sc);
			break;
		case 6:
			tomarPrimeiraDoseDaVacina(sistemaVacinacao, sc);
			break;
		case 7:
			simularPassagemDeVinteDias(sistemaVacinacao);
			break;
		case 8:
			tomarSegundaDoseDaVacina(sistemaVacinacao, sc);
			break;

		default:
			break;
		}
		
	}









	private static void cadastrarPessoa(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.println("Informe os seguintes dados para realizar o cadastro:");
		String nome = requisitarNomePessoa(sc);
		String cpf = requisitarCpfPessoa(sc);
		int idade = requisitarIdade(sc);
		String endereco = requisitarEndereco(sc);
		String cartaoSus = requisitarCartaoSus(sc);
		String email = requisitarEmail(sc);
		String telefone = requisitarTelefone(sc);
		String profisao = requisitarProfissao(sc);
		List<String> doencas = requisitarDoencas(sc);
		
		Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoSus, email, telefone, profisao, doencas);
		sistemaVacinacao.adicionarPessoa(pessoa);

		
		
	}

	private static String requisitarNomePessoa(Scanner sc) {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		return nome;
	}

	private static String requisitarCpfPessoa(Scanner sc) {
		System.out.print("Cpf: ");
		String cpf = sc.nextLine();
		return cpf;
	}

	private static int requisitarIdade(Scanner sc) {
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		sc.nextLine();
		return idade;
	}

	private static String requisitarEndereco(Scanner sc) {
		System.out.print("Endereco: ");
		String endereco = sc.nextLine();
		return endereco;
	}

	private static String requisitarCartaoSus(Scanner sc) {
		System.out.print("Cartão do SUS: ");
		String cartaoSus = sc.nextLine();
		return cartaoSus;
	}

	private static String requisitarEmail(Scanner sc) {
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		return email;
	}

	private static String requisitarTelefone(Scanner sc) {
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		return telefone;
	}

	private static String requisitarProfissao(Scanner sc) {
		System.out.print("Profissão: ");
		String profissao = sc.nextLine();
		return profissao;
	}

	private static List<String> requisitarDoencas(Scanner sc) {
		String possuiDoença = "";
		
		List<String> doencas = new ArrayList<String>();
		
		
		boolean doencasListadas = false;
		while(!doencasListadas) {
			System.out.print("Possui alguma doença? (responda s ou n): ");
			possuiDoença = sc.nextLine();
			
			if(possuiDoença.equals("s")) {
				System.out.println("Informe todas as doenças separadas por vírgula ',' e sem acentos.");
				doencas.addAll(Arrays.asList(sc.nextLine().split(",")));
				doencasListadas = true;
			} else if(possuiDoença.equals("n")) {
				doencasListadas = true;
			} else {
				System.out.println("Opção Iválida.\n");
			}
		}
		return doencas;
	}


	
	private static void alterarCadastro(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		if(!sistemaVacinacao.existemPessoasCadastradas()) {
			System.out.println("Não existem pessoas cadastradas");
		} else {
			boolean cpfExiste = false;
			while(!cpfExiste) {
				System.out.print("Cpf: ");
				String cpf = sc.nextLine();
				if(cpf.equals("voltar")){
					cpfExiste = true;
				} else if(!sistemaVacinacao.cpfCadastrado(cpf)) {
					System.out.println("Cpf inválido, informe um Cpf válido ou voltar para para voltar ao menu.");
				} else {
					
					boolean alteracaoRealizada = false;
					while(!alteracaoRealizada) {
						System.out.println("Informe a opção que deseja alterar\n1) Nome\n2) Idade\n3) Endereco\n4) Número do Cartão do SUS\n5) E-mail\n6) Telefone\n7) Profissão\n8) Adicionar uma doença");
						int opcao = sc.nextInt();
						sc.nextLine();
						if(!alterarCadastroVerificaOpcao(opcao)) {
							System.out.println("Opcção Inválida.");
						} else {
							alteraCadastroProcessaOpcao(opcao, sistemaVacinacao, sc, cpf);
							alteracaoRealizada = true;
						}
					}
					
				}
			}
		}
	}
	
	private static boolean alterarCadastroVerificaOpcao(int opcao) {
		return opcao >=1 && opcao <= 8;
	}
	
	
	private static void alteraCadastroProcessaOpcao(int opcao, SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		switch (opcao) {
		case 1:
			alterarCadastroNome(sistemaVacinacao, sc, cpf);
			break;
		case 2:
			alterarCadastroIdade(sistemaVacinacao, sc, cpf);
			break;
		case 3:
			alterarCadastroEndereco(sistemaVacinacao, sc, cpf);
			break;
		case 4:
			alterarCadastroCartaoSus(sistemaVacinacao, sc, cpf);
			break;
		case 5:
			alterarCadastroEmail(sistemaVacinacao, sc, cpf);
			break;
		case 6:
			alterarCadastroTelefone(sistemaVacinacao, sc, cpf);
			break;
		case 7:
			alterarCadastroProficao(sistemaVacinacao, sc, cpf);
			break;
		case 8:
			alterarCadastroAdicionarDoenca(sistemaVacinacao, sc, cpf);
			break;
		default:
			break;
		}
		
	}

	private static void alterarCadastroNome(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Novo nome: ");
		String nome = sc.nextLine();
		sistemaVacinacao.alterarNome(cpf, nome);
		
	}

	private static void alterarCadastroIdade(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Nova Idade: ");
		int idade = sc.nextInt();
		sc.nextLine();
		sistemaVacinacao.alterarIdade(cpf, idade);
		
	}

	private static void alterarCadastroEndereco(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Novo Endereco: ");
		String endereco = sc.nextLine();
		sistemaVacinacao.alterarEndereco(cpf, endereco);
		
	}

	private static void alterarCadastroCartaoSus(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Novo número do Cartão: ");
		String cartaoSus = sc.nextLine();
		sistemaVacinacao.alterarCartaoSus(cpf, cartaoSus);
		
	}

	private static void alterarCadastroEmail(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Novo email: ");
		String email = sc.nextLine();
		sistemaVacinacao.alterarEmail(cpf, email);
		
	}

	private static void alterarCadastroTelefone(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Novo telefone: ");
		String telefone = sc.nextLine();
		sistemaVacinacao.alterarTelefone(cpf, telefone);
		
	}

	private static void alterarCadastroProficao(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.print("Nova profissão: ");
		String profissao = sc.nextLine();
		sistemaVacinacao.alterarProfissao(cpf, profissao);
		
	}

	private static void alterarCadastroAdicionarDoenca(SistemaVacinacao sistemaVacinacao, Scanner sc, String cpf) {
		System.out.println("Informe as doenças separadas por virgula ',' e sem acentos: ");
		List<String> doencas = Arrays.asList(sc.nextLine().split(","));
		sistemaVacinacao.adicionarDoencas(cpf, doencas);
		
	}


	
	
	
	
	
	
	private static void alterarIdadeMinima(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.print("Nova idade minima: ");
		int novaIdadeMinima = sc.nextInt();
		sc.nextLine();
		sistemaVacinacao.setIdadeMinima(novaIdadeMinima);
	}

	
	private static void adicionarNovasDoencasQueCausamComorbidade(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.println("Informe as doenças separadas por virgula ',' e sem acentos: ");
		List<String> doencas = Arrays.asList(sc.nextLine().split(","));
		sistemaVacinacao.adicionarNovasDoencasQueCausamComorbidade(doencas);
		
	}
	

	private static void adicionarNovasProfissoesHabilitadasReceberVacina(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.println("Informe as profissões separadas por virgula ',' e sem acentos: ");
		List<String> profissoes = Arrays.asList(sc.nextLine().split(","));
		sistemaVacinacao.adicionarNovasProfissoesHabilitadasReceberVacina(profissoes);
		
	}
	
	
	private static void tomarPrimeiraDoseDaVacina(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.println("Cpf: ");
		String cpf = sc.nextLine();
		sistemaVacinacao.tomarPrimeiraDoseDaVacina(cpf);
	}
	
	
	private static void simularPassagemDeVinteDias(SistemaVacinacao sistemaVacinacao) {
		sistemaVacinacao.simularPassagemDeVinteDias();
		
	}
	
	private static void tomarSegundaDoseDaVacina(SistemaVacinacao sistemaVacinacao, Scanner sc) {
		System.out.println("Cpf: ");
		String cpf = sc.nextLine();
		sistemaVacinacao.tomarSegundaDoseDaVacina(cpf);
		
	}

}
