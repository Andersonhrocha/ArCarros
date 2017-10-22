package model;

/**
 *
 * @author Anderson
 */
public class ModelCliente {

    private String cpf_cliente;
    private String nome_cliente;
    private String endereco;
    private String telefone;
    private String email;

    //CONSTRUTOR PRINCIPAL INICIANDO AS VARIÁVEIS COM VALOR VAZIO
    public ModelCliente() {
        cpf_cliente = "";
        nome_cliente = "";
        endereco = "";
        telefone = "";
        email = "";
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ModelCliente(String cpf_cliente, String nome_cliente, String endereco, String telefone, String email) {
        this.cpf_cliente = cpf_cliente;
        this.nome_cliente = nome_cliente;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

}
