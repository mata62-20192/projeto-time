package br.mata62.academico;

public class Aluno {
	private String nomeDoAluno;
	private String numeroDeMatricula;
	private String senha;
	private Curso cursoDoAluno;
	private Historico historico;
		
	public Aluno(String nomeDoAluno, String numeroDeMatriucla, String senha) {
		this.nomeDoAluno = nomeDoAluno;
		this.numeroDeMatricula = numeroDeMatriucla;
		this.senha = senha;
	}

	public void setHistorico(Historico value) {
		this.historico= value;
	}
	
	public Historico getHistorico() {
		return this.historico;
	}
	
	public String getNomeDoAluno() {
		return nomeDoAluno;
	}
	
	public String getMatricula() {
		return numeroDeMatricula;
	}

	public void setCursoDoAluno(Curso value) {
		this.cursoDoAluno = value;
	}

	public Curso getCursoDoAluno() {
		return this.cursoDoAluno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeMatricula == null) ? 0 : numeroDeMatricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (numeroDeMatricula == null) {
			if (other.numeroDeMatricula != null)
				return false;
		} else if (!numeroDeMatricula.equals(other.numeroDeMatricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno: " + numeroDeMatricula + nomeDoAluno;
	}
}
