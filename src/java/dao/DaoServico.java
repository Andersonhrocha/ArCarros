package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelServico;

/**
 *
 * @author Anderson
 */
public class DaoServico extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoServico() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelServico pro) { //opcao 1.

        sql = "INSERT INTO servico (nome_servico, descricao, valor_servico) VALUES (?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_servico());
            pst.setString(2, pro.getDescricao());
            pst.setDouble(3, pro.getValor_servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir o serviço", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelServico pro) { //opcao 2.

        sql = "UPDATE servico SET nome_servico=?, descricao=?, valor_servico=? WHERE id_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_servico());
            pst.setString(2, pro.getDescricao());
            pst.setDouble(3, pro.getValor_servico());
            pst.setInt(4, pro.getId_servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro do serviço", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelServico pro) {// opcao 3.

        sql = "DELETE FROM servico WHERE id_servico=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_servico());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um serviço.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelServico buscar(ModelServico pro) { //opcao 4.

        sql = "SELECT * FROM servico WHERE id_servico = ?";

        ModelServico retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_servico());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelServico();
                retorno.setId_servico(Integer.parseInt(rs.getString("id_servico")));
                retorno.setNome_servico(rs.getString("nome_servico"));
                retorno.setDescricao(rs.getString("descricao"));
                retorno.setValor_servico(Double.valueOf(rs.getString("valor_servico")));

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um serviço.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelServico> listarTodos() { //opcao 5.

        sql = "SELECT * FROM servico";

        List<ModelServico> lista = new ArrayList<ModelServico>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelServico item = new ModelServico();
                item.setId_servico(Integer.parseInt(rs.getString("id_servico")));
                item.setNome_servico(rs.getString("nome_servico"));
                item.setDescricao(rs.getString("descricao"));
                item.setValor_servico(Double.valueOf(rs.getString("valor_servico")));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos os serviços.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

    //MÉTODO PARA LISTAGEM DE TODOS OS SERVIÇOS
    public List<ModelServico> listarServico() { //opcao 6.

        sql = " SELECT * FROM servico ";

        List<ModelServico> lista = new ArrayList<ModelServico>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelServico item = new ModelServico();
                item.setId_servico(Integer.parseInt(rs.getString("id_servico")));
                item.setNome_servico(rs.getString("nome_servico"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos os serviços.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarServico

}
