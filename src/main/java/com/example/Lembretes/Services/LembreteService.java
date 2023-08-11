    package com.example.Lembretes.Services;

import com.example.Lembretes.Entitis.Lembrete;
import com.example.Lembretes.Repositoris.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository repository;

    public List<Lembrete> buscarLembretesPorNomePessoa(String nome) {
        return repository.findByPessoaIdNome(nome);
    }

    public Lembrete adicionarLembrete(Lembrete lembrete) {
        return repository.save(lembrete);
    }

    public Lembrete atualizarLembrete(Long id, Lembrete lembrete) {
        if (repository.existsById(id)) {
            lembrete.setId(id);
            return repository.save(lembrete);
        }
        return null;
    }

    public boolean removerLembrete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}