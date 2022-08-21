package br.com.mentorama.threadpoolschool.services;

import br.com.mentorama.threadpoolschool.model.Aluno;
import br.com.mentorama.threadpoolschool.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class AlunoService {

    Aluno aluno = new Aluno();

    @Autowired
    private AlunoRepository alunoRepository;

    public CompletableFuture<List<Aluno>> findAll(){
        System.out.println("Service Thread: " + Thread.currentThread().getName());
        return alunoRepository.findAllBy();
    }

    public CompletableFuture<Optional<Aluno>>  findById(Long id) {
        System.out.println("service thread: " + Thread.currentThread().getName());
        return alunoRepository.findOneById(id);

    }
    public CompletableFuture<Aluno> save(Aluno aluno){
        System.out.println("service thread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(alunoRepository.save(aluno));
    }

    public CompletableFuture<Aluno> update(Aluno aluno){
        System.out.println("service thread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(alunoRepository.save(aluno));
    }

    public CompletableFuture <Optional<Aluno>> delete(Long id) {
        System.out.println("service thread: " + Thread.currentThread().getName());
        alunoRepository.deleteById(id);
        return null;
    }
}
