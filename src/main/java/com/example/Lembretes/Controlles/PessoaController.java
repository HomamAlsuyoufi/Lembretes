package com.example.Lembretes.Controlles;

import java.util.List;

import com.example.Lembretes.Entitis.Pessoa;
import com.example.Lembretes.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarPessoa(@RequestBody Pessoa pessoa) {
        try {
            Pessoa novoPessoa = service.adicionarPessoa(pessoa);
            return ResponseEntity.ok("Pessoa cadastrado com Sucesso");        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarpessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        try {
            Pessoa pessoaAtualizado = service.atualizarPessoa(id, pessoa);
            if (pessoaAtualizado != null) {
                return ResponseEntity.ok("Pessoa atualizado com Sucesso");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPessoa(@PathVariable Long id) {
        try {
            service.removerPessoa(id);
            return ResponseEntity.ok("Pessoa deletado com sucesso");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
