package com.rafaelandrade.emailcontroller.dto;

import com.rafaelandrade.emailcontroller.entity.Usuario;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {

	private int id;

	@NotBlank
	private String email;
	private List<EnderecoUsuarioDto> endereco;

	public Usuario toEntity() {
		Usuario usuario = new Usuario();
		usuario.setEmail(this.email);
		usuario.setId(this.id);
		return usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<EnderecoUsuarioDto> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoUsuarioDto> endereco) {
		this.endereco = endereco;
	}
}
