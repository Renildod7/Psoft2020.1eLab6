package lab6.estagiovacinacao;

import java.util.List;

import lab6.Pessoa;

public class NaoHabilitada extends EstagioVacinacao {
	
	public void verificaHabilitacao(int idadeMinima, List<String> comorbidades, List<String> profissoesHabilitadas, Pessoa pessoa) {
		boolean possuiIdadeMinima = pessoa.getIdade() >= idadeMinima;
		
		
		List<String> doencasPessoa = pessoa.getDoencas();
		boolean possuiComorbidades = false;
		for (int i = 0; i < doencasPessoa.size() && !possuiComorbidades; i++) {
			if(comorbidades.contains(doencasPessoa.get(i))) {
				possuiComorbidades = true;
			}
		}
	
		boolean profissaoHabilitada = profissoesHabilitadas.contains(pessoa.getProfissao());
		
		if(possuiIdadeMinima || possuiComorbidades || profissaoHabilitada) {
			pessoa.setEstagioVacinacao(new HabilitadaPrimeiraDose());
			System.out.println(pessoa.toString() + " foi habilitada a tomar a primeira dose da vacina.");
		}
	}
}
