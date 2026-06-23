package br.cnj.projeto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cnj.projeto.util.CasoJudicial;

@Service
public class CasoJudicialService {

    private final CasoJudicial casoJudicial;
    private List<CasoJudicial> casos;

    public CasoJudicialService(CasoJudicial casoJudicial) {
        casos = new ArrayList<>(Arrays.asList(new CasoJudicial[]{
            new CasoJudicial(1, 'C', "Culpado safado!"), new CasoJudicial(9, 'A', "Aguardando processo!"),
            new CasoJudicial(5, 'I', "Indeferido!"), new CasoJudicial(3, 'C', "Chilindrina!")
        }));
        this.casoJudicial = casoJudicial;
    }

    public List<CasoJudicial> retornarCasos(){
        return casos;
    }

    public CasoJudicial retornarCasoPorID(int id){
        for (CasoJudicial caso : casos) 
            if (caso.getNumero() == id){
                System.out.println("Caso com ID [" + id + "] encontrado com sucesso!");
                return caso;
            }


        System.out.println("Caso com ID [" + id + "] não encontrado!");
        return null;
    }

    public void criarCaso(CasoJudicial novoCaso){
        casos.add(novoCaso);
    }
}
