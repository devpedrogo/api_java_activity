package br.cnj.projeto.main;

import br.cnj.projeto.services.CasoJudicialService;
import br.cnj.projeto.util.CasoJudicial;
import br.cnj.projeto.util.CustoJudicial;
import br.cnj.projeto.util.TaxaJudicial;

public class Main {
    public static void main(String [] args){
        // CasoJudicial caso = new CasoJudicial(new CustoJudicial(), new TaxaJudicial());

        // double custo = caso.finalizarCusto(100, "BA", 2023);

        // System.out.println(custo);

        CasoJudicialService service = new CasoJudicialService(null);

        // service.retornarCasos;
        service.retornarCasos().forEach(c -> System.out.println(c.getNumero()));
        // System.out.println(service.retornarCasos().forEach(c -> c.getNumero()));
        System.out.println("CASO: [" + service.retornarCasoPorID(3) + "]");

    }
}
