package br.insper.Investimento.Titulos;

import jakarta.persistence.*;

@Entity
public class Titulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private String identificador;
    @Column(nullable = false)
    private String tipoTitulo;

    public Titulos() {
    }

    public Titulos(String nome, String identificador, String tipoTitulo) {
        this.nome = nome;
        this.identificador = identificador;
        this.tipoTitulo = tipoTitulo;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }
}
