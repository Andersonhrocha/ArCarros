package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelCategoria;

/**
 *
 * @author Anderson
 */
public class DaoCategoria extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoCategoria() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelCategoria pro) { //opcao 1.

        sql = "INSERT INTO categoria (nome_categoria, descricao) VALUES (?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_categoria());
            pst.setString(2, pro.getDescricao());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir uma categoria", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelCategoria pro) { //opcao 2.

        sql = "UPDATE categoria SET nome_categoria=?, descricao=? WHERE id_categoria=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_categoria());
            pst.setString(2, pro.getDescricao());
            pst.setInt(3, pro.getId_categoria());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro da categoria.", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelCategoria pro) {// opcao 3.

        sql = "DELETE FROM categoria WHERE id_categoria=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_categoria());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir uma categoria.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelCategoria buscar(ModelCategoria pro) { //opcao 4.

        sql = "SELECT * FROM categoria WHERE id_categoria = ?";

        ModelCategoria retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_categoria());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelCategoria();
                retorno.setId_categoria(rs.getInt("id_categoria"));
                retorno.setNome_categoria(rs.getString("nome_categoria"));
                retorno.setDescricao(rs.getString("descricao"));

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar uma categoria.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelCategoria> listarTodos() { //opcao 5.

        sql = "SELECT * FROM categoria";

        List<ModelCategoria> lista = new ArrayList<ModelCategoria>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCategoria item = new ModelCategoria();
                item.setId_categoria(rs.getInt("id_categoria"));
                item.setNome_categoria(rs.getString("nome_categoria"));
                item.setDescricao(rs.getString("descricao"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos categorias.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

    //MÉTODO PARA LISTAGEM DE TODAS AS CATEGORIAS
    public List<ModelCategoria> listarCategoria() { //opcao 6.

        sql = " SELECT * FROM categoria ";

        List<ModelCategoria> lista = new ArrayList<ModelCategoria>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCategoria item = new ModelCategoria();
                item.setId_categoria(Integer.parseInt(rs.getString("id_categoria")));
                item.setNome_categoria(rs.getString("nome_categoria"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todas as categorias.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarCategoria

}
