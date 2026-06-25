package br.cnj.projeto.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cnj.projeto.util.CasoJudicial;
import tools.jackson.databind.ObjectMapper;

@Service
public class CasoJudicialService {

    private final CasoJudicial casoJudicial;
    private List<CasoJudicial> casos;
    
    @Autowired
    private ObjectMapper objectMapper;

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

    public void atualizarCaso(int id, CasoJudicial casoAtualizado){
        for (int i = 0; i < casos.size(); i++){
            if(casos.get(i).getNumero() == casoAtualizado.getNumero()){
                casos.set(i, casoAtualizado);
                break;
            }
        }
    }

    public CasoJudicial atualizarCaso(int id, Map<String, Object> campos) {
    
        CasoJudicial caso = this.retornarCasoPorID(id);

        if (caso == null) {
            return null;
        }

        try {
            objectMapper.updateValue(caso, campos);
        } catch (Exception e) {
            System.out.println("Erro ao mapear os campos: " + e.getMessage());
            return null;
        }
        
        return caso;
    }

    public void deletarCaso(int id){
        casos.remove(this.retornarCasoPorID(id));
    }
}
