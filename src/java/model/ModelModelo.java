package model;

/**
 *
 * @author Anderson
 */
public class ModelModelo {

    private int id_modelo;
    private String nome_modelo;
    private ModelMarca marca;
    private String motorizacao;

    public ModelModelo() {
        marca = new ModelMarca();
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNome_modelo() {
        return nome_modelo;
    }

    public void setNome_modelo(String nome_modelo) {
        this.nome_modelo = nome_modelo;
    }

    public ModelMarca getMarca() {
        return marca;
    }

    public void setMarca(ModelMarca marca) {
        this.marca = marca;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

}
