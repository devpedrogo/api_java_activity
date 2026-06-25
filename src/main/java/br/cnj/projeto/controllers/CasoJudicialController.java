package br.cnj.projeto.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.services.CasoJudicialService;
import br.cnj.projeto.util.CasoJudicial;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PutMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable int id, @RequestBody CasoJudicial casoAtualizado) {
        service.atualizarCaso(id, casoAtualizado);
        return ResponseEntity.ok(casoAtualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable int id, @RequestBody Map<String, Object> campos) {
        
        CasoJudicial casoAtualizado = service.atualizarCaso(id, campos);
        
        if (casoAtualizado != null) {
            return ResponseEntity.ok(casoAtualizado); 
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CasoJudicial> deletarCaso(@PathVariable int id){
        service.deletarCaso(id);
        return ResponseEntity.noContent().build();
        //testando esse commit
    }

}
