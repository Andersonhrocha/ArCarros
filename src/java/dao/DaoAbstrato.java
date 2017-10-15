package dao;

import java.util.List;
import model.ModelCliente;

/**
 *
 * @author Anderson
 */
public abstract class DaoAbstrato {

    public abstract void incluir(ModelCliente pro);// opcao 1   

    public abstract void editar(ModelCliente pro);//opcao 2    

    public abstract void excluir(ModelCliente pro);// opcao 3

    public abstract ModelCliente buscar(ModelCliente pro);//opcao 4

    public abstract List<ModelCliente> listarTodos();// opcao 5

}
