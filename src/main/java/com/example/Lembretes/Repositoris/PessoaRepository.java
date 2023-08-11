package com.example.Lembretes.Repositoris;

import com.example.Lembretes.Entitis.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa , Long> {
}
