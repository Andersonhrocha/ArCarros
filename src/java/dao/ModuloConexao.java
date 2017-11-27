package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anderson
 */
public abstract class ModuloConexao {

    // Armazenando informações Referente ao banco de dados
    private final String base = "db_arcarros";
    private final String usuarios = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection conexao = null;

    //Método que estabelece conexão com o banco de dados
    public Connection abrirConexao() {

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(this.url, this.usuarios, this.password);
            // System.out.println("Conexão de banco de dados: Status Ok!");
            return conexao;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao tentar abrir conexão com o banco de dados, Driver JDBC não existe.", ex);
        }
    } //FIM DA CLASSE abrirConexao

    public void fecharConexao() {
        try {
            //verifica se existe conexao aberta para poder fechar
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar fechar conexão com banco de dados.", ex);
        }
    }//FIM DA CLASSE fecharConexao

}//FIM DA CLASSE ModuloConexao
