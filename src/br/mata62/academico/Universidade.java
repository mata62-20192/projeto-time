package br.mata62.academico;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Comparator;
import java.util.TreeSet;

public class Universidade {
	private String nome;
	private String sigla;
	private TreeSet<Curso> cursos = new TreeSet<>();
	private TreeSet<Disciplina> disciplinas = new TreeSet<>();
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
	
	public Universidade(String nomeDaUniversidade, String siglaDaUniversidade) {
		this.nomeDaUniversidade = nomeDaUniversidade;
		this.siglaDaUniversidade = siglaDaUniversidade;
	}
	
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
	
	public void adiciona(Curso curso){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe número de semestres da disciplina");
		int numeroDeSemestres = teclado.nextInt();
		for (int i = 0; i < numeroDeSemestres; i++) {
			System.out.println("Informe número de disciplinas no semestre " + i+1);
			int numeroDeDisciplinas = teclado.nextInt();
			TreeSet<Disciplina> conjuntoDeOb = new TreeSet<>(comparador);
			for (int j = 0; j < numeroDeDisciplinas; j++) {
				System.out.println("Informe código da disciplina, nome da disciplina e carga horária");
				Disciplina disciplina = new Disciplina(teclado.next(), teclado.next(), teclado.nextInt());
				conjuntoDeOb.add(disciplina);
			}
			curso.getDisciplinasOb().put(i, conjuntoDeOb);
			disciplinas.addAll(conjuntoDeOb); //classcastexception
		}
		System.out.println("Informe número de disciplinas optativas");
		int numeroDeDisciplinas = teclado.nextInt();
		TreeSet<Disciplina> conjuntoDeOp = new TreeSet<Disciplina>(comparador);
		for (int i = 0; i < numeroDeDisciplinas; i++) {
			System.out.println("Informe código da disciplina, nome da disciplina e carga horária");
			Disciplina disciplina = new Disciplina(teclado.next(), teclado.next(), teclado.nextInt());
			conjuntoDeOp.add(disciplina);			
		}
		curso.getDisciplinasOp().addAll(conjuntoDeOp);
		disciplinas.addAll(conjuntoDeOp);
		cursos.add(curso);
	}
	
}
