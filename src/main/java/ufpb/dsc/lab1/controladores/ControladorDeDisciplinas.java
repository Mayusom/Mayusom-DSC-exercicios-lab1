package ufpb.dsc.lab1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.dsc.lab1.entidades.Disciplina;
import ufpb.dsc.lab1.entidades.DisciplinaDTO;
import ufpb.dsc.lab1.servicos.ServicoDeDisciplinas;

@RestController
public class ControladorDeDisciplinas {
	
	@Autowired
	private ServicoDeDisciplinas servicoDeDisciplinas;
	
	public ControladorDeDisciplinas(ServicoDeDisciplinas servicoDeDisciplinas) {
		super();
		this.servicoDeDisciplinas = servicoDeDisciplinas;
	}
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> adicionaDisciplina(@RequestBody DisciplinaDTO novaDisciplina){
		return new ResponseEntity<Disciplina>(servicoDeDisciplinas.adicionaDisciplina(novaDisciplina), HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> getDisciplinas(){
		return new ResponseEntity<List<Disciplina>>(servicoDeDisciplinas.getDisciplinas(),HttpStatus.OK);
		
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@PathVariable Integer id){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.getDisciplina(id),HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(0,null,0),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> setDisciplina(@PathVariable Integer id, @RequestParam(value = "nome") String nome){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.setDisciplina(id,nome),HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(0,null,0),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> setDisciplina(@PathVariable Integer id, @RequestParam(value = "nota") double nota){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.setDisciplina(id,nota),HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(0,null,0),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> removeDisciplina(@PathVariable Integer id){
		try {
			return new ResponseEntity<Disciplina>(servicoDeDisciplinas.removeDisciplina(id),HttpStatus.OK);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			return new ResponseEntity<Disciplina>(new Disciplina(0,null,0),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<List<Disciplina>> rankingDisciplina(){
		return new ResponseEntity<List<Disciplina>>(servicoDeDisciplinas.rankingDisciplinas(), HttpStatus.OK);
	}
	
	

}
