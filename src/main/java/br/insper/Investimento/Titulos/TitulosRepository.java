package br.insper.Investimento.Titulos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitulosRepository extends JpaRepository<Titulos, Integer> {
    public List<Titulos> findByTipoTitulo(String tipoTitulo);
    public Titulos findByNome(String nome);
    public Titulos findByIdentificador(String identificador);
    public Titulos findTituloById(Integer id);
}
