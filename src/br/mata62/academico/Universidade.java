package br.mata62.academico;


import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Universidade {
	private String nomeDaUniversidade;
	private String siglaDaUniversidade;
	private TreeSet<Curso> cursos = new TreeSet<>();
	private TreeSet<Disciplina> disciplinas = new TreeSet<>();
	
	public Universidade(String nomeDaUniversidade, String siglaDaUniversidade) {
		this.nomeDaUniversidade = nomeDaUniversidade;
		this.siglaDaUniversidade = siglaDaUniversidade;
	}
	
	public void adicionaDisciplina(Disciplina disciplina) {
		for (Disciplina i : disciplinas) {
			if(i.getCodigoDaDisciplina().equals(disciplina.getCodigoDaDisciplina())) {
				System.out.println("Universidade já contém disciplina\n");
				return;
			}
		}
		disciplinas.add(disciplina);
	}
	
	public void adicionaCurso(Curso curso) {
		for (Curso i: cursos) {
			if (i.getNomeDoCurso().equals(curso.getNomeDoCurso())) {
				System.out.println("Universidade já contém curso\n");
				return;
			}
		}
		cursos.add(curso);
	}
	
//	public void adicionaNoCurso(Curso nomeDoCurso, String codigoDaDisciplina, int semestreSugerido, int numeroPreRequisitos, boolean obrigatoria) {
//		try {
//			for (Disciplina disciplina: disciplinas) {
//				if(disciplina.getCodigoDaDisciplina().equals(codigoDaDisciplina)) {
//					disciplina.setSemestreSugerido(semestreSugerido);
//					disciplina.setNumeroPreRequisitos(numeroPreRequisitos);
//					if (obrigatoria) {
//						nomeDoCurso.getDisciplinas().add(disciplina);
//						adicionaPreRequisito(nomeDoCurso, disciplina, nomeDoCurso.getDisciplinas());
//					}
//					else {
//						nomeDoCurso.getDisciplinas().add(disciplina);
//						adicionaPreRequisito(nomeDoCurso, disciplina, nomeDoCurso.getDisciplinas()));
//						
//					}
//					
//					break;
//				}
//			}
//		}catch(NullPointerException e) {
//			System.out.println("Sem dados cadastrados");
//		}
		
		//implementar metodo
//	}
	
//	public void adicionaPreRequisito(Curso curso, Disciplina disciplina) {
//		try {
//			Scanner teclado = new Scanner(System.in);
//			for (int i = 0; i < disciplina.getNumeroPreRequisitos(); i++) {
//				String codigoPreRequisito = teclado.nextLine();
//				for (Disciplina j : disciplinas) {
//					if (j.getCodigoDaDisciplina().equalsIgnoreCase(codigoPreRequisito)) {
//						disciplina.getPreRequisito().add(j);
//					}
//				}
//			}
//		}catch(NullPointerException e){
//			System.out.println("Sem disciplinas cadastradas");
//		}
//			
//	}
	
//	public void adicionaPreRequisito(Curso curso, Disciplina disciplinaRequisitada, TreeSet<Disciplina> disciplinasPreRequisitos) {
//		Scanner teclado = new Scanner(System.in);
//		for (int i = 0; i < disciplinaRequisitada.getNumeroPreRequisitos(); i++) {
//			String codigoPreRequisito = teclado.nextLine();
//			for (Disciplina disciplina : disciplinasPreRequisitos) {
//				if (disciplina.getCodigoDaDisciplina().equals(codigoPreRequisito)){
//					disciplinaRequisitada.getPreRequisito().add(disciplina);
//				}
//			}
//		}
		//implementar metodo;
//	}

	public String getNomeDaUniversidade() {
		return nomeDaUniversidade;
	}

	public String getSiglaDaUniversidade() {
		return siglaDaUniversidade;
	}

	public TreeSet<Curso> getCursos() {
		return cursos;
	}

	public TreeSet<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	
}
