package Financeiro.dao;

import Financeiro.Ice.IFornecedor;
import Financeiro.to.ClienteFornecTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  FornecedorDao.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FornecedorDao
 ***********************************************************************/

public class FornecedorDao extends GenericDao implements IFornecedor
{
   private static final long serialVersionUID = 1L;
   private Session session;

   public FornecedorDao(Session session){
      this.session = session;
   }

   public FornecedorDao(){
      this.session = getSession();
   }

   public void limpar(){

   }

   public void salvar(ClienteFornecTo fornecedor) {
      savePojo(fornecedor);
   }

   public String alterar(ClienteFornecTo fornecedor) {
      saveorUpdatePojo(fornecedor);
      return fornecedor.getNome();
   }

   public void excluir(ClienteFornecTo fornecedor){
      removePojo(fornecedor);
   }

   public List<ClienteFornecTo> consultar() {
      return getPureList(ClienteFornecTo.class, "from ClienteFornecTo fornec where fornec.tipoCadastro = 'F' order by fornec.nome");
   }

   public ClienteFornecTo consultar(int codFornecedor) {
      ClienteFornecTo fornecedor = getPojo(ClienteFornecTo.class, codFornecedor);
      return fornecedor;
   }

   public List<ClienteFornecTo> consultar_p(String nome) {
      return getPureList(ClienteFornecTo.class, "from ClienteFornecTo forn where forn.tipoCadastro = 'F' and forn.nome like ? order by forn.nome", nome);
   }

   public List<ClienteFornecTo> consultar_cod(Integer codigo) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo forn where forn.tipoCadastro = 'F' and forn.codCliente = ? order by forn.nome", codigo);
    }

   public List<ClienteFornecTo> consultar_fant(String fantasia) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo forn where forn.tipoCadastro = 'F' and forn.nomeFantasia like ? order by forn.nome", fantasia);
    }
   public List<ClienteFornecTo> consultar_cpfCnpj(String cpfCnpj) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo forn where forn.tipoCadastro = 'F' and forn.cpfCnpj = ? order by forn.nome", cpfCnpj);
    }

    public ClienteFornecTo consultar(String fornecedor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}