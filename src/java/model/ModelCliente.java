package model;

/**
 *
 * @author Anderson
 */
public class ModelCliente {
    
    private String cpf_cliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ModelCliente() {
    }

    public ModelCliente(String cpf_cliente, String nome, String endereco, String telefone, String email) {
        this.cpf_cliente = cpf_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }   
}
