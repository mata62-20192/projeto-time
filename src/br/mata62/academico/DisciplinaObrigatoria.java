package br.mata62.academico;

public class DisciplinaObrigatoria extends Disciplina{

	public DisciplinaObrigatoria(String codigoDaDisciplina, String nomeDaDisciplina, int cargaHoraria) {
		super(codigoDaDisciplina, nomeDaDisciplina, cargaHoraria);
		obrigatoria = true;
	}

}
