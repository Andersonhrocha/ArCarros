/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anderson
 */
public class ModeloConexao {
    
    // Armazenando informações Referente ao banco de dados
    private final String base = "db_arcarros";
    private final String usuarios = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection conexao = null;
    
    //Método que requer um retorno, e estabelece conexão com o banco de dados
    public Connection abrirConexao() {

        try {
            //Responsável por as configurações do BD MySql.
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(this.url, this.usuarios, this.password);
            System.out.println("Conexão de banco de dados: Status Ok!");
            return conexao;

        } catch (Exception e) {
            System.out.println("Erro ao tentar abrir o banco de dados." + e);
            return conexao;
        }
    } //FIM DA CLASSE abrirConexao
    
    public void fecharConexao() {
        try {
            //verifica se existe conexao aberta para poder fechar
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }//FIM DA CLASSE fecharConexao
    
}//FIM DA CLASSE ModuloConexao
