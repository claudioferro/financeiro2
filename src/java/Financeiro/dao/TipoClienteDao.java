package Financeiro.dao;

import Financeiro.Ice.ITipoCliente;
import Financeiro.to.TipoClienteTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  TipoClienteDao.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class TipoClienteDao
 ***********************************************************************/
public class TipoClienteDao extends GenericDao implements ITipoCliente {

    private static final long serialVersionUID = 1L;
    private Session session;

    public TipoClienteDao(Session session) {
        this.session = session;
    }

    public TipoClienteDao() {
        this.session = getSession();
    }

    public List<TipoClienteTo> consultar() {
         return getPureList(TipoClienteTo.class, "from TipoClienteTo tipocl order by tipocl.descricao");
    }

    public List<TipoClienteTo> consultar_p(String desc_TipoCliente) {
         return getPureList(TipoClienteTo.class, "from TipoClienteTo tipocl where tipocl.descricao like ? order by tipocl.descricao ",desc_TipoCliente);
    }
    //Criado por Tiago Portella para validação
    public List<TipoClienteTo> consultar_DescricaoReduzida(String desc_TipoCliente) {
         return getPureList(TipoClienteTo.class, "from TipoClienteTo tipocl where tipocl.descricaoReduzida = ?",desc_TipoCliente);
    }

    public void limpar() {
    }


    public void salvar(TipoClienteTo tipoCliente) {
        savePojo(tipoCliente);
    }

    public TipoClienteTo consultar(int codtipocliente) {
        TipoClienteTo tipoCliente = getPojo(TipoClienteTo.class, codtipocliente);
        return tipoCliente;
    }

    public void excluir(TipoClienteTo tipoCliente) {
        removePojo(tipoCliente);
    }

    public String alterar(TipoClienteTo tipoCliente) {
        saveorUpdatePojo(tipoCliente);
        return tipoCliente.getDescricao();
    }
}