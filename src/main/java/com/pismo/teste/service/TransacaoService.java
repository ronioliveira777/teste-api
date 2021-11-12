package com.pismo.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.teste.dto.TransacaoDto;
import com.pismo.teste.model.Conta;
import com.pismo.teste.model.Transacao;
import com.pismo.teste.repository.ContaRepository;
import com.pismo.teste.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Transacao create(TransacaoDto request) throws Exception {
		
		Conta conta = contaRepository.findById(request.getConta_id()).get();
			
        Transacao transacao = new Transacao(request.getQuantia(), request.getTipoOperacao(), request.getDataRegistro(), conta);
		        
		return transacaoRepository.save(transacao);

	}
	
}
