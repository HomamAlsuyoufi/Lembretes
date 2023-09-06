package com.example.Lembretes.Entitis;

import jakarta.persistence.*;

@Entity
@Table(name = "lembrete",schema = "public")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String noticia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaId;

    public Lembrete() {};

    public Lembrete(Long id, String noticia, Pessoa pessoaId) {
        this.id = id;
        this.noticia = noticia;
        this.pessoaId = pessoaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }
}
