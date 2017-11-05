package model;

import java.sql.Date;

/**
 *
 * @author Anderson
 */
public class ModelProduto {

    private String id_produto;
    private String nome_produto;
    private String descricao_produto;
    private Date validade;
    private ModelCategoria relacao_id_categoria; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELCATEGORIA
    private Double valor_produto;
    private int qtd_estoque;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETO DA ENTIDADE MODELCATEGORIA  
    public ModelProduto() {

        relacao_id_categoria = new ModelCategoria();

    }

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public ModelCategoria getRelacao_id_categoria() {
        return relacao_id_categoria;
    }

    public void setRelacao_id_categoria(ModelCategoria relacao_id_categoria) {
        this.relacao_id_categoria = relacao_id_categoria;
    }

    public Double getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(Double valor_produto) {
        this.valor_produto = valor_produto;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

}
