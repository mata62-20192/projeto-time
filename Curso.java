package br.mata62.academico;
import br.mata62.academico.ResultadoDisciplina.Natureza;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Curso {
	private String nomeDoCurso;
	private String codigoDoCurso;
	private TreeMap<Integer, Set<Disciplina>> disciplinasOb = new TreeMap<Integer, Set<Disciplina>>();
	private Set<Disciplina> disciplinasOp = new HashSet<Disciplina>();
	
	public Curso(String nomeDoCurso, String codigoDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
		this.codigoDoCurso = codigoDoCurso;
	}
	
	public void imprimirCurriculo() {
		FileWriter arquivo;
		String quebra = "\n";
		try {
			arquivo = new FileWriter(new File("Curriculo - " + getNomeDoCurso() + ".txt"));		
						
			arquivo.write("Curso: " + getNomeDoCurso() + quebra);
			arquivo.write("Obrigatórias:" + quebra);
			for(Map.Entry<Integer,Set<Disciplina>> entry : disciplinasOb.entrySet()) {		
				  Set<Disciplina> disciplinasObg = entry.getValue();				  
				  arquivo.write("Semestre: " + entry.getKey() + quebra + quebra);
				  for(Disciplina disciplina : disciplinasObg) {
					 String descricao = disciplina.getCodigoDaDisciplina() + " - " + disciplina.getNomeDaDisciplina() + "(" + disciplina.getCargaHoraria() + "h)" + quebra;
					 arquivo.write(descricao);					 
				  }
				  arquivo.write(quebra + "----------------------------------------------------" + quebra);
			}
			arquivo.write("Optativas:" + quebra);
			for(Disciplina disciplina : disciplinasOp) {
				 String descricao = disciplina.getCodigoDaDisciplina() + " - " + disciplina.getNomeDaDisciplina() + "(" + disciplina.getCargaHoraria() + "h)" + quebra;
				 arquivo.write(descricao);				 
			  }		
			arquivo.write(quebra + "----------------------------------------------------" + quebra);
		
			arquivo.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultadoDisciplina getDisciplinaByCodigo(String codigo) {
		for(Map.Entry<Integer,Set<Disciplina>> entry : disciplinasOb.entrySet()) {		
			  Set<Disciplina> disciplinas = entry.getValue();
			  for(Disciplina disciplina : disciplinas) {
				  if(disciplina.getCodigoDaDisciplina().equals(codigo)) {
						ResultadoDisciplina resultado = new ResultadoDisciplina(disciplina, null, Natureza.Obrigatoria);
						return resultado;
					}
			  }			  
			}
		for (Disciplina disciplina : disciplinasOp) {
			if(disciplina.getCodigoDaDisciplina().equals(codigo)) {
				ResultadoDisciplina resultado = new ResultadoDisciplina(disciplina, null, Natureza.Optativa);
				return resultado;
			}
		}
		return null;
	}
	
	public String getCodigoDoCurso() { 
		return codigoDoCurso;
	}
	
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public TreeMap<Integer, Set<Disciplina>> getDisciplinasOb() {
		return disciplinasOb;
	}

	public Set<Disciplina> getDisciplinasOp() {
		return disciplinasOp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoCurso == null) ? 0 : nomeDoCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (nomeDoCurso == null) {
			if (other.nomeDoCurso != null)
				return false;
		} else if (!nomeDoCurso.equals(other.nomeDoCurso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso: " + nomeDoCurso;
	}
}
