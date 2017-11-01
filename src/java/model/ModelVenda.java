package model;

import java.sql.Date;

/**
 *
 * @author Anderson
 */
public class ModelVenda {

    private int id_venda;
    private ModelCliente relacao_id_cliente;//AGREGAÇÃO/RELACIONAMENTO COM A CLASSE MODELCLIENTE
    private Date data;

    //CONSTRUTOR PRINCIPAL CRIANDO OBJETO DA ENTIDADE MODELCLIENTE
    public ModelVenda() {

        relacao_id_cliente = new ModelCliente();

    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public ModelCliente getRelacao_id_cliente() {
        return relacao_id_cliente;
    }

    public void setRelacao_id_cliente(ModelCliente relacao_id_cliente) {
        this.relacao_id_cliente = relacao_id_cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
