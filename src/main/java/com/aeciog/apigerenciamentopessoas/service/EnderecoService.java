package com.aeciog.apigerenciamentopessoas.service;

import com.aeciog.apigerenciamentopessoas.exception.EnderecoNotFoundException;
import com.aeciog.apigerenciamentopessoas.model.Endereco;
import com.aeciog.apigerenciamentopessoas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco consultarEndereco(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException(id));
    }
}
