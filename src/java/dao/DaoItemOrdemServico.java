package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelItemOrdemServico;

/**
 *
 * @author Anderson
 */
public class DaoItemOrdemServico extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoItemOrdemServico() {
        conexao = this.abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelItemOrdemServico pro) { //opcao 1.

        sql = "INSERT INTO item_ordem_servico (id_ordem_servico, id_produto, id_servico, qtd_prod_utilizado) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getRelacao_id_ordem_servico().getId_ordem_Servico());
            pst.setString(2, pro.getRelacao_id_produto().getId_produto());
            pst.setInt(3, pro.getRelacao_id_servico().getId_servico());
            pst.setInt(4, pro.getQtd_prod_utilizado());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoItemOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir item de ordem de serviço", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelItemOrdemServico pro) { //opcao 2.

        sql = "UPDATE item_ordem_servico SET qtd_prod_utilizado=? WHERE id_item_ordem_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getQtd_prod_utilizado());
            pst.setInt(2, pro.getId_item_ordem_servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoItemOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o registro o item de ordem de serviço.", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelItemOrdemServico pro) {// opcao 3.

        sql = "DELETE FROM item_ordem_servico WHERE id_item_ordem_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_item_ordem_servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoItemOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao excluir um item de ordem de serviço.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelItemOrdemServico buscar(ModelItemOrdemServico pro) { //opcao 4.

        sql = "SELECT * FROM item_ordem_servico WHERE id_item_ordem_servico = ?";

        ModelItemOrdemServico retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_item_ordem_servico());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelItemOrdemServico();
                retorno.setId_item_ordem_servico(Integer.parseInt(rs.getString("id_item_ordem_servico")));
                retorno.getRelacao_id_ordem_servico().setId_ordem_Servico(Integer.parseInt(rs.getString("id_ordem_servico")));
                retorno.getRelacao_id_produto().setId_produto(rs.getString("id_produto"));
                retorno.getRelacao_id_servico().setId_servico(Integer.parseInt(rs.getString("id_servico")));
                retorno.setQtd_prod_utilizado(Integer.parseInt(rs.getString("qtd_prod_utilizado")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoItemOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao buscar um item de ordem de serviço.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelItemOrdemServico> listarTodos() { //opcao 5.

        sql = "SELECT * FROM ordem_servico os \n"
                + "INNER JOIN item_ordem_servico ios \n"
                + "ON os.id_ordem_servico = ios.id_ordem_servico \n"
                + "INNER JOIN produto p ON p.id_produto = ios.id_produto \n"
                + "INNER JOIN servico s ON s.id_servico = ios.id_servico";

        List<ModelItemOrdemServico> lista = new ArrayList<ModelItemOrdemServico>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelItemOrdemServico item = new ModelItemOrdemServico();
                item.setId_item_ordem_servico(Integer.parseInt(rs.getString("id_item_ordem_servico")));
                item.getRelacao_id_ordem_servico().setId_ordem_Servico(Integer.parseInt(rs.getString("id_ordem_servico")));
                item.getRelacao_id_produto().setNome_produto(rs.getString("nome_produto"));
                item.getRelacao_id_servico().setNome_servico(rs.getString("nome_servico"));
                item.setQtd_prod_utilizado(Integer.parseInt(rs.getString("qtd_prod_utilizado")));

                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoItemOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos itens de venda.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

}
