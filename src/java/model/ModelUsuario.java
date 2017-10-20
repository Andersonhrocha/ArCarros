package model;

/**
 *
 * @author Anderson
 */
public class ModelUsuario {
    
    private int id_usuario;
    private String nome;
    private String login;
    private String senha;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    
    public ModelUsuario() {
    }

    public ModelUsuario(int id_usuario, String nome, String login, String senha) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    
    
}
