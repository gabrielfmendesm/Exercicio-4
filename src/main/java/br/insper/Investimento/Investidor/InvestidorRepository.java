package br.insper.Investimento.Investidor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Integer> {
    public List<Investidor> findByPerfil(String perfil);
    public Investidor findByCpf(String cpf);
}
