package br.insper.Investimento.Investimentos;

import br.insper.Investimento.Investidor.Investidor;
import br.insper.Investimento.Titulos.Titulos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestimentosRepository extends JpaRepository<Investimentos, Integer> {
    List<Investimentos> findByInvestidor(Investidor investidor);
    List<Investimentos> findByTitulo(Titulos titulo);
}
