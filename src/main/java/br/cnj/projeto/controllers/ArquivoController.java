package br.cnj.projeto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivoController {

    @GetMapping
    public String getMethodName() {
        return "Rota de arquivos ON!";
    }
    
    
}
