package model;

/**
 *
 * @author Anderson
 */
public class ModelCarro {

    private String id_carro;
    private String ano;
    private String cor;
    private ModelCliente relacao_id_cliente; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELCLIENTE
    private ModelModelo relacao_id_modelo; //AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELMODELO

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETOS DAS ENTIDADES MODELCLIENTE E MODELMOLETO    
    public ModelCarro() {

        relacao_id_cliente = new ModelCliente();
        relacao_id_modelo = new ModelModelo();
    }

    public String getId_carro() {
        return id_carro;
    }

    public void setId_carro(String id_carro) {
        this.id_carro = id_carro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ModelCliente getRelacao_id_cliente() {
        return relacao_id_cliente;
    }

    public void setRelacao_id_cliente(ModelCliente relacao_id_cliente) {
        this.relacao_id_cliente = relacao_id_cliente;
    }

    public ModelModelo getRelacao_id_modelo() {
        return relacao_id_modelo;
    }

    public void setRelacao_id_modelo(ModelModelo relacao_id_modelo) {
        this.relacao_id_modelo = relacao_id_modelo;
    }

}
