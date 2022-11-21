package com.rafaelandrade.emailcontroller.controller;

import com.rafaelandrade.emailcontroller.dto.UsuarioDto;
import com.rafaelandrade.emailcontroller.exception.UsuarioNaoEncontradoException;
import com.rafaelandrade.emailcontroller.entity.Usuario;
import com.rafaelandrade.emailcontroller.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDto>> getAll() {
        List<Usuario> allUsuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(allUsuarios.stream().map(Usuario::toDto).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity getByEmail(@PathVariable("email") Integer id) {
        try {
            Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
            return ResponseEntity.ok(usuario.get().toDto());
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody @Valid UsuarioDto usuarioDto) {
        try {
            Usuario usuario = usuarioService.insertUsuario(usuarioDto);
            return ResponseEntity.created(URI.create(String.format("/usuarios/%s", usuario.getId()))).body(usuario.toDto());
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }
}
