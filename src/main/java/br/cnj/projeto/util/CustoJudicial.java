package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {
    public double adicionarCusto(int ano){
        if(ano >= 2024)
            return 20;

        return 10;
    }
}
