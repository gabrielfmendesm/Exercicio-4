package br.insper.Investimento.Investidor;

import jakarta.persistence.*;

@Entity
public class Investidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private String perfil;
    @Column(nullable = false, unique = true)
    private String cpf;

    public Investidor() {
    }

    public Investidor(String nome, String perfil, String cpf) {
        this.nome = nome;
        this.perfil = perfil;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}