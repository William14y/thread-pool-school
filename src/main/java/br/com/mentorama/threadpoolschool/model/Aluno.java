package br.com.mentorama.threadpoolschool.model;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    private Long id;

    @Column
    private String nome;

    @Column
    private Integer idade;

    public Aluno(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno (){}

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}