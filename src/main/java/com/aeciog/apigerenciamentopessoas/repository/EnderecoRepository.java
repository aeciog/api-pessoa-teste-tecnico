package com.aeciog.apigerenciamentopessoas.repository;

import com.aeciog.apigerenciamentopessoas.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository <Endereco, Long>{
}