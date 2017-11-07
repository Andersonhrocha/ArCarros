package model;

/**
 *
 * @author Anderson
 */
public class ModelItemOrdemServico {

    private int id_item_ordem_servico;
    private ModelOrdemServico relacao_id_ordem_servico;//AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELPRDEMSERVICO
    private ModelProduto relacao_id_produto;//AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELPRODUTO
    private ModelServico relacao_id_servico;//AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELSERVICO
    private int qtd_prod_utilizado;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETOS DAS ENTIDADES MODELORDEMSERVICO, MODELPRODUTO E MODELSERVICO  
    public ModelItemOrdemServico() {
        relacao_id_ordem_servico = new ModelOrdemServico();
        relacao_id_produto = new ModelProduto();
        relacao_id_servico = new ModelServico();
    }

    public int getId_item_ordem_servico() {
        return id_item_ordem_servico;
    }

    public void setId_item_ordem_servico(int id_item_ordem_servico) {
        this.id_item_ordem_servico = id_item_ordem_servico;
    }

    public ModelOrdemServico getRelacao_id_ordem_servico() {
        return relacao_id_ordem_servico;
    }

    public void setRelacao_id_ordem_servico(ModelOrdemServico relacao_id_ordem_servico) {
        this.relacao_id_ordem_servico = relacao_id_ordem_servico;
    }

    public ModelProduto getRelacao_id_produto() {
        return relacao_id_produto;
    }

    public void setRelacao_id_produto(ModelProduto relacao_id_produto) {
        this.relacao_id_produto = relacao_id_produto;
    }

    public ModelServico getRelacao_id_servico() {
        return relacao_id_servico;
    }

    public void setRelacao_id_servico(ModelServico relacao_id_servico) {
        this.relacao_id_servico = relacao_id_servico;
    }

    public int getQtd_prod_utilizado() {
        return qtd_prod_utilizado;
    }

    public void setQtd_prod_utilizado(int qtd_prod_utilizado) {
        this.qtd_prod_utilizado = qtd_prod_utilizado;
    }
}
