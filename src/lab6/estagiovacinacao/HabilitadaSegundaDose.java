package lab6.estagiovacinacao;

import lab6.Pessoa;

public class HabilitadaSegundaDose extends EstagioVacinacao {
	
	public void tomarSegundaDose(Pessoa pessoa) {
		pessoa.setEstagioVacinacao(new VacinacaoFinalizada());
		System.out.println(pessoa.toString() + " finalizou a vacinação.");
	}

}
