package com.rafaelandrade.emailcontroller.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.rafaelandrade.emailcontroller.exception.EnderecoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelandrade.emailcontroller.dto.EnderecoDto;
import com.rafaelandrade.emailcontroller.dto.EnderecoUsuarioDto;
import com.rafaelandrade.emailcontroller.entity.Endereco;
import com.rafaelandrade.emailcontroller.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	private final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnderecoUsuarioDto>> getAll() {
		List<Endereco> enderecos = enderecoService.getAllEnderecos();
		return ResponseEntity.ok(enderecos.stream().map(Endereco::toDto).collect(Collectors.toList()));
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public ResponseEntity getByEmail(@PathVariable("email") Integer id) {
		try 
		{
			Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
			return ResponseEntity.ok(endereco.get().toDto());
		} catch (EnderecoNaoEncontradoException ex)
		{
			return ResponseEntity.status(404).body(ex.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody @Valid EnderecoDto e) {
		try 
		{
			Endereco endereco = enderecoService.insertEndereco(e);
			return ResponseEntity.created(URI.create(String.format("/enderecos/%s", endereco.getId())))
					.body(endereco.toDto());
		} catch (Exception ex) 
		{
			return ResponseEntity.status(400).body(ex.getMessage());
		}
	}
}
