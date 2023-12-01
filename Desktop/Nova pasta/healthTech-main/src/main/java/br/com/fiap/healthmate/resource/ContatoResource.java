package br.com.fiap.healthmate.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.healthmate.model.Contato;
import br.com.fiap.healthmate.repository.ContatoRepository;

@RestController
@RequestMapping("contato")
public class ContatoResource {

	@Autowired
	private ContatoRepository contatoRepository;

	@GetMapping("{id}")
	public Contato buscar(@PathVariable int id) {
		return contatoRepository.findById(id).get();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Contato cadastrar(@RequestBody Contato  contato) {
		return contatoRepository.save(contato);
	}

	@PutMapping("{id}")
	public Contato atualizar(@RequestBody Contato contato, @PathVariable int id) {
		contato.setId(id);
		return contatoRepository.save(contato);
	}

	@DeleteMapping("{id}")
	public void remover(@PathVariable int id) {
		contatoRepository.deleteById(id);
	}
	
}

	
	

