package br.mata62.academico;

import br.mata62.academico.ResultadoDisciplina.Conceito;
import br.mata62.academico.ResultadoDisciplina.Natureza;

public class ResultadoDisciplina {
	private Disciplina disciplina;
	private Conceito conceito;
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Conceito getConceito() {
		return conceito;
	}

	public void setConceito(Conceito conceito) {
		this.conceito = conceito;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public Double getNota() {
		return nota;
	}

	public enum Conceito {
		Aprovado,
		ReprovadoPorNota, 
		ReprovadoPorFalta, 
		Dispensa,
		Trancamento		
	}
	
	public enum Natureza {
		Obrigatoria, 
		Optativa
	}
	private Natureza natureza;
	private Double nota;
	
	public void setNota(Double value) {
		this.nota = value;
	}
	
	public void setConceito(String value) {
		if(value.equals("AP")) {
			conceito = Conceito.Aprovado;
		}
		else if(value.equals("RN")) {
			conceito = Conceito.ReprovadoPorNota;
		}
		else if(value.equals("RF")) {
			conceito = Conceito.ReprovadoPorFalta;
		}
		else if(value.equals("DP")) {
			conceito = Conceito.Dispensa;
		}
		else if(value.equals("TR")) {
			conceito = Conceito.Trancamento;
		}
	}
	
	ResultadoDisciplina(Disciplina disciplina, Conceito conceito, Natureza natureza) {
		if(conceito == Conceito.Aprovado || conceito == Conceito.ReprovadoPorNota) {
			System.out.println("Informe a nota!");
			return;
		}
		this.disciplina = disciplina;
		this.conceito = conceito;
		this.natureza = natureza;
	}
	
	ResultadoDisciplina(Disciplina disciplina, Conceito conceito, Natureza natureza, double nota) {
		if(conceito == Conceito.Aprovado || conceito == Conceito.ReprovadoPorNota) {
			this.nota = nota;
		}
		else {
			System.out.println("Não existe nota para este conceito!");
			return;
		}
		this.disciplina = disciplina;
		this.conceito = conceito;
		this.natureza = natureza;
	}
}