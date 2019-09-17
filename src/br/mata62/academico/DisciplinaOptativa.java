package br.mata62.academico;

public class DisciplinaOptativa extends Disciplina{

	public DisciplinaOptativa(String codigoDaDisciplina, String nomeDaDisciplina, int cargaHoraria) {
		super(codigoDaDisciplina, nomeDaDisciplina, cargaHoraria);
		obrigatoria = false;
	}
	
}
