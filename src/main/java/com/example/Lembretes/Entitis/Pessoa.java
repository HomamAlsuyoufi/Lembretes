package com.example.Lembretes.Entitis;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa",schema = "public")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Pessoa() {};

    public Pessoa(Long id, String nome){
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
