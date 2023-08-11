package com.example.Lembretes.Controlles;

import com.example.Lembretes.Entitis.Lembrete;
import com.example.Lembretes.Services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {
    @Autowired
    private LembreteService service;

    @GetMapping
    public ResponseEntity<List<Lembrete>> buscarLembretesPorNome(@RequestParam("nome") String nome) {
        try {
            List<Lembrete> lembretes = service.buscarLembretesPorNomePessoa(nome);
            return ResponseEntity.ok(lembretes);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarLembrete(@RequestBody Lembrete lembrete) {
        try {
            Lembrete novoLembrete = service.adicionarLembrete(lembrete);
            return ResponseEntity.ok("Lembrete cadastrado com Sucesso");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLembrete(@PathVariable Long id, @RequestBody Lembrete lembrete) {
        try {
            Lembrete lembreteAtualizado = service.atualizarLembrete(id, lembrete);
            if (lembreteAtualizado != null) {
                return ResponseEntity.ok("Lembrete atualizado com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerLembrete(@PathVariable Long id) {
        try {
            boolean removido = service.removerLembrete(id);
            if (removido) {
                return ResponseEntity.ok("Lembrete deletada com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
