package com.aeciog.apigerenciamentopessoas.repository;

import com.aeciog.apigerenciamentopessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
