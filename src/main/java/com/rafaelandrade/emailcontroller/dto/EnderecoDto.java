package com.rafaelandrade.emailcontroller.dto;

import com.rafaelandrade.emailcontroller.entity.Endereco;
import com.sun.istack.NotNull;

public class EnderecoDto extends EnderecoUsuarioDto {

	@NotNull
	private UsuarioDto usuario;

	public Endereco toEntity() {
		Endereco endereco = new Endereco();
		endereco.setCep(getCep());
		endereco.setBairro(getBairro());
		endereco.setComplemento(getComplemento());
		endereco.setId(getId());
		endereco.setLocalidade(getLocalidade());
		endereco.setLogradouro(getLogradouro());
		endereco.setUf(getUf());
		endereco.setNumero(getNumero());
		endereco.setUsuario(this.usuario.toEntity());
		return endereco;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
}
