package br.com.fiap.healthmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.healthmate.model.Medicacao;

@Repository
public interface MedicacaoRepository extends JpaRepository<Medicacao, Integer> {

	List<Medicacao> findByNome(String medicacao);

}
