package com.aeciog.apigerenciamentopessoas.exception;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(Long id) {
        super("Pessoa não encontrada com o id " + id);
    }

}