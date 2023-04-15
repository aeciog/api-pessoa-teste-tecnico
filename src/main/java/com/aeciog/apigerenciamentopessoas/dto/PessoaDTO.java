package com.aeciog.apigerenciamentopessoas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private List<EnderecoDTO> enderecos;

    private EnderecoDTO enderecoPrincipal;

}
