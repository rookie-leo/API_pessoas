package br.com.api.pessoas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.pessoas.entity.DadosPessoa;

public interface DadosPessoaRepository extends JpaRepository<DadosPessoa, Long> {

	Optional<DadosPessoa> findByCpf(String cpf);
	
}
