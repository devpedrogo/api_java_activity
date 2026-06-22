package br.cnj.projeto.util;

import org.springframework.stereotype.Component;

@Component
public class CasoJudicial {
    private int numero;
    private char decisao;
    private String descricao;
    private CustoJudicial custoJudicial;
    private TaxaJudicial taxaJudicial;

    public CasoJudicial() {
    }

    public CasoJudicial(CustoJudicial custoJudicial, TaxaJudicial taxaJudicial){
        this.custoJudicial = custoJudicial;
        this.taxaJudicial = taxaJudicial;
    }

    public CasoJudicial(int numero, char decisao, String descricao) {
        this.numero = numero;
        this.decisao = decisao;
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getDecisao() {
        return decisao;
    }

    public void setDecisao(char decisao) {
        this.decisao = decisao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento){
        custo += custoJudicial.adicionarCusto(anoJulgamento);
        custo += taxaJudicial.adicionarTaxa(estado);

        return custo;
    }
}
