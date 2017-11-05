package model;

/**
 *
 * @author Anderson
 */
public class ModelModelo {

    private int id_modelo;
    private String nome_modelo;
    private ModelMarca relacao_id_marca; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELMARCA
    private String motorizacao;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETO DA ENTIDADE MODELMARCA    
    public ModelModelo() {

        relacao_id_marca = new ModelMarca();

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

    public ModelMarca getRelacao_id_marca() {
        return relacao_id_marca;
    }

    public void setRelacao_id_marca(ModelMarca relacao_id_marca) {
        this.relacao_id_marca = relacao_id_marca;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

}
