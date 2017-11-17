package model;

import java.sql.Date;

/**
 *
 * @author Anderson
 */
public class ModelVenda {

    private int id_venda;
    private ModelCliente cliente;
    private Date data;

    public ModelVenda() {
        cliente = new ModelCliente();
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
