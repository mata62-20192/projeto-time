package br.mata62.academico;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Universidade universidade = new Universidade(teclado.nextLine(),teclado.nextLine());
		int quantidadeDeCursos = teclado.nextInt();
		for (int i = 0; i < quantidadeDeCursos; i++) {
			universidade.adicionaCurso(new Curso(teclado.nextLine(), teclado.nextInt()));
		}
		int quantidadeDeDisciplinas = teclado.nextInt();
		for (int i = 0; i < quantidadeDeDisciplinas; i++) {
			universidade.adicionaDisciplina(new Disciplina(teclado.nextLine(), teclado.nextLine(), teclado.nextInt()));
		}
		for (Curso curso : universidade.getCursos()) {
			System.out.println(curso);
			String codigoDaDisciplina;
			int semestreSugerido;
			int numeroPreRequisitos;
			boolean obrigatoria;
			for (int i = 0; i < curso.getQuantidadeDeDisciplinas(); i++) {
				codigoDaDisciplina = teclado.nextLine();
				semestreSugerido = teclado.nextInt();
				numeroPreRequisitos = teclado.nextInt();
				obrigatoria = teclado.nextBoolean();
				//universidade.adicionaNoCurso(curso, codigoDaDisciplina, semestreSugerido, numeroPreRequisitos, obrigatoria);
			}
		}
	}

}
