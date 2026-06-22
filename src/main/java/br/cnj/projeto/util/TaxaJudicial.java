package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {
    public double adicionarTaxa(String estado){
        if("DF".equals(estado))
            return 10;

        return 20;
    }
}
