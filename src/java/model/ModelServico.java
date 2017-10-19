package model;

/**
 *
 * @author Anderson
 */
public class ModelServico {

    private int id_servico;
    private String nome;
    private String descricao;
    private Double valor;

    //CONSTRUTOR PRINCIPAL 
    public ModelServico() {
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ModelServico(int id_servico, String nome, String descricao, Double valor) {
        this.id_servico = id_servico;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

}
