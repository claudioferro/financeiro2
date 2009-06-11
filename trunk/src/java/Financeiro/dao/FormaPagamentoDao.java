package Financeiro.dao;

import Financeiro.Ice.IFormaPagamento;
import Financeiro.to.FormaPagamentoTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  FormaPagamentoDao.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FormaPagamentoDao
 ***********************************************************************/

public class FormaPagamentoDao extends GenericDao implements IFormaPagamento
{
    private Session session;
    public FormaPagamentoDao(Session session){
        this.session = session;
    }
    public FormaPagamentoDao(){
        this.session = getSession();
    }

    public void limpar() {

    }

    public void salvar(FormaPagamentoTo formaPagamento) {
        savePojo(formaPagamento);
    }

    public void excluir(FormaPagamentoTo formaPagamento) {
        removePojo(formaPagamento);
    }

    public String alterar(FormaPagamentoTo formaPagamento) {
        saveorUpdatePojo(formaPagamento);
        return formaPagamento.getDescricao();
    }

//    public FormaPagamentoTo consultar(String descricao) {
//        FormaPagamentoTo formaPagamento = getPojo(FormaPagamentoTo.class, descricao);
//        return formaPagamento;
//    }

    public List<FormaPagamentoTo> consultarDesc(String descricao) {
        List<FormaPagamentoTo> formaPagamento = getPureList(FormaPagamentoTo.class, "from FormaPagamentoTo formapg where formapg.descricao = ?", descricao);
        return formaPagamento;
    }

    public List<FormaPagamentoTo> consultar() {
        return getPureList(FormaPagamentoTo.class, "from FormaPagamentoTo formapg order by formapg.descricao");
    }

    public List<FormaPagamentoTo> consultar_p(String desc_FormaPagto) {
        return getPureList(FormaPagamentoTo.class, "from FormaPagamentoTo formapg where formapg.descricao like ? order by formapg.codFormaPagamento", desc_FormaPagto);
    }

    public FormaPagamentoTo consultar(String formaPagamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}