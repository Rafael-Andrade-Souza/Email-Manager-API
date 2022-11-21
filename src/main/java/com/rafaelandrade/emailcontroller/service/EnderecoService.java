package com.rafaelandrade.emailcontroller.service;

import com.rafaelandrade.emailcontroller.dto.EnderecoDto;
import com.rafaelandrade.emailcontroller.entity.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

	Optional<Endereco> getEnderecoById(Integer id);

	List<Endereco> getAllEnderecos();

	Endereco insertEndereco(EnderecoDto e);

}