package model;

/**
 *
 * @author Anderson
 */
public class ModelItemOrdemServico {

    private int id_item_ordem_servico;
    private ModelOrdemServico ordem_servico;
    private ModelProduto produto;
    private ModelServico servico;
    private int qtd_prod_utilizado;

    public ModelItemOrdemServico() {
        ordem_servico = new ModelOrdemServico();
        produto = new ModelProduto();
        servico = new ModelServico();
    }

    public int getId_item_ordem_servico() {
        return id_item_ordem_servico;
    }

    public void setId_item_ordem_servico(int id_item_ordem_servico) {
        this.id_item_ordem_servico = id_item_ordem_servico;
    }

    public ModelOrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    public void setOrdem_servico(ModelOrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }

    public ModelProduto getProduto() {
        return produto;
    }

    public void setProduto(ModelProduto produto) {
        this.produto = produto;
    }

    public ModelServico getServico() {
        return servico;
    }

    public void setServico(ModelServico servico) {
        this.servico = servico;
    }

    public int getQtd_prod_utilizado() {
        return qtd_prod_utilizado;
    }

    public void setQtd_prod_utilizado(int qtd_prod_utilizado) {
        this.qtd_prod_utilizado = qtd_prod_utilizado;
    }

}
