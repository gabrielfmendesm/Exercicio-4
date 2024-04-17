package br.insper.Investimento.Titulos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitulosController {
    @Autowired
    private TitulosService titulosService;

    @PostMapping("/titulos")
    public Titulos cadastrarTitulo(@RequestBody Titulos titulo) {
        return titulosService.cadastrarTitulo(titulo);
    }

    @DeleteMapping("/titulos")
    public void deletarTitulo(@RequestParam (required = true) Integer id) {
        titulosService.deletarTitulo(id);
    }

    @GetMapping("/titulos")
    public List<Titulos> listarTitulos(@RequestParam(required = false) String tipoTitulo) {
        return titulosService.listarTitulos(tipoTitulo);
    }
}
