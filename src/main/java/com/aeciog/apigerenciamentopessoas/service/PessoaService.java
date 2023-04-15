package com.aeciog.apigerenciamentopessoas.service;

import com.aeciog.apigerenciamentopessoas.exception.EnderecoNotFoundException;
import com.aeciog.apigerenciamentopessoas.exception.PessoaNotFoundException;
import com.aeciog.apigerenciamentopessoas.model.Endereco;
import com.aeciog.apigerenciamentopessoas.model.Pessoa;
import com.aeciog.apigerenciamentopessoas.repository.PessoaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setDataNascimento(pessoaAtualizada.getDataNascimento());
        pessoaExistente.setEnderecos(pessoaAtualizada.getEnderecos());
        pessoaExistente.setEnderecoPrincipal(pessoaAtualizada.getEnderecoPrincipal());
        return pessoaRepository.save(pessoaExistente);
    }

    public Pessoa consultarPessoa(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    public Endereco criarEndereco(Long idPessoa, Endereco endereco) {
        Pessoa pessoa = consultarPessoa(idPessoa);
        endereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(endereco);
        pessoaRepository.save(pessoa);
        return endereco;
    }

    public List<Endereco> listarEnderecos(Long idPessoa){
        Pessoa pessoa = consultarPessoa(idPessoa);
        return pessoa.getEnderecos();
    }

    public Endereco definirEnderecoPrincipal(Long idPessoa, Long idEndereco) {
        Pessoa pessoa = consultarPessoa(idPessoa);
        Endereco endereco = pessoa.getEnderecos().stream()
                .filter(e -> e.getId().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new EnderecoNotFoundException(idEndereco));
        pessoa.setEnderecoPrincipal(endereco);
        pessoaRepository.save(pessoa);
        return endereco;
    }
}