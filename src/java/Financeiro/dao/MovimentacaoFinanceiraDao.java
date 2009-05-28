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

    public List<MovimentacaoFinanceiraTo> consultar() {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov order by mov.codMovimentacaoFinanceira");
    }

    public List<MovimentacaoFinanceiraTo> consultar_cod(Integer codigo) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.codMovimentacaoFinanceira = ? ", codigo);
    }
    public List<MovimentacaoFinanceiraTo> consultar_valor(Double valor) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.valorLancamento = ? ", valor);
    }
     public List<MovimentacaoFinanceiraTo> consultar_nome(String nome) {
        return getPureList(MovimentacaoFinanceiraTo.class, "from MovimentacaoFinanceiraTo mov where mov.clienteFornecedor.nome like ? ", nome);
    }
    public void alterar(MovimentacaoFinanceiraTo movimentacaoFinanceira)
    {
        saveorUpdatePojo(movimentacaoFinanceira);
    }
    public void excluir(MovimentacaoFinanceiraTo movimentacaoFinanceira) {
        removePojo(movimentacaoFinanceira);
    }
}