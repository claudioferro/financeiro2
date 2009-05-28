package Financeiro.dao;

import Financeiro.Ice.IBancos;
import Financeiro.to.BancosTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  BancosDao.java
 * Author:  Hugo Fabríco Gonçalves e Silva
 * Purpose: Defines the Class BancosDao
 ***********************************************************************/
public class BancosDao extends GenericDao implements IBancos {

    private static final long serialVersionUID = 1L;
    private Session session;

    public BancosDao(Session session) {
        this.session = session;
    }

    public BancosDao() {
        this.session = getSession();
    }

    public void alterar(BancosTo banco) {
       saveorUpdatePojo(banco);
    }

    public void limpar() {
    }

    public String salvar(BancosTo bancos) {
        saveorUpdatePojo(bancos);
        return bancos.getNumBanco();
    }

    public BancosTo consultar(String numBanco) {
         BancosTo bancos = getPojo(BancosTo.class, numBanco);
        return bancos;
    }

    public void excluir(BancosTo bancos) {
          removePojo(bancos);
    }
    public List<BancosTo> consultar() {
        return getPureList(BancosTo.class, "from BancosTo banco order by banco.descricaoBanco");
    }

    public List<BancosTo> consultar_p(String desc_Banco) {
        return getPureList(BancosTo.class, "from BancosTo banco where banco.descricaoBanco like ? order by  banco.descricaoBanco", desc_Banco);
    }
    //Criado por Tiago Portella para Validação
    public List<BancosTo> consultar_Codigo(String cod_Banco) {
        return getPureList(BancosTo.class, "from BancosTo banco where banco.numBanco = ?", cod_Banco);
    }
}