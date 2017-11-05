package model;

import java.sql.Date;

/**
 *
 * @author Anderson
 */
public class ModelOrdemServico {

    private int id_ordem_Servico;
    private ModelCarro relacao_id_carro; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELCARRO
    private Date data;
    private String situacao;
    private Double valor;
    private Double desconto;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETO DA ENTIDADE MODELPRODUTO
    public ModelOrdemServico() {

        relacao_id_carro = new ModelCarro();
    }

    public int getId_ordem_Servico() {
        return id_ordem_Servico;
    }

    public void setId_ordem_Servico(int id_ordem_Servico) {
        this.id_ordem_Servico = id_ordem_Servico;
    }

    public ModelCarro getRelacao_id_carro() {
        return relacao_id_carro;
    }

    public void setRelacao_id_carro(ModelCarro relacao_id_carro) {
        this.relacao_id_carro = relacao_id_carro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

}
