package br.mata62.academico;

import java.util.TreeSet;

public class Disciplina {
	private String codigoDaDisciplina;
	private String nomeDaDisciplina;
	private int cargaHoraria;
	private int semestreSugerido;
	private int numeroPreRequisitos;
	protected boolean obrigatoria;
	private TreeSet<Disciplina> preRequisito = new TreeSet<>();

	public Disciplina(String codigoDaDisciplina, String nomeDaDisciplina, int cargaHoraria) {
		this.codigoDaDisciplina = codigoDaDisciplina;
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.cargaHoraria = cargaHoraria;
	}

	public int getNumeroPreRequisitos() {
		return numeroPreRequisitos;
	}

	public void setNumeroPreRequisitos(int numeroPreRequisitos) {
		this.numeroPreRequisitos = numeroPreRequisitos;
	}

	public TreeSet<Disciplina> getPreRequisito() {
		return preRequisito;
	}

	public void setPreRequsito(Disciplina disciplina) {
		this.preRequisito.add(disciplina);
	}

	public int getSemestreSugerido() {
		return semestreSugerido;
	}

	public void setSemestreSugerido(int semestreSugerido) {
		this.semestreSugerido = semestreSugerido;
	}

	public String getCodigoDaDisciplina() {
		return codigoDaDisciplina;
	}

	public String getNomeDaDisciplina() {
		return nomeDaDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDaDisciplina == null) ? 0 : codigoDaDisciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigoDaDisciplina == null) {
			if (other.codigoDaDisciplina != null)
				return false;
		} else if (!codigoDaDisciplina.equals(other.codigoDaDisciplina))
			return false;
		return true;
	}
	
}
