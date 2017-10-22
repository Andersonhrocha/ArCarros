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
import model.ModelCliente;

public class DaoCliente extends ModuloConexao {

    //VARIÁVEIS
    public Connection conexao;
    private String sql = "";

    //CONSTRUTOR PRINCIPAL DA CLASSE
    public DaoCliente() {
        conexao = this.abrirConexao();
    }

    //MÉTODO PARA INCLUSÃO
    public void incluir(ModelCliente pro) { //opcao 1.

        sql = "INSERT INTO cliente (cpf_cliente, nome_cliente, endereco, telefone, email) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getCpf_cliente());
            pst.setString(2, pro.getNome_cliente());
            pst.setString(3, pro.getEndereco());
            pst.setString(4, pro.getTelefone());
            pst.setString(5, pro.getEmail());

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
    public void editar(ModelCliente pro) { //opcao 2.

        sql = "UPDATE cliente SET nome_cliente=?, endereco=?, telefone=?, email=? WHERE cpf_cliente=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome_cliente());
            pst.setString(2, pro.getEndereco());
            pst.setString(3, pro.getTelefone());
            pst.setString(4, pro.getEmail());
            pst.setString(5, pro.getCpf_cliente());

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
    public void excluir(ModelCliente pro) {// opcao 3.

        sql = "DELETE FROM cliente WHERE cpf_cliente=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getCpf_cliente());

            int status = pst.executeUpdate();
            if (status > 0) {
                System.out.println("Registro excluido com sucesso.");
            } else {
                System.out.println("Registro não existente para exclusão.");
            }
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao excluir um cliente.", ex);
        }
    }//FIM DA CLASSE excluir

    //MÉTODO PARA BUSCAR POR ID
    public ModelCliente buscar(ModelCliente pro) { //opcao 4.

        sql = "SELECT * FROM cliente WHERE cpf_cliente = ?";

        ModelCliente retorno = null;

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, pro.getCpf_cliente());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                retorno = new ModelCliente();
                retorno.setCpf_cliente(rs.getString("cpf_cliente"));
                retorno.setNome_cliente(rs.getString("nome_cliente"));
                retorno.setEndereco(rs.getString("endereco"));
                retorno.setTelefone(rs.getString("telefone"));
                retorno.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao buscar um cliente.", ex);
        }
        return retorno;
    }//FIM DA CLASSE buscar

    //MÉTODO PARA LISTAGEM DE TODOS OS DADOS
    public List<ModelCliente> listarTodos() { //opcao 5.

        sql = "SELECT * FROM cliente";

        List<ModelCliente> lista = new ArrayList<ModelCliente>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCliente item = new ModelCliente();
                item.setCpf_cliente(rs.getString("cpf_cliente"));
                item.setNome_cliente(rs.getString("nome_cliente"));
                item.setEndereco(rs.getString("endereco"));
                item.setTelefone(rs.getString("telefone"));
                item.setEmail(rs.getString("email"));

                lista.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Uma falha ocorreu ao tentar listar todos clientes.", ex);
        }
        return lista;

    } //FIM DA CLASSE listarTodos

}
