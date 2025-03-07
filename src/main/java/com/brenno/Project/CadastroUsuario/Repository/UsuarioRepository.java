package com.brenno.Project.CadastroUsuario.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.brenno.Project.CadastroUsuario.Entity.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	Optional<Usuario> findByEmail(String email);

}
