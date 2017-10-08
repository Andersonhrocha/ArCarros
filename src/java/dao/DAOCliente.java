/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ModelCliente;

/**
 *
 * @author Anderson
 */
public class DAOCliente extends ModeloConexao {

    public Connection conexao = abrirConexao();
    private String sql = "";

    //Método para incluir na tabela cliente
    public boolean incluir(ModelCliente pro) {
        sql = "INSERT INTO cliente (cpf_cliente,nome,endereco,telefone,email) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getCpf_cliente());
            pst.setString(2, pro.getNome());
            pst.setString(3, pro.getEndereco());
            pst.setString(4, pro.getTelefone());
            pst.setString(5, pro.getEmail());

            // Atualiza a tabela cliente com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }//FIM DA CLASSE incluir

    //Método para alterar na tabela cliente
    public boolean alterar(ModelCliente pro) {
        sql = "UPDATE cliente SET nome=?, endereco=?,telefone=?, email=? WHERE cpf_cliente=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getNome());
            pst.setString(2, pro.getEndereco());
            pst.setString(3, pro.getTelefone());
            pst.setString(4, pro.getEmail());
            pst.setString(5, pro.getCpf_cliente());

            // Atualiza a tabela cliente com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }//FIM DA CLASSE alterar

    //Método para excluir na tabela cliente
    public boolean excluir(ModelCliente pro) {
        sql = "DELETE FROM cliente WHERE cpf_cliente=? ";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, pro.getCpf_cliente());

            // Atualiza a tabela cliente com os dados do formulário
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }//FIM DA CLASSE excluir

    //Método para listar todos os cliente da tabela
    public List<ModelCliente> listarContatos() {
        sql = "SELECT * FROM cliente";

        List<ModelCliente> retornoArray = new ArrayList<ModelCliente>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ModelCliente registro = new ModelCliente();
                registro.setCpf_cliente(rs.getString("txtCodigo"));
                registro.setNome(rs.getString("txtNome"));
                registro.setEndereco(rs.getString("txtEndereco"));
                registro.setTelefone(rs.getString("txtTelefone"));
                registro.setEmail(rs.getString("txtEmail"));

                retornoArray.add(registro);
            }
            return retornoArray;

        } catch (Exception e) {
            return null;
        }

    } //FIM DA CLASSE listarContatos
}
