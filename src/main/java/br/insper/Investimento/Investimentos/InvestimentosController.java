package br.insper.Investimento.Investimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestimentosController {
    @Autowired
    private InvestimentosService investimentosService;

    @PostMapping("/investimentos")
    public Investimentos cadastrarInvestimento(@RequestBody Investimentos investimento) {
        return investimentosService.cadastrarInvestimento(investimento);
    }

    @GetMapping("/investimentos")
    public List<Investimentos> listarInvestimentos(@RequestParam(required = true) String cpf) {
        return investimentosService.listarInvestimentos(cpf);
    }
}
