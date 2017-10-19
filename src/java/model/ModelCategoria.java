package model;

/**
 *
 * @author Anderson
 */
public class ModelCategoria {

    private int id_categoria;
    private String nome;
    private String descricao;

    //CONSTRUTOR PRINCIPAL INICIANDO AS VARIÁVEIS COM VALOR VAZIO
    public ModelCategoria() {
        nome = "";
        descricao = "";
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public ModelCategoria(int id_categoria, String nome, String descricao) {
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.descricao = descricao;
    }

}
