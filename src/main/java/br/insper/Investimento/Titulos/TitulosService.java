package br.insper.Investimento.Titulos;

import br.insper.Investimento.Investimentos.Investimentos;
import br.insper.Investimento.Investimentos.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitulosService {
    @Autowired
    private TitulosRepository titulosRepository;
    @Autowired
    private InvestimentosRepository investimentosRepository;

    public Titulos cadastrarTitulo(Titulos titulo) {
        if (titulo.getNome() == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (titulo.getIdentificador() == null) {
            throw new IllegalArgumentException("Identificador não pode ser vazio");
        }

        if (titulo.getTipoTitulo() == null) {
            throw new IllegalArgumentException("Tipo não pode ser vazio");
        }

        if (titulo.getTipoTitulo().equals("Renda Fixa") || titulo.getTipoTitulo().equals("Ação") || titulo.getTipoTitulo().equals("Fundo de Investimento")) {
            return titulosRepository.save(titulo);
        } else {
            throw new IllegalArgumentException("Tipo de título inválido");
        }
    }

    public void deletarTitulo(Integer id) {
        Titulos titulo = titulosRepository.findTituloById(id);
        List<Investimentos> investimentos = investimentosRepository.findByTitulo(titulo);
        if (!investimentos.isEmpty()) {
            throw new IllegalArgumentException("Título possui investimentos associados");
        }

        titulosRepository.delete(titulo);
    }

    public List<Titulos> listarTitulos(String tipoTitulo) {
        if (tipoTitulo == null) {
            return titulosRepository.findAll();
        }

        return titulosRepository.findByTipoTitulo(tipoTitulo);
    }
}
