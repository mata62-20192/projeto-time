package br.mata62.academico;

import java.util.TreeSet;
import java.util.Comparator;
import java.util.TreeMap;

public class Curso {
	private String nomeDoCurso;
	private TreeMap<Integer, TreeSet<Disciplina>> disciplinasOb = new TreeMap<Integer, TreeSet<Disciplina>>();
	private TreeSet<Disciplina> disciplinasOp = new TreeSet<Disciplina>();
	
	public Curso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public TreeMap<Integer, TreeSet<Disciplina>> getDisciplinasOb() {
		return disciplinasOb;
	}

	public TreeSet<Disciplina> getDisciplinasOp() {
		return disciplinasOp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoCurso == null) ? 0 : nomeDoCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (nomeDoCurso == null) {
			if (other.nomeDoCurso != null)
				return false;
		} else if (!nomeDoCurso.equals(other.nomeDoCurso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso: " + nomeDoCurso;
	}
}
