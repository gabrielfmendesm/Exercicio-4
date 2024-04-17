package br.insper.Investimento.Investidor;

import br.insper.Investimento.Investimentos.Investimentos;
import br.insper.Investimento.Investimentos.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {
    @Autowired
    private InvestidorRepository investidorRepository;
    @Autowired
    private InvestimentosRepository investimentosReposito;

    public Investidor cadastrarInvestidor(Investidor investidor) {
        if (investidor.getNome() == null || investidor.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do investidor não pode ser vazio");
        }

        if (investidor.getCpf() == null || investidor.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF do investidor não pode ser vazio");
        }

        if (investidor.getPerfil() == null) {
            throw new IllegalArgumentException("Perfil do investidor não pode ser vazio");
        }

        if (!investidor.getPerfil().equals("CONSERVADOR") &&
                !investidor.getPerfil().equals("MODERADO") &&
                !investidor.getPerfil().equals("ARROJADO")) {
            throw new IllegalArgumentException("Perfil do investidor inválido");
        }

        return investidorRepository.save(investidor);
    }

    public void deletarInvestidor(String cpf) {
        Investidor investidor = investidorRepository.findByCpf(cpf);
        List<Investimentos> investimentos = investimentosReposito.findByInvestidor(investidor);

        if (investidor == null) {
            throw new IllegalArgumentException("Investidor não encontrado");
        }

        if (investimentos.size() > 0) {
            throw new IllegalArgumentException("Investidor possui investimentos cadastrados");
        }

        investidorRepository.delete(investidor);
    }

    public List<Investidor> listarInvestidores(String perfil) {
        if (perfil == null) {
            return investidorRepository.findAll();
        }

        return investidorRepository.findByPerfil(perfil);
    }
}
