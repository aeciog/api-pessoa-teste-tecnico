package com.aeciog.apigerenciamentopessoas.exception;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(Long id) {
        super("Endereço não encontrado com o id " + id);
    }

}