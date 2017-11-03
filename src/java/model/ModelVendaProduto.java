package model;

/**
 *
 * @author Anderson
 */
public class ModelVendaProduto {

    private int id_venda_produto;
    private ModelVenda relacao_id_venda; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELVENDA
    private ModelProduto relacao_id_produto;//AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELPRODUTO
    private int quantidade;
    private String tipoPagamento;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETOS DAS ENTIDADES MODELVENDA E MODELPRODUTO
    public ModelVendaProduto() {

        relacao_id_venda = new ModelVenda();
        relacao_id_produto = new ModelProduto();

    }

    public int getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(int id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }

    public ModelVenda getRelacao_id_venda() {
        return relacao_id_venda;
    }

    public void setRelacao_id_venda(ModelVenda relacao_id_venda) {
        this.relacao_id_venda = relacao_id_venda;
    }

    public ModelProduto getRelacao_id_produto() {
        return relacao_id_produto;
    }

    public void setRelacao_id_produto(ModelProduto relacao_id_produto) {
        this.relacao_id_produto = relacao_id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
