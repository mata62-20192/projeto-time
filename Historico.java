package br.mata62.academico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import br.mata62.academico.ResultadoDisciplina.Natureza;
public class Historico {
	//lista de componentes curriculares cursados por semestre, indicando código, 
	//nome, carga horária, natureza, nota e conceito (aprovado, reprovado por nota, 
	//reprovado por falta, dispensa, trancamento). 
	//Só existe nota quando o conceito é aprovado ou reprovado por nota. 
	 
	private Aluno aluno;
	private TreeMap<Integer, Set<ResultadoDisciplina>> disciplinasCursadas = new TreeMap<Integer, Set<ResultadoDisciplina>>();
	
	public Historico(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public TreeMap<Integer, Set<ResultadoDisciplina>> getDisciplinasCursadas() {
		return this.disciplinasCursadas;
	}
	
	public void Imprimir(String extensao) {
		FileWriter arquivo;
		String quebra = "\n";
		double total = 1;
		double notas = 0;
		try {
			arquivo = new FileWriter(new File("Histórico - " + aluno.getNomeDoAluno() + extensao));		
			if(extensao.equals(".html")) quebra = "<br />"; 
			arquivo.write("Nome: " + aluno.getNomeDoAluno() + quebra + "Matrícula: " + aluno.getMatricula() + quebra);
			arquivo.write("Curso: " + aluno.getCursoDoAluno().getNomeDoCurso() + quebra);
			for(Map.Entry<Integer,Set<ResultadoDisciplina>> entry : disciplinasCursadas.entrySet()) {		
				  Set<ResultadoDisciplina> resultados = entry.getValue();
				  arquivo.write(quebra + "----------------------------------------------------" + quebra);
				  arquivo.write("Semestre: " + entry.getKey() + quebra + quebra);
				  for(ResultadoDisciplina resultado : resultados) {
					  String descricaoDisciplina = "[" + resultado.getNatureza().name() + "] " + resultado.getDisciplina().getCodigoDaDisciplina() + " - " + resultado.getDisciplina().getNomeDaDisciplina();
					  String resultadoDisciplina = " : " + resultado.getConceito().name();
					  arquivo.write(descricaoDisciplina + resultadoDisciplina);
					  
					  if(resultado.getConceito().name() ==  "ReprovadoPorNota" || resultado.getConceito().name() ==  "Aprovado") {
						  notas += resultado.getNota();
						  arquivo.write(" - " + resultado.getNota());
					  }
					  arquivo.write(quebra);
					  total++;
				  }		
			}
			arquivo.write(quebra + "----------------------------------------------------" + quebra);
			total--;
			arquivo.write("CR: " + (notas/(total)));
			arquivo.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
