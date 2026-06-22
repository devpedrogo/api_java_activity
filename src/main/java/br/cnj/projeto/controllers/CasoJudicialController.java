package br.cnj.projeto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.services.CasoJudicialService;
import br.cnj.projeto.util.CasoJudicial;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private final CasoJudicialService service;

    public CasoJudicialController(CasoJudicialService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> retornarCasosAPI(){
        List<CasoJudicial> casos = service.retornarCasos();
        return ResponseEntity.ok(casos);
    }
}
