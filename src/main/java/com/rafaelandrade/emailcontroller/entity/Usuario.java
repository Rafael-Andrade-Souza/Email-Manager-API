package com.rafaelandrade.emailcontroller.entity;

import com.rafaelandrade.emailcontroller.dto.UsuarioDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;

	@Column(unique=true)
	private String email;

	@OneToMany(mappedBy = "usuario")
	private List<Endereco> endereco = new ArrayList<>();
	
	public Usuario(int id, String email, List<Endereco> endereco) {
		super();
		this.id = id;
		this.email = email;
		this.endereco = endereco;
	}
	
	public UsuarioDto toDto() {
		UsuarioDto usuarioDto =  new UsuarioDto();
		usuarioDto.setEmail(this.email);
		usuarioDto.setId(this.id);
		usuarioDto.setEndereco(this.endereco.stream().map(Endereco::toDto).collect(Collectors.toList()));
		return usuarioDto;
	}

	public Usuario() {
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

	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
