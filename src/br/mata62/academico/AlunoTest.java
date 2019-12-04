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

public class AlunoTest {	
	
	Aluno aluno;
	
	@BeforeEach
	public void init() {
		 this.aluno = new Aluno("Lucas Evangelista","20191200","Abc1");
	}
	
	@Test
	public void testCreateStudent() {
		String expectedName = aluno.getNomeDoAluno();
		String expectedId = aluno.getMatricula();
		String expectedPassword = aluno.getSenhaDoAluno();
		Historico expectedHistory = aluno.getHistorico();
		Curso expectedCourse = aluno.getCursoDoAluno();
		
		assertTrue(expectedName.equals("Lucas Evangelista"));
		assertTrue(expectedId.equals("20191200"));
		assertTrue(expectedPassword.equals("Abc1"));
		assertNull(expectedHistory);
		assertNull(expectedCourse);
	}
	
	@Test
	public void testSetHistory() {
		Historico historicoAluno = new Historico(aluno);
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
		aluno.setHistorico(historicoAluno);
		Historico expectedHistory = aluno.getHistorico();
		
		assertNotNull(expectedHistory);
	}
	
	@Test
	public void testSetCourse() {
		String courseName = "Ciências da Computação";
		String courseId = "CC001";
		Curso cursoAluno = new Curso(courseName,courseId);
		aluno.setCursoDoAluno(cursoAluno);
		Curso expectedCourse = aluno.getCursoDoAluno();
		System.out.println(expectedCourse);
		
		assertNotNull(expectedCourse);
		assertTrue(expectedCourse.equals(cursoAluno));
		
	}
}
