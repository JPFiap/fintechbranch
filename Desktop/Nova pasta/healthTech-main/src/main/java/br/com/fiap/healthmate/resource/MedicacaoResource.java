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

import br.com.fiap.healthmate.model.Medicacao;
import br.com.fiap.healthmate.repository.MedicacaoRepository;

@RestController
@RequestMapping("medicacao")
public class MedicacaoResource {
	
	@Autowired
	private MedicacaoRepository medicacaoRepository;
	
	@GetMapping("{id}")
	public Medicacao buscar(@PathVariable int id) {
		return medicacaoRepository.findById(id).get();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Medicacao cadastrar(@RequestBody Medicacao  medicacao) {
		return medicacaoRepository.save(medicacao);
	}

	@PutMapping("{id}")
	public Medicacao atualizar(@RequestBody Medicacao medicacao, @PathVariable int id) {
		medicacao.setId(id);
		return medicacaoRepository.save(medicacao);
	}

	@DeleteMapping("{id}")
	public void remover(@PathVariable int id) {
		medicacaoRepository.deleteById(id);
	}
	

}
