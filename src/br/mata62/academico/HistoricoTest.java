package br.mata62.academico;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.mata62.academico.ResultadoDisciplina.Conceito;
import br.mata62.academico.ResultadoDisciplina.Natureza;

public class HistoricoTest {
	Historico historicoAluno;
	
	@BeforeEach
	public void init() {
		 Aluno aluno = new Aluno("Lucas Evangelista","20191200","Abc1");
		 this.historicoAluno = new Historico(aluno);
	}
	
	@Test
	public void testValidateHistory() {
		TreeMap resultStudentSubject = historicoAluno.getDisciplinasCursadas();
		assertTrue(resultStudentSubject.isEmpty());
	}
	
	@Test
	public void testSetSubjects() {

		TreeMap<Integer, Set<ResultadoDisciplina>> disciplinasCursadas = new TreeMap<Integer, Set<ResultadoDisciplina>>();
		Set<ResultadoDisciplina> disciplinasSemestre = new HashSet<ResultadoDisciplina>();
		Disciplina disciplina;
		ResultadoDisciplina resultadoDisciplina;
		
		for (int i = 1; i < 11; i++) {
			for (int j = 1; i < 7; i++) {
				disciplina = new Disciplina("" + i + j, "Disc " + i + j, 48);
				resultadoDisciplina = new ResultadoDisciplina(disciplina, Conceito.Aprovado, Natureza.Obrigatoria, 5.0);
				disciplinasSemestre.add(resultadoDisciplina);
			}
			disciplinasCursadas.put(i, disciplinasSemestre);
		}
		historicoAluno.setDisciplinasCursadas(disciplinasCursadas);
		TreeMap resultStudentSubject = historicoAluno.getDisciplinasCursadas();
		
		assertTrue(resultStudentSubject.equals(disciplinasCursadas));
	}
}
