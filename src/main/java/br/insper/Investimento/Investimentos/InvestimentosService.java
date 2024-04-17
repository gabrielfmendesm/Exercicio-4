package br.insper.Investimento.Investimentos;

import br.insper.Investimento.Investidor.Investidor;
import br.insper.Investimento.Investidor.InvestidorRepository;
import br.insper.Investimento.Titulos.Titulos;
import br.insper.Investimento.Titulos.TitulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentosService {
    @Autowired
    private InvestimentosRepository investimentosRepository;
    @Autowired
    private InvestidorRepository investidorRepository;
    @Autowired
    private TitulosRepository titulosRepository;

    public Investimentos cadastrarInvestimento(Investimentos investimento) {
        if (investimento.getInvestidor() == null) {
            throw new IllegalArgumentException("Investidor não pode ser vazio");
        }

        if (investimento.getTitulo() == null) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }

        Investidor investidor = investidorRepository.findByCpf(investimento.getInvestidor().getCpf());
        if (investidor == null) {
            throw new IllegalArgumentException("Investidor não encontrado");
        }

        if (investimento.getInvestidor().getPerfil().equals("CONSERVADOR") && investimento.getTitulo().getTipoTitulo().equals("Ação")) {
            throw new IllegalArgumentException("Investidor conservador não pode investir em ações");
        }

        investimento.setInvestidor(investidor);
        List<Investimentos> investimentos = investimentosRepository.findByInvestidor(investidor);

        if (investimento.getInvestidor().getPerfil().equals("MODERADO")) {
            Double valorTotal = 0.0;
            for (Investimentos i : investimentos) {
                if (i.getTitulo().getTipoTitulo().equals("Renda Fixa")) {
                    valorTotal += i.getValorInvestido();
                }
            }

            if (valorTotal > 0) {
                if (investimento.getValorInvestido() > valorTotal * 0.5) {
                    throw new IllegalArgumentException("Investidor moderado não pode investir mais de 50% do valor total em renda fixa");
                }
            }
        }

        Titulos titulo = titulosRepository.findByIdentificador(investimento.getTitulo().getIdentificador());
        if (titulo == null) {
            throw new IllegalArgumentException("Título não encontrado");
        }

        investimento.setTitulo(titulo);
        return investimentosRepository.save(investimento);
    }

    public List<Investimentos> listarInvestimentos(String cpf) {
        Investidor investidor = investidorRepository.findByCpf(cpf);
        if (investidor == null) {
            throw new IllegalArgumentException("Investidor não encontrado");
        }

        return investimentosRepository.findByInvestidor(investidor);
    }

}
