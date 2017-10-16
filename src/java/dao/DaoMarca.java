package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelMarca;

/**
 *
 * @author Anderson
 */
public class DaoMarca extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoMarca() {
        conexao = this.abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelMarca pro) { //opcao 1.

        sql = "INSERT INTO marca (id_marca, nome) VALUES (?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_marca());
            pst.setString(2, pro.getNome());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir o cliente", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelMarca pro) { //opcao 2.

        sql = "UPDATE marca SET nome=? WHERE id_marca=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome());
            pst.setInt(2, pro.getId_marca());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o registro do cliente", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelMarca pro) {// opcao 3.

        sql = "DELETE FROM marca WHERE id_marca=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_marca());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para excluisão.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao excluir um cliente.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelMarca buscar(ModelMarca pro) { //opcao 4.

        sql = "SELECT * FROM marca WHERE id_marca = ?";

        ModelMarca retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_marca());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelMarca();
                retorno.setId_marca(Integer.parseInt(rs.getString("id_marca")));
                retorno.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao buscar um cliente.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelMarca> listarTodos() { //opcao 5.

        sql = "SELECT * FROM marca";

        List<ModelMarca> lista = new ArrayList<ModelMarca>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelMarca item = new ModelMarca();
                item.setId_marca(Integer.parseInt(rs.getString("id_marca")));
                item.setNome(rs.getString("nome"));
                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos clientes.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos
}