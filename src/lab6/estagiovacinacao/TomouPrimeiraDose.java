package lab6.estagiovacinacao;

import lab6.Pessoa;

public class TomouPrimeiraDose extends EstagioVacinacao {
	
	public void habilitarSegundaDose(Pessoa pessoa) {
		pessoa.setEstagioVacinacao(new HabilitadaSegundaDose());
		System.out.println(pessoa.toString() + " foi habilitada a tomar a segunda dose da vacina.");
	}

}
