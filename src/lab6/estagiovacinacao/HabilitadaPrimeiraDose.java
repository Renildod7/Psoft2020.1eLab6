package lab6.estagiovacinacao;

import lab6.Pessoa;

public class HabilitadaPrimeiraDose extends EstagioVacinacao {

	public void tomarPrimeiraDose(Pessoa pessoa) {
		pessoa.setEstagioVacinacao(new TomouPrimeiraDose());
		System.out.println(pessoa.toString() + " tomou a primeira dose da vacina.");
	}

}
