package br.com.mentorama.threadpoolschool.controller;

import br.com.mentorama.threadpoolschool.model.Aluno;
import br.com.mentorama.threadpoolschool.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/Aluno")
@RestController
@Async
public class AlunoController {
    @Autowired
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }


    @GetMapping
    public CompletableFuture<List<Aluno>> findAll(){
        System.out.println("controller thread: " + Thread.currentThread().getName());
        return this.alunoService.findAll();
    }


    @GetMapping("/{id}")
    public CompletableFuture<Aluno> findById(@PathVariable ("id") Long id) {
        System.out.println("controller thread: " + Thread.currentThread().getName());
        return this.alunoService.findById(id).thenApply(aluno -> { try {
            return aluno.get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        });


    }

    @PostMapping
    public CompletableFuture<Aluno> save(@RequestBody Aluno aluno){
        System.out.println("controller thread: " + Thread.currentThread().getName());
        return this.alunoService.save(aluno);
    }

    @PutMapping
    public CompletableFuture<Aluno> update(@RequestBody Aluno aluno) {
        System.out.println("controller thread: " + Thread.currentThread().getName());
        return this.alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Optional<Aluno>> delete(@PathVariable ("id") Long id) {
        System.out.println("controller thread: " + Thread.currentThread().getName());
        if (this.alunoService.findById(id).join().isPresent()){
            return this.alunoService.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        }
        }