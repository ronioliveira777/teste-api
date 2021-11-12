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

		if (request == null)
			throw new Exception("Favor informar os dados necessários para uma nova Transação");

		Boolean consultaConta = contaRepository.existsById(request.getConta_id());

		if (!consultaConta) {
			throw new Exception("Favor informar os dados necessários para uma nova Transação");
		}

		Conta conta = contaRepository.findById(request.getConta_id()).get();

		if (request.getTipoOperacao() == 1) {

			Transacao transacao = new Transacao(-request.getQuantia(), request.getTipoOperacao(),
					request.getDataRegistro(), conta);

			return transacaoRepository.save(transacao);

		} else if (request.getTipoOperacao() == 2) {
			Transacao transacao = new Transacao(-request.getQuantia(), request.getTipoOperacao(),
					request.getDataRegistro(), conta);

			return transacaoRepository.save(transacao);

		} else if (request.getTipoOperacao() == 3) {
			Transacao transacao = new Transacao(-request.getQuantia(), request.getTipoOperacao(),
					request.getDataRegistro(), conta);

			return transacaoRepository.save(transacao);

		} else if (request.getQuantia() >= 0 && request.getTipoOperacao() == 4) {

			Transacao transacao = new Transacao(request.getQuantia(), request.getTipoOperacao(),
					request.getDataRegistro(), conta);

			return transacaoRepository.save(transacao);
		} else
			throw new Exception("O valor ou tipo de operação informado não é válido!");

	}

}
