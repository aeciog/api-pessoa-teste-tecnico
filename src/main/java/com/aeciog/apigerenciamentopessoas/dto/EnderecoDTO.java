package com.aeciog.apigerenciamentopessoas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Long id;

    private String logradouro;

    private String cep;

    private String numero;

    private String cidade;
}

