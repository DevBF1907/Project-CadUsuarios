package com.brenno.Project.CadastroUsuario.Controller;

import java.util.List;

import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import com.brenno.Project.CadastroUsuario.Entity.Usuario;
import com.brenno.Project.CadastroUsuario.Service.UsuarioService;

import jakarta.validation.Valid;

@RestController // indica que  a classe é um controlador rest 
@RequestMapping("/api/usuarios") // indica o caminho que eu consigo acessar a API
public class UsuarioController {

	private final UsuarioService usuarioService;
	
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    
    @PostMapping("/novo")
    public ResponseEntity<Usuario> criarUsuario (@Valid @RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioAtualizado ){
    	Optional<Usuario> usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
    	return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id){
    	if(usuarioService.excluirUsuario(id)) {
    		return ResponseEntity.noContent().build();
    	}
    	return ResponseEntity.notFound().build();
    }}
