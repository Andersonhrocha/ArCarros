package model;

/**
 *
 * @author Anderson
 */
public class ModelModelo {

    private int id_modelo;
    private String nome;
    private ModelMarca relacao_id_marca; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELMARCA
    private String motorizacao;

    //CONSTRUTOR PRINCIPAL INICIANDO AS VARIÁVEIS E CRIANDO OBJETO DA ENTIDADES MODELMARCA    
    public ModelModelo() {

        nome = "";
        motorizacao = "";
        relacao_id_marca = new ModelMarca();

    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ModelModelo(int id_modelo, String nome, ModelMarca relacao_id_marca, String motorizacao) {
        this.id_modelo = id_modelo;
        this.nome = nome;
        this.relacao_id_marca = relacao_id_marca;
        this.motorizacao = motorizacao;
    }

}
