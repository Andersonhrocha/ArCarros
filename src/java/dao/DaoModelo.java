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
import model.ModelModelo;

public class DaoModelo extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoModelo() {
        conexao = this.abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelModelo pro) { //opcao 1.

        sql = "INSERT INTO modelo (nome_modelo, id_marca, motorizacao) VALUES (?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_modelo());
            pst.setInt(2, pro.getRelacao_id_marca().getId_marca());
            pst.setString(3, pro.getMotorizacao());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro inserido com sucesso.");
            } else {
                System.out.println("Registro não foi inserido.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao inserir o modelo", ex);
        }
    }//FIM DA CLASSE incluir

    //MÉTODO PARA EDIÇÃO
    public void editar(ModelModelo pro) { //opcao 2.

        sql = "UPDATE modelo SET nome_modelo=?, id_marca=?, motorizacao=? WHERE id_modelo=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_modelo());
            pst.setInt(2, pro.getRelacao_id_marca().getId_marca());
            pst.setString(3, pro.getMotorizacao());
            pst.setInt(4, pro.getId_modelo());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro alterado com sucesso.");
            } else {
                System.out.println("Registro não existe para ser alterado.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao atualizar o registro do modelo.", ex);
        }

    }//FIM DA CLASSE editar

    //MÉTODO PARA EXCLUSÃO
    public void excluir(ModelModelo pro) {// opcao 3.

        sql = "DELETE FROM modelo WHERE id_modelo=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, pro.getId_modelo());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao excluir um modelo.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelModelo buscar(ModelModelo pro) { //opcao 4.

        sql = " SELECT * FROM modelo WHERE id_modelo = ?";

        ModelModelo retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, pro.getId_modelo());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelModelo();
                retorno.setId_modelo(Integer.parseInt(rs.getString("id_modelo")));
                retorno.setNome_modelo(rs.getString("nome_modelo"));
                retorno.getRelacao_id_marca().setId_marca(Integer.parseInt(rs.getString("id_marca")));
                retorno.setMotorizacao(rs.getString("motorizacao"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao buscar um modelo.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelModelo> listarTodos() { //opcao 5.

        sql = " SELECT * FROM modelo m INNER JOIN marca c ON c.id_marca = m.id_marca";
        List<ModelModelo> lista = new ArrayList<ModelModelo>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelModelo item = new ModelModelo();
                item.setId_modelo(Integer.parseInt(rs.getString("id_modelo")));
                item.setNome_modelo(rs.getString("nome_modelo"));
                item.getRelacao_id_marca().setNome_marca(rs.getString("nome_marca"));
                item.setMotorizacao(rs.getString("motorizacao"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos modelos.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

    //MÉTODO PARA LISTAGEM DE TODOS OS MODELOS
    public List<ModelModelo> listarModelos() { //opcao 6.

        sql = " SELECT * FROM modelo ";

        List<ModelModelo> lista = new ArrayList<ModelModelo>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelModelo item = new ModelModelo();
                item.setId_modelo(Integer.parseInt(rs.getString("id_modelo")));
                item.setNome_modelo(rs.getString("nome_modelo"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos modelos.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarModelos

}
