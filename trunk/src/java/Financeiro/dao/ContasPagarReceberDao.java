package Financeiro.dao;

import Financeiro.Ice.IContasPagarReceber;
import Financeiro.to.ContasPagarReceberTo;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  ContasPagarReceberDao.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class ContasPagarReceberDao
 ***********************************************************************/

public class ContasPagarReceberDao extends GenericDao implements IContasPagarReceber
{
   private static final long serialVersionUID = 1L;
   private Session session;

   public ContasPagarReceberDao(Session session){
      this.session = session;
   }

   public ContasPagarReceberDao(){
      this.session = getSession();
   }



   public void limpar(){

   }

   public String alterar(ContasPagarReceberTo contas) {
      saveorUpdatePojo(contas);
      return contas.getNumDocumento();
   }

   public void excluir(ContasPagarReceberTo contas){
      removePojo(contas);
   }

   public ContasPagarReceberTo consultar(int codContas) {
      ContasPagarReceberTo contas = getPojo(ContasPagarReceberTo.class, codContas);
      return contas;
   }

   public List<ContasPagarReceberTo> consultar() {
      return getPureList(ContasPagarReceberTo.class, "from ContasPagarReceberTo contas order by contas.numDocumento");
   }

   public List<ContasPagarReceberTo> consultar_p(String numDoc) {
      return getPureList(ContasPagarReceberTo.class, "from ContasPagarReceberTo contas where contas.numDocumento = ? order by contas.numDocumento", numDoc);
   }

   public List<ContasPagarReceberTo> consultar_clie(String cliente) {
      return getPureList(ContasPagarReceberTo.class, 
              "from ContasPagarReceberTo contas where contas.clienteFornec.nome like ? order by contas.numDocumento", cliente);
   }

   public List<ContasPagarReceberTo> consultar_datavenc(Date data) {
      return getPureList(ContasPagarReceberTo.class, "from ContasPagarReceberTo contas where contas.dataVencimento = ? order by contas.numDocumento", data);
   }

   public List<ContasPagarReceberTo> consultar_valor(float valor) {
      return getPureList(ContasPagarReceberTo.class, "from ContasPagarReceberTo contas where contas.valor = ? order by contas.numDocumento", valor);
   }

   public List<ContasPagarReceberTo> consultar_cod(Integer codigo) {
        return getPureList(ContasPagarReceberTo.class, "from ContasPagarReceberTo contas where contas.codContas = ? order by contas.numDocumento", codigo);
   }


   public ContasPagarReceberTo consultar(String contaspagarreceber) {
        throw new UnsupportedOperationException("Not supported yet.");
   }

    public void salvar(ContasPagarReceberTo contas) {
        savePojo(contas);
    }

}
