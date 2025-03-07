package com.brenno.Project.CadastroUsuario.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.brenno.Project.CadastroUsuario.Entity.Usuario;
import com.brenno.Project.CadastroUsuario.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
	   
	   public Optional<Usuario> buscarPorEmail(String email) { 
	        // Método para buscar um usuário pelo e-mail
	        return usuarioRepository.findByEmail(email);
	    }
	   
	   public Optional<Usuario> buscarPorId(Long id) {
		   return usuarioRepository.findById(id);
		   }
	   
	   public boolean excluirUsuario(Long id) {
		   if(usuarioRepository.existsById(id)) {
			   usuarioRepository.deleteById(id);
			  return true;
		   }
		   return false;
	   }
	   public Optional<Usuario> atualizarUsuario(Long id, Usuario usuarioAtualizado) { 
	        // Método para atualizar um usuário existente
	        return usuarioRepository.findById(id).map(usuario -> {
	            usuario.setNome(usuarioAtualizado.getNome());
	            usuario.setEmail(usuarioAtualizado.getEmail());
	            usuario.setSenha(usuarioAtualizado.getSenha());
	            return usuarioRepository.save(usuario);
	        });
	   }
	        
	       public  boolean existePorEmail(String email) {
	            // Método para verificar se um e-mail já está cadastrado
	            return usuarioRepository.findByEmail(email).isPresent();
	        }
	        
	        public long contarUsuarios() {
	            // Método para contar a quantidade total de usuários cadastrados
	            return usuarioRepository.count();
	        }
	    }
	    

