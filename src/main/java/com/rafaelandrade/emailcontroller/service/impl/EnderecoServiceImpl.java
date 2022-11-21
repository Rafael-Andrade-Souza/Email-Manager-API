package com.rafaelandrade.emailcontroller.service.impl;

import com.rafaelandrade.emailcontroller.dto.EnderecoDto;
import com.rafaelandrade.emailcontroller.exception.EnderecoNaoEncontradoException;
import com.rafaelandrade.emailcontroller.entity.Endereco;
import com.rafaelandrade.emailcontroller.repository.EnderecoRepository;
import com.rafaelandrade.emailcontroller.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private final EnderecoRepository enderecoRepository;

	public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;

	}

	@Override
	public Optional<Endereco> getEnderecoById(Integer id) throws EnderecoNaoEncontradoException {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if (!endereco.isPresent()) {
			throw new EnderecoNaoEncontradoException("Endereço não encontrado");
		}
		return endereco;
	}

	@Override
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}

	@Override
	public Endereco insertEndereco(EnderecoDto e) {
		Endereco endereco = enderecoRepository.save(e.toEntity());
		return endereco;
	}

}
