package br.cnj.projeto.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.services.CasoJudicialService;
import br.cnj.projeto.util.CasoJudicial;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private final CasoJudicial casoJudicial;
    private final CasoJudicialService service;

    public CasoJudicialController(CasoJudicialService service, CasoJudicial casoJudicial){
        this.service = service;
        this.casoJudicial = casoJudicial;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> retornarCasosAPI(){
        List<CasoJudicial> casos = service.retornarCasos();
        return ResponseEntity.ok(casos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> retornarCasoPorId(@PathVariable int id){
        CasoJudicial caso = service.retornarCasoPorID(id);
        return ResponseEntity.ok(caso);
    }

    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial novoCaso){
        service.criarCaso(novoCaso);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(novoCaso);
    }
}
