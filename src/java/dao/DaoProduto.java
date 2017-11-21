package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelProduto;

/**
 *
 * @author Anderson
 */
public class DaoProduto extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoProduto() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelProduto pro) { //opcao 1.

        sql = "INSERT INTO produto (id_produto, nome_produto, descricao_produto, validade, id_categoria, valor_produto, qtd_estoque) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getId_produto());
            pst.setString(2, pro.getNome_produto());
            pst.setString(3, pro.getDescricao_produto());
            pst.setDate(4, new Date(pro.getValidade().getTime()));
            pst.setInt(5, pro.getCategoria().getId_categoria());
            pst.setDouble(6, pro.getValor_produto());
            pst.setInt(7, pro.getQtd_estoque());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir o produto", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelProduto pro) { //opcao 2.

        sql = "UPDATE produto SET nome_produto=?, descricao_produto=?, validade=?, id_categoria=?, valor_produto=?, qtd_estoque=? WHERE id_produto=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pro.getNome_produto());
            pst.setString(2, pro.getDescricao_produto());
            pst.setDate(3, new Date(pro.getValidade().getTime()));
            pst.setInt(4, pro.getCategoria().getId_categoria());
            pst.setDouble(5, pro.getValor_produto());
            pst.setInt(6, pro.getQtd_estoque());
            pst.setString(7, pro.getId_produto());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro do produto", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelProduto pro) {// opcao 3.

        sql = "DELETE FROM produto WHERE id_produto=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getId_produto());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um produto.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelProduto buscar(ModelProduto pro) { //opcao 4.

        sql = "SELECT * FROM produto WHERE id_produto = ?";

        ModelProduto retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pro.getId_produto());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelProduto();
                retorno.setId_produto(rs.getString("id_produto"));
                retorno.setNome_produto(rs.getString("nome_produto"));
                retorno.setDescricao_produto(rs.getString("descricao_produto"));
                retorno.setValidade(rs.getDate("validade"));
                retorno.getCategoria().setId_categoria(Integer.parseInt(rs.getString("id_categoria")));
                retorno.setValor_produto(Double.valueOf(rs.getString("valor_produto")));
                retorno.setQtd_estoque(Integer.parseInt(rs.getString("qtd_estoque")));

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um produto.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelProduto> listarTodos() { //opcao 5.

        sql = "SELECT * FROM produto";

        List<ModelProduto> lista = new ArrayList<ModelProduto>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelProduto item = new ModelProduto();
                item.setId_produto(rs.getString("id_produto"));
                item.setNome_produto(rs.getString("nome_produto"));
                item.setDescricao_produto(rs.getString("descricao_produto"));
                item.setValor_produto(Double.valueOf(rs.getString("valor_produto")));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos produto.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

    //MÉTODO PARA LISTAGEM DE TODOS OS PRODUTOS
    public List<ModelProduto> listarProdutos() { //opcao 6.

        sql = " SELECT * FROM produto ";

        List<ModelProduto> lista = new ArrayList<ModelProduto>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelProduto item = new ModelProduto();
                item.setId_produto(rs.getString("id_produto"));
                item.setNome_produto(rs.getString("nome_produto"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos os produtos.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarProdutos

}
