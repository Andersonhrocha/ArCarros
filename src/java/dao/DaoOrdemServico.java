package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.ModelOrdemServico;

/**
 *
 * @author Anderson
 */
public class DaoOrdemServico extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoOrdemServico() {

        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelOrdemServico pro) { //opcao 1.

        sql = "INSERT INTO ordem_servico (id_ordem_servico, id_carro, data, situacao, valor, desconto) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_ordem_Servico());
            pst.setString(2, pro.getCarro().getId_carro());
            pst.setDate(3, new Date(pro.getData().getTime()));
            pst.setString(4, pro.getSituacao());
            pst.setDouble(5, pro.getValor());
            pst.setDouble(6, pro.getDesconto());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir ordem de serviço", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelOrdemServico pro) { //opcao 2.

        sql = "UPDATE ordem_servico SET situacao=?, valor=?, desconto=? WHERE id_ordem_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getSituacao());
            pst.setDouble(2, pro.getValor());
            pst.setDouble(3, pro.getDesconto());
            pst.setInt(4, pro.getId_ordem_Servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro da ordem de serviço", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelOrdemServico pro) {// opcao 3.

        sql = "DELETE FROM ordem_servico WHERE id_ordem_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_ordem_Servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um ordem de serviço.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelOrdemServico buscar(ModelOrdemServico pro) { //opcao 4.

        sql = "SELECT * FROM ordem_servico WHERE id_ordem_servico = ?";

        ModelOrdemServico retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_ordem_Servico());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelOrdemServico();
                retorno.setId_ordem_Servico(Integer.parseInt(rs.getString("id_ordem_servico")));
                retorno.getCarro().setId_carro(rs.getString("id_carro"));
                retorno.setData(rs.getDate("data"));
                retorno.setSituacao(rs.getString("situacao"));
                retorno.setValor(Double.valueOf(rs.getString("valor")));
                retorno.setDesconto(Double.valueOf(rs.getString("desconto")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um ordem de serviço.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelOrdemServico> listarTodos() { //opcao 5.

        sql = "SELECT * FROM ordem_servico";

        List<ModelOrdemServico> lista = new ArrayList<ModelOrdemServico>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelOrdemServico item = new ModelOrdemServico();
                item.setId_ordem_Servico(Integer.parseInt(rs.getString("id_ordem_servico")));
                item.getCarro().setId_carro(rs.getString("id_carro"));
                item.setData(rs.getDate("data"));
                item.setSituacao(rs.getString("situacao"));
                item.setValor(Double.valueOf(rs.getString("valor")));
                item.setDesconto(Double.valueOf(rs.getString("desconto")));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todas ordem de serviço.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos
}
