package com.example.Lembretes.Services;

import com.example.Lembretes.Entitis.Pessoa;
import com.example.Lembretes.Repositoris.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa adicionarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoa){
        if(repository.existsById(id)){
            pessoa.setId(id);
            return repository.save(pessoa);
        }
        return null;
    }

    public void removerPessoa(Long id) {
        repository.deleteById(id);
    }
}
