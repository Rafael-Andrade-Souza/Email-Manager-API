package com.rafaelandrade.emailcontroller.service;

import java.util.List;
import java.util.Optional;

import com.rafaelandrade.emailcontroller.dto.UsuarioDto;
import com.rafaelandrade.emailcontroller.entity.Usuario;

public interface UsuarioService {

	Optional<Usuario> getUsuarioById(Integer id);

	List<Usuario> getAllUsuarios();

	Usuario insertUsuario(UsuarioDto usuario);

}
