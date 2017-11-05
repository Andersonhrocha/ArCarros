package model;

/**
 *
 * @author Anderson
 */
public class ModelServico {

    private int id_servico;
    private String nome_servico;
    private String descricao;
    private Double valor_servico;

    //CONSTRUTOR PRINCIPAL 
    public ModelServico() {

    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(Double valor_servico) {
        this.valor_servico = valor_servico;
    }

}
