package br.mata62.academico;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import br.mata62.academico.ResultadoDisciplina.Natureza;

public class Universidade {
	private String nomeDaUniversidade;
	private String siglaDaUniversidade;
	private Set<Curso> cursos = new HashSet<>();
	private Set<Disciplina> disciplinas = new HashSet<>();
	private Set<Aluno> alunos = new HashSet<Aluno>();
	private Comparator<Disciplina> comparador = new Comparator<Disciplina>() {
		public boolean compareTo(Disciplina a, Disciplina b) {
			return 
			a.getCodigoDaDisciplina().compareTo(b.getCodigoDaDisciplina()) < 0 ? true :
			a.getCodigoDaDisciplina().compareTo(b.getCodigoDaDisciplina()) > 0 ? false : true;
		}

		@Override
		public int compare(Disciplina arg0, Disciplina arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};	
	
	public Set<Aluno> getAlunos() {
		return this.alunos;
	}
	
	public Universidade(String nomeDaUniversidade, String siglaDaUniversidade) {
		this.nomeDaUniversidade = nomeDaUniversidade;
		this.siglaDaUniversidade = siglaDaUniversidade;
	}
	
	public Curso getCursoByCodigo(String codigoDoCurso) {
		for(Curso curso : cursos) {
			if(curso.getCodigoDoCurso().equals(codigoDoCurso)) {
				return curso;
			}
		}
		return null;
	}
	
	public String getNomeDaUniversidade() {
		return nomeDaUniversidade;
	}

	public String getSiglaDaUniversidade() {
		return siglaDaUniversidade;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void adicionaCurso(Curso curso){
		cursos.add(curso);
	}
	
	public void adicionaAluno(Aluno aluno){
		alunos.add(aluno);
	}
	
	public Aluno getAlunoByMatricula(String matricula) {		
		for (Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {				
				return aluno;
			}
		}
		return null;
	}
	
}
