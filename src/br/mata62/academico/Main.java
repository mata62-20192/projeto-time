package br.mata62.academico;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Adicione universidade");
		Universidade universidade = new Universidade(teclado.nextLine(),teclado.nextLine());
		System.out.println("Informe a quantidade de cursos");
		int quantidadeDeCursos = teclado.nextInt();
		for (int i = 0; i < quantidadeDeCursos; i++) {
			System.out.println("Nome do curso");
			Curso curso = new Curso(teclado.next());
			universidade.adiciona(curso);
		}
		for (Curso curso : universidade.getCursos()) {
			System.out.println(curso);
			System.out.println("Disciplinas obrigatórias");
			for (int i = 0; i < curso.getDisciplinasOb().size(); i++) {
				System.out.println("Semestre " + i+1);
				System.out.println(curso.getDisciplinasOb().get(i));
			}
			System.out.println("Disciplinas optativas");
			for (Disciplina disciplina : curso.getDisciplinasOp()) {
				System.out.println(disciplina);
			}
		}
	}

}
