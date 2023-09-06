package com.example.Lembretes.Testes;

import com.example.Lembretes.Entitis.Lembrete;
import com.example.Lembretes.Repositoris.LembreteRepository;
import com.example.Lembretes.Services.LembreteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LembreteTeste {
    @Autowired
    private LembreteService lembreteService;
    @MockBean
    LembreteRepository repository;

    @BeforeEach
    void insertDados(){
        Lembrete lembrete = new Lembrete();
        lembrete.setNoticia("Conteúdo do lembrete");
        Mockito.when(repository.save(Mockito.any(Lembrete.class))).thenReturn(lembrete);
    }

    @Test
    void testCadastrarLembrete(){

        Lembrete novoLembrete = new Lembrete();
        novoLembrete.setNoticia("Conteúdo do lembrete");

        Lembrete lembrete = lembreteService.adicionarLembrete(novoLembrete);
        assertEquals("Conteúdo do lembrete", lembrete.getNoticia());
    }

    @Test
    void testAtualizarLembrete() {
        Lembrete lembreteExistente = new Lembrete();
        lembreteExistente.setId(1L);
        lembreteExistente.setNoticia("Conteúdo do lembrete existente");

        String novoConteudo = "Novo conteúdo do lembrete";

        // Configurar o mock para o findById retornar o lembrete existente
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(lembreteExistente));

        Lembrete novoLembrete = new Lembrete();
        novoLembrete.setNoticia(novoConteudo);

        Lembrete lembreteAtualizado = lembreteService.atualizarLembrete(1L, novoLembrete);

        assertEquals(novoConteudo, lembreteAtualizado.getNoticia());
    }
}
