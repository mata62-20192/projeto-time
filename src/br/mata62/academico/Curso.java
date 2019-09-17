package br.mata62.academico;

import java.util.TreeSet;
import java.util.Scanner;

public class Curso {
	private String nomeDoCurso;
	private int quantidadeDeDisciplinas;
	private TreeSet<Disciplina> disciplinas = new TreeSet<>();

	
	public Curso(String nomeDoCurso, int quantidadeDeDisciplinas) {
		this.nomeDoCurso = nomeDoCurso;
		this.quantidadeDeDisciplinas = quantidadeDeDisciplinas;
	}

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	
	public int getQuantidadeDeDisciplinas() {
		return quantidadeDeDisciplinas;
	}

	public TreeSet<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
