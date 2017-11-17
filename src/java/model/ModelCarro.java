package model;

/**
 *
 * @author Anderson
 */
public class ModelCarro {

    private String id_carro;
    private String ano;
    private String cor;
    private ModelCliente cliente;
    private ModelModelo modelo;

    public ModelCarro() {
        cliente = new ModelCliente();
        modelo = new ModelModelo();
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

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public ModelModelo getModelo() {
        return modelo;
    }

    public void setModelo(ModelModelo modelo) {
        this.modelo = modelo;
    }

}
