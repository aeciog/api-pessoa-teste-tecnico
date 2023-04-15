package com.aeciog.apigerenciamentopessoas.controller;

import com.aeciog.apigerenciamentopessoas.dto.EnderecoDTO;
import com.aeciog.apigerenciamentopessoas.dto.PessoaDTO;
import com.aeciog.apigerenciamentopessoas.model.Endereco;
import com.aeciog.apigerenciamentopessoas.model.Pessoa;

import com.aeciog.apigerenciamentopessoas.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        List<PessoaDTO> pessoasDTO = pessoas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pessoasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        PessoaDTO pessoaDTO = toDTO(pessoa);
        return ResponseEntity.ok(pessoaDTO);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = fromDTO(pessoaDTO);
        Pessoa pessoaCriada = pessoaService.criarPessoa(pessoa);
        PessoaDTO pessoaCriadaDTO = toDTO(pessoaCriada);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriadaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaAtualizada = fromDTO(pessoaDTO);
        Pessoa pessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        PessoaDTO pessoaDTOAtualizada = toDTO(pessoa);
        return ResponseEntity.ok(pessoaDTOAtualizada);
    }

    @PostMapping("/{id}/enderecos")
    public ResponseEntity<EnderecoDTO> criarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = fromDTO(enderecoDTO);
        Endereco enderecoCriado = pessoaService.criarEndereco(id, endereco);
        EnderecoDTO enderecoCriadoDTO = toDTO(enderecoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCriadoDTO);
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos(@PathVariable Long id) {
        List<Endereco> enderecos = pessoaService.listarEnderecos(id);
        List<EnderecoDTO> enderecosDTO = enderecos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enderecosDTO);
    }

    @PostMapping("/{idPessoa}/enderecos/{idEndereco}/principal")
    public ResponseEntity<EnderecoDTO> definirEnderecoPrincipal(@PathVariable Long idPessoa, @PathVariable Long idEndereco) {
        Endereco enderecoPrincipal = pessoaService.definirEnderecoPrincipal(idPessoa, idEndereco);
        EnderecoDTO enderecoPrincipalDTO = toDTO(enderecoPrincipal);
        return ResponseEntity.ok(enderecoPrincipalDTO);
    }


    // ------------------------------------------------------------------------
    /*

    fromDTO é responsável por converter um objeto PessoaDTO em um objeto Pessoa,
    que é usado para persistir ou atualizar uma pessoa no banco de dados.

     */

    private Pessoa fromDTO(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setEnderecoPrincipal(pessoaDTO.getEnderecoPrincipal() != null ? fromDTO(pessoaDTO.getEnderecoPrincipal()) : null);
        List<Endereco> enderecos = pessoaDTO.getEnderecos().stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
        pessoa.setEnderecos(enderecos);
        return pessoa;
    }


    /*

    O método toDTO() é responsável por fazer a conversão de um objeto Pessoa para um objeto PessoaDTO.

     */
    private PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setEnderecoPrincipal(pessoa.getEnderecoPrincipal() != null ? toDTO(pessoa.getEnderecoPrincipal()) : null);
        List<EnderecoDTO> enderecosDTO = pessoa.getEnderecos().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        pessoaDTO.setEnderecos(enderecosDTO);
        return pessoaDTO;
    }

    private Endereco fromDTO(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        return endereco;
    }

    private EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setCidade(endereco.getCidade());
        return enderecoDTO;
    }


}
