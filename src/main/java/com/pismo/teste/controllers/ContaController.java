package com.pismo.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.teste.model.Conta;
import com.pismo.teste.repository.ContaRepository;


@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	// Metodo para listar todas as contas existentes
	@GetMapping
	public List<Conta> getAllContas() {
		return contaRepository.findAll();
	}

	// Metodo para criar um nova conta
	@PostMapping
	public Conta salvar(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

	@GetMapping("/{id}")
	// Metodo para buscar pelo id da conta
	public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
		return contaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// Metodo para deletar pelo id alguma conta
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConta(@PathVariable long id) {
		return contaRepository.findById(id).map(record -> {
			contaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
