package dao;

/**
 *
 * @author Anderson
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelVendaProduto;

public class DaoVendaProduto extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoVendaProduto() {
        conexao = this.abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelVendaProduto pro) { //opcao 1.

        sql = "INSERT INTO venda_produto (id_venda, id_produto, quantidade, tipo_pagamento) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getRelacao_id_venda().getId_venda());
            pst.setString(2, pro.getRelacao_id_produto().getId_produto());
            pst.setInt(3, pro.getQuantidade());
            pst.setString(4, pro.getTipoPagamento());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir item de venda", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelVendaProduto pro) { //opcao 2.

        sql = "UPDATE venda_produto SET id_produto=?, quantidade=?, tipo_pagamento=? WHERE id_venda_produto=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getRelacao_id_produto().getId_produto());
            pst.setInt(2, pro.getQuantidade());
            pst.setString(3, pro.getTipoPagamento());
            pst.setInt(4, pro.getId_venda_produto());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o registro o item de venda", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelVendaProduto pro) {// opcao 3.

        sql = "DELETE FROM venda_produto WHERE id_venda_produto = ? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_venda_produto());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao excluir um item de venda.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelVendaProduto buscar(ModelVendaProduto pro) { //opcao 4.

        sql = "SELECT * FROM venda_produto WHERE id_venda_produto = ?";

        ModelVendaProduto retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_venda_produto());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelVendaProduto();
                retorno.setId_venda_produto(Integer.parseInt(rs.getString("id_venda_produto")));
                retorno.getRelacao_id_venda().setId_venda(Integer.parseInt(rs.getString("id_venda")));
                retorno.getRelacao_id_produto().setId_produto(rs.getString("id_produto"));
                retorno.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                retorno.setTipoPagamento(rs.getString("tipo_pagamento"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao buscar um item de venda.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelVendaProduto> listarTodos() { //opcao 5.

        sql = "SELECT vp.id_venda_produto, v.cpf_cliente, v.id_venda, p.id_produto, p.nome_produto, vp.quantidade, vp.tipo_pagamento FROM venda v INNER JOIN venda_produto vp ON v.id_venda = vp.id_venda INNER JOIN produto p ON p.id_produto = vp.id_produto";

        List<ModelVendaProduto> lista = new ArrayList<ModelVendaProduto>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelVendaProduto item = new ModelVendaProduto();
                item.setId_venda_produto(Integer.parseInt(rs.getString("id_venda_produto")));
                item.getRelacao_id_venda().getRelacao_id_cliente().setCpf_cliente(rs.getString("cpf_cliente"));
                item.getRelacao_id_venda().setId_venda(Integer.parseInt(rs.getString("id_venda")));
                item.getRelacao_id_produto().setId_produto(rs.getString("id_produto"));
                item.getRelacao_id_produto().setNome_produto(rs.getString("nome_produto"));
                item.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                item.setTipoPagamento(rs.getString("tipo_pagamento"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos itens de venda.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

     //MÉTODO PARA SOMAR PRODUTOS
    public void SomaProdutos() {

        sql = "SELECT * FROM  venda v INNER JOIN venda_produto vp ON v.id_venda = vp.id_venda \n"
                + "INNER JOIN produto p ON p.id_produto = vp.id_produto WHERE id_venda_produto = ? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            double total = 0;
            
            while (rs.next()) {
                total = total + rs.getFloat("valor") * rs.getInt(Integer.parseInt("quantidade"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoVendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar somar todos os produtos da venda.", ex);
        }
        
    }//FIM DA CLASSE SomaProdutos

}
