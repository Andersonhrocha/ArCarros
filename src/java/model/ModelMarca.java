package model;

/**
 *
 * @author Anderson
 */
public class ModelMarca {

    private int id_marca;
    private String nome;

    //CONSTRUTOR PRINCIPAL DA CLASSE INICIANDO A VARIÁVEL SEM VALOR    
    public ModelMarca() {

        nome = "";
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModelMarca(int id_marca, String nome) {
        this.id_marca = id_marca;
        this.nome = nome;
    }

}
