package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelUsuario;

/**
 *
 * @author Anderson
 */
public class DaoUsuario extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoUsuario() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelUsuario pro) { //opcao 1.

        sql = "INSERT INTO usuario (id_usuario, nome, login, senha) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_usuario());
            pst.setString(2, pro.getNome());
            pst.setString(3, pro.getLogin());
            pst.setString(4, pro.getSenha());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir o usuário", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelUsuario pro) { //opcao 2.

        sql = "UPDATE usuario SET nome=?, login=?, senha=? WHERE id_usuario=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome());
            pst.setString(2, pro.getLogin());
            pst.setString(3, pro.getSenha());
            pst.setInt(4, pro.getId_usuario());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro do usuário", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelUsuario pro) {// opcao 3.

        sql = "DELETE FROM usuario WHERE id_usuario=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_usuario());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um usuário.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelUsuario buscar(ModelUsuario pro) { //opcao 4.

        sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        ModelUsuario retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_usuario());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelUsuario();
                retorno.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                retorno.setNome(rs.getString("nome"));
                retorno.setLogin(rs.getString("login"));
                retorno.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um usuário.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelUsuario> listarTodos() { //opcao 5.

        sql = "SELECT * FROM usuario";

        List<ModelUsuario> lista = new ArrayList<ModelUsuario>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelUsuario item = new ModelUsuario();
                item.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                item.setNome(rs.getString("nome"));
                item.setLogin(rs.getString("login"));
                item.setSenha(rs.getString("senha"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos usuário.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

}
