package br.com.fiap.healthmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.healthmate.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	List<Contato> findByNome(String contato);



}
