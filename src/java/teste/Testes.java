package teste;

import dao.DaoCarro;
import dao.DaoCategoria;
import dao.DaoCliente;
import dao.DaoItemOrdemServico;
import dao.DaoModelo;
import dao.DaoOrdemServico;
import dao.DaoProduto;
import dao.DaoVendaProduto;
import dao.DaoServico;
import dao.DaoVenda;
import dao.ModuloConexao;
import java.sql.Date;
import java.util.List;
import model.ModelCarro;
import model.ModelCategoria;
import model.ModelCliente;
import model.ModelItemOrdemServico;
import model.ModelModelo;
import model.ModelOrdemServico;
import model.ModelProduto;
import model.ModelVendaProduto;
import model.ModelServico;
import model.ModelVenda;

/**
 *
 * @author Angelo
 */
public class Testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//       
//        //TESTE DE CONEXÃO COM BANCO DE DADOS           
//        ModuloConexao dao = new ModuloConexao();
//        dao.abrirConexao();   
//        
//       //TESTE DE INSERÇÃO
//        ModelCliente pro = new ModelCliente();
//        pro.setCpf_cliente("021");
//        pro.setNome("Anderson");
//        pro.setEndereco("Rua Desembargador Lopes Gama, 460");
//        pro.setTelefone("3004-4434");
//        pro.setEmail("anderson@gmail.com");
//
//        DaoCliente dao = new DaoCliente();
//        dao.incluir(pro);
//        
//          //TESTE DE ALTERAÇÃO
//        ModelCliente pro = new ModelCliente();
//        pro.setNome("Anderson Rocha AGORA");
//        pro.setEndereco("Rua Desembargador Lopes Gama, 460");
//        pro.setTelefone("3004-4434");
//        pro.setEmail("anderson@gmail.com");
//        pro.setCpf_cliente("01");
//
//        DaoCliente dao = new DaoCliente();
//        dao.editar(pro);
//        
//          //TESTE DE EXCLUSÃO
//        ModelCliente pro = new ModelCliente();
//        pro.setCpf_cliente("01");
//
//        DaoCliente dao = new DaoCliente();
//        dao.excluir(pro);
//       
//          //TESTE DE LISTAGEM
//        DaoCarro dao = new DaoCarro();
//        List<ModelCarro> pro = dao.listarTodos();
//
//        for (ModelCarro registro : pro) {
//
//            System.out.println("=============================================");
//            System.out.println("PLACA: " + registro.getId_carro());
//            System.out.println("ANO: " + registro.getAno());
//            System.out.println("COR: " + registro.getCor());
//            System.out.println("CLIENTE: " + registro.getRelacao_id_cliente().getCpf_cliente());
//            System.out.println("MODELO: " + registro.getRelacao_id_modelo().getId_modelo());
//            System.out.println("NOME: " + registro.getRelacao_id_modelo().getNome());
//            System.out.println("MOTORIZAÇÃO: " + registro.getRelacao_id_modelo().getMotorizacao());
//            System.out.println("=============================================");
//        }
//        
//        
//           //TESTE DE BUSCAR
//        DaoCliente dao = new DaoCliente();
//        ModelCliente pro = new ModelCliente();
//        pro.setNome_cliente("Au");
//        
//        pro = dao.buscarNome(pro);
//
//        System.out.println("=============================================");
//        System.out.println("Documento: " + pro.getCpf_cliente());
//        System.out.println("Nome: " + pro.getNome_cliente());
//        System.out.println("Bairro: " + pro.getEndereco());
//        System.out.println("Telefone: " + pro.getTelefone());
//        System.out.println("E-mail: " + pro.getEmail());
//       
//        
//        MODELCARRO / DAOCARRO - MODELMODELO / DAOMODELO
//  ##########################################################################################################     
//        
//        
//        //TESTE DE INSERÇÃO
//        ModelCarro pro = new ModelCarro();
//        pro.setId_carro("SKD5078");
//        pro.setAno("2006");
//        pro.setCor("Azul");
//        pro.getRelacao_id_cliente().setCpf_cliente("3423");
//        pro.getRelacao_id_modelo().setId_modelo(Integer.parseInt("4"));
//
//        DaoCarro dao = new DaoCarro();
//        dao.incluir(pro);
//               
//        //TESTE DE ALTERAÇÃO
//        ModelCarro pro = new ModelCarro();
//        pro.setAno("2012");
//        pro.setCor("Preto");
//        pro.getRelacao_id_modelo().setId_modelo(Integer.parseInt("3"));
//        pro.setId_carro("SKD5078");
//        DaoCarro dao = new DaoCarro();
//        dao.editar(pro);
//
//        
//        //TESTE DE EXCLUSÃO
//        ModelCarro pro = new ModelCarro();
//        pro.setId_carro("KDJ");
//
//        DaoCarro dao = new DaoCarro();
//        dao.excluir(pro);
//        
//         //TESTE DE BUSCAR
//        DaoCarro dao = new DaoCarro();
//        ModelCarro pro = new ModelCarro();
//        pro.setId_carro("SKD5078");
//
//        pro = dao.buscar(pro);
//
//        System.out.println("=============================================");
//        System.out.println("PLACA: " + pro.getId_carro());
//        System.out.println("ANO: " + pro.getAno());
//        System.out.println("COR: " + pro.getCor());
//        System.out.println("CLIENTE: " + pro.getRelacao_id_cliente().getCpf_cliente());
//        System.out.println("MODELO: " + pro.getRelacao_id_modelo().getId_modelo());
//        System.out.println("=============================================");
//        
//
//        //TESTE DE LISTAGEM CARRO E MODELO
//        DaoCarro dao = new DaoCarro();
//        List<ModelCarro> pro = dao.listarTodos();
//
//        for (ModelCarro registro : pro) {
//
//            System.out.println("=============================================");
//            System.out.println("PLACA: " + registro.getId_carro());
//            System.out.println("ANO: " + registro.getAno());
//            System.out.println("COR: " + registro.getCor());
//            System.out.println("CLIENTE: " + registro.getRelacao_id_cliente().getCpf_cliente());
//            System.out.println("MODELO: " + registro.getRelacao_id_modelo().getId_modelo());
//            System.out.println("NOME: " + registro.getRelacao_id_modelo().getNome());
//            System.out.println("MOTORIZAÇÃO: " + registro.getRelacao_id_modelo().getMotorizacao());
//            System.out.println("=============================================");
//        }
        //  ##########################################################################################################
//    
//TESTE DE INSERÇÃO
//        ModelOrdemServico pro = new ModelOrdemServico();
//        pro.getRelacao_id_carro().setId_carro("3423");
//        pro.setData(Date.valueOf("19/10/2017"));
//        pro.setOrcamento("S");
//        pro.setValor(Double.valueOf(238.20));
//        pro.setDesconto(Double.valueOf(28.20));
//    
//        DaoOrdemServico dao = new DaoOrdemServico();
//        dao.incluir(pro);
//    
//##############################################################################################################
//        //TESTE DE LISTAGEM MODELO E MARCA
//        DaoModelo dao = new DaoModelo();
//        List<ModelModelo> pro = dao.listarTodos();
//        
//        for (ModelModelo registro : pro) {
//            
//            System.out.println("=============================================");
//            System.out.println("ID: " + registro.getId_modelo());
//            System.out.println("NOME: " + registro.getNome_modelo());
//            System.out.println("MOTORIZAÇÃO: " + registro.getMotorizacao());
//            System.out.println("FABRICANTE: " + registro.getRelacao_id_marca().getNome_marca());
//            
//            System.out.println("=============================================");
//        }
////   //TESTE DE BUSCAR
//        DaoModelo dao = new DaoModelo();
//        ModelModelo pro = new ModelModelo();
//        pro.setId_modelo(1);
//
//        pro = dao.buscar(pro);
//
//        System.out.println("=============================================");
//        System.out.println("PLACA: " + pro.getId_modelo());
//        System.out.println("ANO: " + pro.getNome_modelo());
//        System.out.println("FABRICANTE: " + pro.getRelacao_id_marca().getNome_marca());
//         System.out.println("MOTORIZAÇÃO: " + pro.getMotorizacao());
//        System.out.println("=============================================");
//
//
//
//////        //TESTE DE INSERÇÃO
//        ModelCarro pro = new ModelCarro();
//        pro.setId_carro("MMO9890");
//        pro.setAno("2017");
//        pro.setCor("Vermelho");
//        pro.getRelacao_id_cliente().setCpf_cliente("078");
//        pro.getRelacao_id_modelo().setId_modelo(2);
//        
//        DaoCarro dao = new DaoCarro();
//        dao.incluir(pro);
//      
//TESTE DE ALTERAÇÃO
//        ModelModelo pro = new ModelModelo();
//        pro.setNome_modelo("NEW FIESTA");
//        pro.getRelacao_id_marca().setId_marca(5);
//        pro.setMotorizacao("1.8");
//        pro.setId_modelo(3);
//        
//        DaoModelo dao = new DaoModelo();
//        dao.editar(pro);
//        //TESTE DE LISTAGEM MODELO E MARCA
//        //TESTE DE INSERÇÃO PRODUTO
//        ModelProduto pro = new ModelProduto();
//        pro.setId_produto("0291");
//        pro.setNome_produto("30W50");
//        pro.setDescricao_produto("LUBRAX 20W50");
//        pro.setValidade(new Date(2017-10-24));
//        pro.getRelacao_id_categoria().setId_categoria(2);
//        pro.setValor(Double.valueOf("78"));
//        pro.setQtd_estoque(2);
//
//        DaoProduto dao = new DaoProduto();
//        dao.incluir(pro);
////        //TESTE DE INSERÇÃO ORDEM DE SERVIÇO
//        ModelOrdemServico pro = new ModelOrdemServico();
//        pro.setId_ordem_Servico(2017);
//        pro.getRelacao_id_carro().setId_carro("HKK");
//        pro.setData(new Date(System.currentTimeMillis()));
//        pro.setOrcamento(("S"));
//        pro.setValor(new Double("0.00"));
//        pro.setDesconto(new Double("0.00"));
//
//        DaoOrdemServico dao = new DaoOrdemServico();
//        dao.incluir(pro);
////////        //TESTE DE INSERÇÃO VENDA
//        ModelVenda pro = new ModelVenda();
//        pro.setValor(Double.valueOf("289.00"));
//        pro.setTipoPagamento(("CQ"));
//        pro.setId_venda(14);
//        
//        DaoVenda dao = new DaoVenda();
//        dao.editar(pro);
////        //TESTE DE INSERÇÃO PRODUTOVENDA
//        ModelVendaProduto pro = new ModelVendaProduto();
//        pro.getRelacao_id_venda().setId_venda(1);
//        pro.getRelacao_id_produto().setId_produto("12345");
//        pro.setQuantidade(3);
//
//        DaoVendaProduto dao = new DaoVendaProduto();
//        dao.incluir(pro);
//        TESTE DE ALTERAÇÃO PRODUTOVENDA
//        ModelProdutoVenda pro = new ModelProdutoVenda();
//        pro.setQuantidade(5);
//        pro.getRelacao_id_venda().setId_venda(9);
//        pro.getRelacao_id_produto().setId_produto("928");        
//
//        DaoProdutoVenda dao = new DaoProdutoVenda();
//        dao.editar(pro);
//        //TESTE DE LISTAGEM VENDAPRODUTO
//        DaoVendaProduto dao = new DaoVendaProduto();
//        List<ModelVendaProduto> pro = dao.listarTodos();
//
//        for (ModelVendaProduto registro : pro) {
//
//            System.out.println("=============================================");
//            System.out.println("CLIENTE: " + registro.getRelacao_id_venda().getRelacao_id_cliente().getCpf_cliente());
//            System.out.println("ID VENDA: " + registro.getRelacao_id_venda().getId_venda());
//            System.out.println("ID PRODUTO: " + registro.getRelacao_id_produto().getId_produto());
//            System.out.println("NOME PRODUTO: " + registro.getRelacao_id_produto().getNome_produto());
//            System.out.println("QUANTIDADE: " + registro.getQuantidade());
//             System.out.println("TIPO: " + registro.getTipoPagamento());
//
//            System.out.println("=============================================");
//        }
//////   //TESTE DE BUSCAR VENDAPRODUTO
//        DaoVendaProduto dao = new DaoVendaProduto();
//        ModelVendaProduto pro = new ModelVendaProduto();
//        pro.getRelacao_id_venda().setId_venda(1);
//        pro.getRelacao_id_produto().setId_produto("123456789");
//
//        pro = dao.buscar(pro);
//
//        System.out.println("=============================================");
//        System.out.println("ID VENDA: " + pro.getRelacao_id_venda().getId_venda());
//        System.out.println("ID PRODUTO: " + pro.getRelacao_id_produto().getId_produto());
//        System.out.println("QUANTIDADE: " + pro.getQuantidade());
//        System.out.println("TIPO PAG: " + pro.getTipoPagamento());
//        System.out.println("=============================================");
//
////        //TESTE DE EXCLUSÃO VENDAPRODUTO
//        ModelVendaProduto pro = new ModelVendaProduto();
//
//        pro.setId_venda_produto(4);
//
//        DaoVendaProduto dao = new DaoVendaProduto();
//        dao.excluir(pro);
//        dao.incluir(pro);
////////        //TESTE DE EDIÇÂO VENDAPRODUTO
//        ModelVendaProduto pro = new ModelVendaProduto();
//        pro.getRelacao_id_produto().setId_produto("12345");
//        pro.setQuantidade(10);
//        pro.setTipoPagamento("CD");       
//        pro.setId_venda_produto(5);
//        
//        DaoVendaProduto dao = new DaoVendaProduto();
//        dao.editar(pro);
        //TESTE DE LISTAGEM ITEMORDEMSERVICO
//        DaoItemOrdemServico dao = new DaoItemOrdemServico();
//        List<ModelItemOrdemServico> pro = dao.listarTodos();
//
//        for (ModelItemOrdemServico registro : pro) {
//
//            System.out.println("=============================================");
//            System.out.println("OS: " + registro.getRelacao_id_ordem_servico().getId_ordem_Servico());
//            System.out.println("PRODUTO: " + registro.getRelacao_id_produto().getId_produto());
//            System.out.println("ID PRODUTO: " + registro.getRelacao_id_servico().getId_servico());
//            System.out.println("QTD UTILIZADA: " + registro.getQtd_prod_utilizado());
//            System.out.println("=============================================");
//        }
//        DaoProduto dao = new DaoProduto();
//        List<ModelProduto> pro = dao.listarTodos();
//
//        for (ModelProduto registro : pro) {
//
//            System.out.println("=============================================");
//            System.out.println("PRODUTO: " + registro.getId_produto());
//            System.out.println("VALOR: " + registro.getValor());
//
//            System.out.println("=============================================");
//        }
    }

}
