package br.com.mentorama.threadpoolschool.repositories;

import br.com.mentorama.threadpoolschool.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@Async ("customThreadPool")
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    CompletableFuture <Optional<Aluno>>findOneById(Long id);

    CompletableFuture<List<Aluno>> findAllBy();

}
