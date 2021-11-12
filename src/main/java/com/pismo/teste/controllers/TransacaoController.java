package com.pismo.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.teste.dto.TransacaoDto;
import com.pismo.teste.model.Transacao;
import com.pismo.teste.repository.TransacaoRepository;
import com.pismo.teste.service.TransacaoService;


@RestController
@RequestMapping(value="/transacao")
public class TransacaoController{
	
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private TransacaoService transacaoService;
	
	// Metodo para listar todas as contas existentes
	@GetMapping
	public List<Transacao> getAllTransacoes() {
		return transacaoRepository.findAll();
	}
	
	// Metodo para criar um transacao
	@PostMapping
	public Transacao salvar(@RequestBody TransacaoDto transacao) throws Exception{
		return transacaoService.create(transacao);
	}
	
	
}
