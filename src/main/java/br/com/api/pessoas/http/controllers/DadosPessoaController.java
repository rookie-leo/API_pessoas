package br.com.api.pessoas.http.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pessoas.entity.DadosPessoa;
import br.com.api.pessoas.http.model.DadosPessoaResponse;
import br.com.api.pessoas.repositories.DadosPessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class DadosPessoaController {

	private DadosPessoaRepository repository;
	
	public DadosPessoaController(DadosPessoaRepository repository) {
		this.repository = repository;
	}

	@GetMapping// TODO - preciso descobrir o motivo da falha
	public ResponseEntity<List<DadosPessoa>> listAll() {
		List<DadosPessoa> lista = repository.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<DadosPessoaResponse> find(@PathVariable String cpf) {
		Optional<DadosPessoa> find = repository.findByCpf(cpf);
		
		if (find.isPresent()) {
			DadosPessoaResponse response = new DadosPessoaResponse(find.get());
			
			return ResponseEntity.ok().body(response);
		}
		
		return ResponseEntity.status(404).build();
		
	}
	
}
