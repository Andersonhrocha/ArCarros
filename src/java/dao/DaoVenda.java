package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelVenda;

/**
 *
 * @author Anderson
 */
public class DaoVenda extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoVenda() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelVenda pro) { //opcao 1.

        sql = "INSERT INTO venda (cpf_cliente, data) VALUES (?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getCliente().getCpf_cliente());
            pst.setDate(2, new Date(pro.getData().getTime()));

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir o venda", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelVenda pro) { //opcao 2.

        sql = "UPDATE venda SET data=? WHERE id_venda=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setDate(1, new Date(pro.getData().getTime()));
            pst.setInt(2, pro.getId_venda());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro da venda", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelVenda pro) {// opcao 3.

        sql = "DELETE FROM venda WHERE id_venda=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_venda());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um venda.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelVenda buscar(ModelVenda pro) { //opcao 4.

        sql = "SELECT * FROM venda WHERE id_venda = ?";

        ModelVenda retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_venda());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelVenda();
                retorno.setId_venda(Integer.parseInt(rs.getString("id_venda")));
                retorno.getCliente().setCpf_cliente(rs.getString("cpf_cliente"));
                retorno.setData(rs.getDate("data"));

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um venda.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelVenda> listarTodos() { //opcao 5.

        sql = "SELECT * FROM venda";

        List<ModelVenda> lista = new ArrayList<ModelVenda>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelVenda item = new ModelVenda();
                item.setId_venda(Integer.parseInt(rs.getString("id_venda")));
                item.getCliente().setCpf_cliente(rs.getString("cpf_cliente"));
                item.setData(rs.getDate("data"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todas as vendas.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

}
