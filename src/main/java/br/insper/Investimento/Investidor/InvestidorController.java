package br.insper.Investimento.Investidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestidorController {
    @Autowired
    private InvestidorService investidorService;

    @PostMapping("/investidor")
    public Investidor cadastrarInvestidor(@RequestBody Investidor investidor) {
        return investidorService.cadastrarInvestidor(investidor);
    }

    @DeleteMapping("/investidor")
    public void deletarInvestidor(@RequestParam(required = true) String cpf) {
        investidorService.deletarInvestidor(cpf);
    }

    @GetMapping("/investidor")
    public List<Investidor> listarInvestidores(@RequestParam(required = false) String perfil) {
        return investidorService.listarInvestidores(perfil);
    }

}
