package Financeiro.dao;

import Financeiro.Ice.ICliente;
import Financeiro.to.ClienteFornecTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  ClienteDao.java
 * Author:  Hugo Fabrício G. e Silva
 * Purpose: Defines the Class ClienteDao
 ***********************************************************************/
public class ClienteDao extends GenericDao implements ICliente
{
   private static final long serialVersionUID = 1L;
    private Session session;

    public ClienteDao(Session session) {
        this.session = session;
    }

    public ClienteDao() {
        this.session = getSession();
    }
   public void limpar()
   {
      // TODO: implement
   }
   
   public int salvar(ClienteFornecTo cliente)
   {
      savePojo(cliente);
        return cliente.getCodCliente();
   }
   
   public ClienteFornecTo consultar(ClienteFornecTo cliente)
   {
      return null;
   }
   public int alterar(ClienteFornecTo cliente) {
        saveorUpdatePojo(cliente);
        return cliente.getCodCliente();
    }

    public ClienteFornecTo consultar(int codCliente) {
        ClienteFornecTo cliente = getPojo(ClienteFornecTo.class, codCliente);
        return cliente;
    }

    public List<ClienteFornecTo> consultar() {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo cl where cl.tipoCadastro = 'C' order by cl.nome");
    }

    public List<ClienteFornecTo> consultar_p(String nome) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo cl where cl.tipoCadastro = 'C' and cl.nome like ? order by cl.nome", nome);
    }
   public List<ClienteFornecTo> consultar_cod(Integer codigo) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo cl where cl.tipoCadastro = 'C' and cl.codCliente = ? order by cl.nome", codigo);
    }
   public List<ClienteFornecTo> consultar_fant(String fantasia) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo cl where cl.tipoCadastro = 'C' and cl.nomeFantasia like ? order by cl.nome", fantasia);
    }
   public List<ClienteFornecTo> consultar_cpfCnpj(String cpfCnpj) {
        return getPureList(ClienteFornecTo.class, "from ClienteFornecTo cl where cl.tipoCadastro = 'C' and cl.cpfCnpj = ? order by cl.nome", cpfCnpj);
    }


   public void excluir(ClienteFornecTo cliente)
   {
      removePojo(cliente);
   }

    

}