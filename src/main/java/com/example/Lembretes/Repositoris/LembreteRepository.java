package com.example.Lembretes.Repositoris;

import com.example.Lembretes.Entitis.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByPessoaIdNome(String nome);
}
