package teste;

import dao.DaoCliente;
import dao.ModuloConexao;
import java.util.List;
import model.ModelCliente;

/**
 *
 * @author Angelo
 */
public class Testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* 
       
        //TESTE DE CONEXÃO COM BANCO DE DADOS           
        ModuloConexao dao = new ModuloConexao();
        dao.abrirConexao();   
              
        
       //TESTE DE INSERÇÃO
        ModelCliente pro = new ModelCliente();
        pro.setCpf_cliente("021");
        pro.setNome("Anderson");
        pro.setEndereco("Rua Desembargador Lopes Gama, 460");
        pro.setTelefone("3004-4434");
        pro.setEmail("anderson@gmail.com");

        DaoCliente dao = new DaoCliente();
        dao.incluir(pro);
        
        
          //TESTE DE ALTERAÇÃO
        ModelCliente pro = new ModelCliente();
        pro.setNome("Anderson Rocha AGORA");
        pro.setEndereco("Rua Desembargador Lopes Gama, 460");
        pro.setTelefone("3004-4434");
        pro.setEmail("anderson@gmail.com");
        pro.setCpf_cliente("01");

        DaoCliente dao = new DaoCliente();
        dao.editar(pro);
       
        
          //TESTE DE EXCLUSÃO
        ModelCliente pro = new ModelCliente();
        pro.setCpf_cliente("01");

        DaoCliente dao = new DaoCliente();
        dao.excluir(pro);
       
        
         //TESTE DE LISTAGEM
        DaoCliente dao = new DaoCliente();
        List<ModelCliente> pro = dao.listarTodos();

        for (ModelCliente registro : pro) {

            System.out.println("=============================================");
            System.out.println("Documento: " + registro.getCpf_cliente());
            System.out.println("Nome: " + registro.getNome());
            System.out.println("Bairro: " + registro.getEndereco());
            System.out.println("Telefone: " + registro.getTelefone());
            System.out.println("E-mail: " + registro.getEmail());
            System.out.println("=============================================");
        }
        
        
           //TESTE DE BUSCAR
        DaoCliente dao = new DaoCliente();
        ModelCliente pro = new ModelCliente();
        pro.setCpf_cliente("123");
        
        pro = dao.buscar(pro);

        System.out.println("=============================================");
        System.out.println("Documento: " + pro.getCpf_cliente());
        System.out.println("Nome: " + pro.getNome());
        System.out.println("Bairro: " + pro.getEndereco());
        System.out.println("Telefone: " + pro.getTelefone());
        System.out.println("E-mail: " + pro.getEmail());
       
        
        
        
         */
    }
}
