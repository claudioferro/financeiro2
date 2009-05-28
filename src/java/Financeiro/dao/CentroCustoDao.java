package Financeiro.dao;

import Financeiro.Ice.ICentroCusto;
import Financeiro.to.CentroCustoTo;
import java.util.List;
import org.hibernate.Session;


public class CentroCustoDao extends GenericDao implements ICentroCusto {

    private static final long serialVersionUID = 1L;
    private Session session;

    public CentroCustoDao(Session session) {
        this.session = session;
    }

    public CentroCustoDao() {
        this.session = getSession();
    }

     public List<CentroCustoTo> consultar() {
         return getPureList(CentroCustoTo.class, "from CentroCustoTo tipocc order by tipocc.descricaoCentroCusto");
    }

    public List<CentroCustoTo> consultar_p(String desc_CentroCusto) {
         return getPureList(CentroCustoTo.class, "from CentroCustoTo tipocc where tipocc.descricaoCentroCusto like ? order by tipocc.descricaoCentroCusto",desc_CentroCusto);
    }
    //Criado por Tiago Portella para validação
    public List<CentroCustoTo> consultar_Codigo(String cod_CentroCusto) {
         return getPureList(CentroCustoTo.class, "from CentroCustoTo tipocc where tipocc.codigoCentroCusto = ?",cod_CentroCusto);
    }

   public void limpar()
   {

   }
   
   public void salvar(CentroCustoTo centroCusto)
   {
    savePojo(centroCusto);
   }
   
    public CentroCustoTo consultar(int codCentroCusto) {
        CentroCustoTo codigoCentroCusto = getPojo(CentroCustoTo.class, codCentroCusto);
        return codigoCentroCusto;
    }
   
   public void excluir(CentroCustoTo centroCusto)
   {
    removePojo(centroCusto);
   }
    public String alterar(CentroCustoTo centroCusto) {
        saveorUpdatePojo(centroCusto);
        return centroCusto.getDescricaoCentroCusto();
    }

    public CentroCustoTo consultar(CentroCustoTo centroCusto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}