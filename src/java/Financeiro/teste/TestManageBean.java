package Financeiro.teste;

import Financeiro.dao.CidadeDao;
import Financeiro.db.HibernateUtil;
import Financeiro.to.CidadeTo;
import java.util.List;

/**
 *
 * @author Hugo Fabrício
 */
public class TestManageBean {

    
    /** Creates a new instance of TestManageBean */
    public TestManageBean() {
    }

    public String doTeste() {
        System.out.println("See: " + HibernateUtil.getInstace().getSession().get(CidadeTo.class, "01"));
        return "refresh";
    }
   
  
   

   

   
}
