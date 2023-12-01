package br.com.fiap.healthmate.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.healthmate.model.Usuario;
import br.com.fiap.healthmate.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("{id}")
	public Usuario buscar(@PathVariable int id) {
		return usuarioRepository.findById(id).get();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("{id}")
	public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable int id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		usuarioRepository.deleteById(codigo);
	}

}
