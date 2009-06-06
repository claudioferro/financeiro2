package Financeiro.dao;

import Financeiro.Ice.IMovimentacaoFinanceira;
import Financeiro.to.MovimentacaoFinanceiraTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  MovimentacaoFinanceiraDao.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class MovimentacaoFinanceiraDao
 ***********************************************************************/
public class MovimentacaoFinanceiraDao extends GenericDao implements IMovimentacaoFinanceira {

    private static final long serialVersionUID = 1L;
    private Session session;

    public MovimentacaoFinanceiraDao(Session session) {
        this.session = session;
    }

    public MovimentacaoFinanceiraDao() {
        this.session = getSession();
    }

    public void limpar() {
    }

    public void salvar(MovimentacaoFinanceiraTo movimentacaoFinanceira) {
        savePojo(movimentacaoFinanceira);
    }

    public MovimentacaoFinanceiraTo consultar(String movimentacaoFinanceira) {
        return null;
    }

    public List<MovimentacaoFinanceiraTo> consultar(Integer codempresa) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.empresa.codEmpresa = ? order by mov.codMovimentacaoFinanceira",codempresa);
    }

    public List<MovimentacaoFinanceiraTo> consultar_cod(Integer codigo,Integer codempresa) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.codMovimentacaoFinanceira = ? and mov.empresa.codEmpresa = ?  ", codigo,codempresa);
    }
    public List<MovimentacaoFinanceiraTo> consultar_valor(Double valor,Integer codempresa) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.valorLancamento = ? and mov.empresa.codEmpresa = ?", valor,codempresa);
    }
     public List<MovimentacaoFinanceiraTo> consultar_nome(String nome,Integer codempresa) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.clienteFornecedor.nome like ? and mov.empresa.codEmpresa = ?", nome,codempresa);
    }
    public void alterar(MovimentacaoFinanceiraTo movimentacaoFinanceira)
    {
        saveorUpdatePojo(movimentacaoFinanceira);
    }
    public void excluir(MovimentacaoFinanceiraTo movimentacaoFinanceira) {
        removePojo(movimentacaoFinanceira);
    }
}