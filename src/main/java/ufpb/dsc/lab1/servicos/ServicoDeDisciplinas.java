package ufpb.dsc.lab1.servicos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import ufpb.dsc.lab1.entidades.Disciplina;
import ufpb.dsc.lab1.entidades.DisciplinaDTO;

@Service
public class ServicoDeDisciplinas {
	
	List<Disciplina> disciplinas = new ArrayList<>();
	private int id = 0;
	
	public Disciplina adicionaDisciplina(DisciplinaDTO novaDisciplina) {
		id += 1;
		Disciplina disciplina = new Disciplina(id, novaDisciplina.getNome(), novaDisciplina.getNota());
		disciplinas.add(disciplina);
		return disciplinas.get(disciplinas.size()-1);
	}
	
	public List<Disciplina> getDisciplinas(){
		return disciplinas;
	}
	
	public Disciplina getDisciplina(int id) {
		if(id <= 0 || disciplinas.isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (disciplinas.get(i).getId() == id)
				return disciplinas.get(i);
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public Disciplina setDisciplina(int id, String nome) {
		if(id <= 0 || disciplinas.isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (disciplinas.get(i).getId() == id) {
				disciplinas.get(i).setNome(nome);
				return disciplinas.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public Disciplina setDisciplina(int id, double nota) {
		if(id <= 0 || disciplinas.isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (disciplinas.get(i).getId() == id) {
				disciplinas.get(i).setNota(nota);
				return disciplinas.get(i);
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public Disciplina removeDisciplina(int id) {
		if(id <= 0 || disciplinas.isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		for (int i = 0; i < disciplinas.size(); i++) {
			if (disciplinas.get(i).getId() == id)
				return disciplinas.remove(i);
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public List<Disciplina> rankingDisciplinas(){
		disciplinas.sort(Comparator.comparingDouble(Disciplina::getNota).reversed());
		
		List<Disciplina> rankingDisciplinas = new ArrayList<>();
		rankingDisciplinas.addAll(disciplinas);
		
		disciplinas.sort(Comparator.comparingInt(Disciplina::getId));
		return rankingDisciplinas;
	}
	

}
