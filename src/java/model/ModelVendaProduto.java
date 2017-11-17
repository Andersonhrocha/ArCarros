package model;

/**
 *
 * @author Anderson
 */
public class ModelVendaProduto {

    private int id_venda_produto;
    private ModelVenda venda;
    private ModelProduto produto;
    private int quantidade;
    private String tipoPagamento;

    public ModelVendaProduto() {
        venda = new ModelVenda();
        produto = new ModelProduto();
    }

    public int getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(int id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }

    public ModelVenda getVenda() {
        return venda;
    }

    public void setVenda(ModelVenda venda) {
        this.venda = venda;
    }

    public ModelProduto getProduto() {
        return produto;
    }

    public void setProduto(ModelProduto produto) {
        this.produto = produto;
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
