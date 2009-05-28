package Financeiro.dao;

import Financeiro.Ice.IContaCorrente;
import Financeiro.Ice.IContaCorrente;
import Financeiro.to.ContaCorrenteTo;
import java.util.List;
import org.hibernate.Session;

public class ContaCorrenteDao extends GenericDao implements IContaCorrente {

    private static final long serialVersionUID = 1L;
    private Session session;

    public ContaCorrenteDao(Session session) {
        this.session = session;
    }

    public ContaCorrenteDao() {
        this.session = getSession();
    }
    public List<ContaCorrenteTo> consultar() {
         return getPureList(ContaCorrenteTo.class, "from ContaCorrenteTo tipocc order by tipocc.descricao");
    }

    public List<ContaCorrenteTo> consultar_p(String desc_ContaCorrente) {
         return getPureList(ContaCorrenteTo.class, "from ContaCorrenteTo tipocc where tipocc.descricao like ? order by tipocc.descricao",desc_ContaCorrente);
    }
   public void limpar()
   {
   }


   public void salvar(ContaCorrenteTo contaCorrente)
   {
    savePojo(contaCorrente);
   }

    public ContaCorrenteTo consultar(int codContaCorrente) {
        ContaCorrenteTo codigoContaCorrente = getPojo(ContaCorrenteTo.class, codContaCorrente);
        return codigoContaCorrente;
    }

   public void excluir(ContaCorrenteTo contaCorrente)
   {
    removePojo(contaCorrente);
   }
    public String alterar(ContaCorrenteTo contaCorrente) {
        saveorUpdatePojo(contaCorrente);
        return contaCorrente.getDescricao();
    }

    public ContaCorrenteTo consultar(ContaCorrenteTo contaCorrente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}