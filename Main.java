package br.mata62.academico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Adicione universidade");
		Universidade universidade = new Universidade(teclado.nextLine(),teclado.nextLine());
		
		// pass the path to the file as a parameter 
	    File file = new File("C:\\Users\\nicho\\Documents\\dados.txt"); 
	    /*Scanner sc;
		try {
			sc = new Scanner(file);
			 while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine()); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	    BufferedReader br = new BufferedReader(new FileReader(file)); 
	    
	    
	    
	    String st; 
	    st = br.readLine();
	    while ((st = br.readLine()) != null) {
	      String nomeDoCurso = st;	
	      st = br.readLine();
	      String codigoDoCurso = st;
	      
	      Curso curso = new Curso(nomeDoCurso, codigoDoCurso);
	      
	      st = br.readLine();
	      Set<Disciplina> disciplinasSemestre = new HashSet<Disciplina>();
	      Integer semestreAnterior = 1;
	      Integer numeroDisciplinas = Integer.parseInt(st); 
	      for(int i=0; i< numeroDisciplinas; i++) {
	    	  st = br.readLine();
	    	  String nomeDaDisciplina = st;
	    	  st = br.readLine();
	    	  String array[] = new String[5];
	    	  array = st.split(" ");
	    	  String codigoDaDisciplina = array[0];
	    	  Integer semestre = Integer.parseInt(array[1]);
	    	  String natureza = array[2];
	    	  Integer cargaHoraria = Integer.parseInt(array[3]);
	    	  Disciplina disciplina = new Disciplina(codigoDaDisciplina, nomeDaDisciplina, cargaHoraria);
	    	  if(natureza.equals("OB") && semestre == semestreAnterior) {
	    		  disciplinasSemestre.add(disciplina);
	    	  }
	    	  else if (natureza.equals("OB") && semestre != semestreAnterior) {
	    		  curso.getDisciplinasOb().put(semestreAnterior, disciplinasSemestre);
	    		  disciplinasSemestre = new HashSet<Disciplina>();
	    		  disciplinasSemestre.add(disciplina);
	    		  semestreAnterior = semestre;
	    	  }	    	
	    	  else if(natureza.equals("OP") && semestre != semestreAnterior) {
	    		  curso.getDisciplinasOb().put(semestreAnterior, disciplinasSemestre);	    		  
	    		  curso.getDisciplinasOp().add(disciplina);
	    		  semestreAnterior = semestre;
	    	  }
	    	  else if(natureza.equals("OP") && semestre == semestreAnterior) {
	    		  curso.getDisciplinasOp().add(disciplina);
	    	  }
	    	}
	      universidade.adicionaCurso(curso);
	      }
	    System.out.println("Quantos alunos deseja adicionar na universidade?");
	    Integer qtdAlunos = Integer.parseInt(teclado.nextLine());
	    for(int k = 1; k<=qtdAlunos; k++) {
	    	System.out.println("Adicione aluno (nome, número de matrícula e senha)");
	    	Aluno aluno = new Aluno(teclado.nextLine(),teclado.nextLine(), teclado.nextLine());
			System.out.println("Adicione o curso para o aluno ");
			String codigoDoCurso = teclado.nextLine();
			Curso cursoAluno = universidade.getCursoByCodigo(codigoDoCurso);
			aluno.setCursoDoAluno(cursoAluno);
			System.out.println("Informe a quantidade de semestres cursados pelo aluno");
			Integer semestres = Integer.parseInt(teclado.nextLine());
			Historico historicoAluno = new Historico(aluno);
			for(int i =1; i<=semestres; i++) {
				System.out.println("Informe a quantidade de disciplinas cursadas no semestre " + i);
				Integer qtddisciplinas = Integer.parseInt(teclado.nextLine());
				Set<ResultadoDisciplina> resultadosSemestre = new HashSet<ResultadoDisciplina>();
				for(int j=1; j<=qtddisciplinas; j++) {	
					System.out.println("Adicione disciplina cursada pelo aluno (codigo e conceito [AP, RN, RF, TR, DP])");
					String codigoDaDisciplina = teclado.nextLine();				
					String conceito = teclado.nextLine();
					Double nota;
					ResultadoDisciplina resultado = aluno.getCursoDoAluno().getDisciplinaByCodigo(codigoDaDisciplina);
					if(conceito.equals("AP") || conceito.equals("RN")) {
						System.out.println("Informe a nota");
						nota = Double.parseDouble(teclado.nextLine());
						resultado.setNota(nota);			
					}
					resultado.setConceito(conceito);
					resultadosSemestre.add(resultado);
				}
				historicoAluno.getDisciplinasCursadas().put(i, resultadosSemestre);			
			}
			aluno.setHistorico(historicoAluno);
			universidade.adicionaAluno(aluno);
	    }	  
	    String resposta;
	    System.out.println("Deseja imprimir historico? (S/N)");
	    resposta = teclado.nextLine();
	    while (resposta.equals("S")) {
	    	System.out.println("Informe o número de matrícula do aluno");
	    	String matricula = teclado.nextLine();
	    	Aluno aluno = universidade.getAlunoByMatricula(matricula);
	    	System.out.println("Digite 1 para imprimir em txt e 2 para imprimir em html");
	    	if(teclado.nextLine().equals("1")) {
	    		aluno.getHistorico().Imprimir(".txt");
	    	}
	    	else {
	    		aluno.getHistorico().Imprimir(".html");
	    	}
	    	System.out.println("Deseja imprimir um novo historico? (S/N)");
		    resposta = teclado.nextLine();
	    }
	    System.out.println("Deseja imprimir currículo? (S/N)");
	    resposta = teclado.nextLine();
	    while (resposta.equals("S")) {
	    	System.out.println("Informe o código do curso");
	    	universidade.getCursoByCodigo(teclado.nextLine()).imprimirCurriculo();
		    System.out.println("Deseja imprimir um novo currículo? (S/N)");
		    resposta = teclado.nextLine();
	    }
	}
}


