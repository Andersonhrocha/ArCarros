package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelCarro;

/**
 *
 * @author Anderson
 */
public class DaoCarro extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    public DaoCarro() {
        conexao = abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelCarro pro) { //opcao 1.

        sql = "INSERT INTO carro (id_carro, ano, cor, cpf_cliente, id_modelo) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getId_carro());
            pst.setString(2, pro.getAno());
            pst.setString(3, pro.getCor());
            pst.setString(4, pro.getCliente().getCpf_cliente());
            pst.setInt(5, pro.getModelo().getId_modelo());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir um carro", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelCarro pro) { //opcao 2.

        sql = "UPDATE carro SET ano=?, cor=?, id_modelo=? WHERE id_carro=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getAno());
            pst.setString(2, pro.getCor());
            pst.setInt(3, pro.getModelo().getId_modelo());
            pst.setString(4, pro.getId_carro());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar o registro de um carro", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelCarro pro) {// opcao 3.

        sql = "DELETE FROM carro WHERE id_carro=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getId_carro());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao excluir um carro.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelCarro buscar(ModelCarro pro) { //opcao 4.

        sql = "SELECT * FROM carro WHERE id_carro = ?";

        ModelCarro retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pro.getId_carro());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelCarro();
                retorno.setId_carro(rs.getString("id_carro"));
                retorno.setAno(rs.getString("ano"));
                retorno.setCor(rs.getString("cor"));
                retorno.getCliente().setCpf_cliente(rs.getString("cpf_cliente"));
                retorno.getModelo().setId_modelo(Integer.parseInt(rs.getString("id_modelo")));

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao buscar um carro.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelCarro> listarTodos() { //opcao 5.

        // SELECT UNINDO AS TABELAS CARRO E MODELO
        sql = "SELECT carro.id_carro, carro.ano, carro.cor, carro.cpf_cliente, modelo.id_modelo, modelo.nome_modelo, modelo.motorizacao FROM carro INNER JOIN modelo ON carro.id_modelo = modelo.id_modelo";

        List<ModelCarro> lista = new ArrayList<ModelCarro>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCarro item = new ModelCarro();
                item.setId_carro(rs.getString("id_carro"));
                item.setAno(rs.getString("ano"));
                item.setCor(rs.getString("cor"));
                item.getCliente().setCpf_cliente(rs.getString("cpf_cliente"));
                item.getModelo().setNome_modelo(rs.getString("nome_modelo"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todas os carros.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

    //MÉTODO PARA LISTAGEM DE TODOS OS VEÍCULOS
    public List<ModelCarro> listarVeiculos() { //opcao 6.

        sql = " SELECT * FROM carro ";

        List<ModelCarro> lista = new ArrayList<ModelCarro>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCarro item = new ModelCarro();
                item.setId_carro((rs.getString("id_carro")));

                lista.add(item);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos os carros.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarVeiculos

}
