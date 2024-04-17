package br.insper.Investimento.Investimentos;

import br.insper.Investimento.Investidor.Investidor;
import br.insper.Investimento.Titulos.Titulos;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Investimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_investidor")
    private Investidor investidor;

    @ManyToOne
    @JoinColumn(name = "id_titulo")
    private Titulos titulo;
    private Double valorInvestido;
    private LocalDateTime dataInvestimento;

    public Investimentos() {
    }

    public Investimentos(Investidor investidor, Titulos titulo, Double valorInvestido) {
        this.investidor = investidor;
        this.titulo = titulo;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulos titulo) {
        this.titulo = titulo;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public LocalDateTime getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(LocalDateTime dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }
}