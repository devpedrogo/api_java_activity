package br.cnj.projeto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cnj.projeto.util.CasoJudicial;

@Service
public class CasoJudicialService {

    private List<CasoJudicial> casos;

    public CasoJudicialService() {
        casos = new ArrayList<>(Arrays.asList(new CasoJudicial[]{
            new CasoJudicial(1, 'C', "Culpado safado!"), new CasoJudicial(9, 'A', "Aguardando processo!"),
            new CasoJudicial(5, 'I', "Indeferido!"), new CasoJudicial(3, 'C', "Chilindrina!")
        }));
    }

    public List<CasoJudicial> retornarCasos(){
        return casos;
    }
}
