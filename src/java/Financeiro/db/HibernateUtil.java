package Financeiro.db;

import Financeiro.to.BancosTo;
import Financeiro.to.CentroCustoTo;
import Financeiro.to.CidadeTo;
import Financeiro.to.ClienteFornecTo;
import Financeiro.to.ContaCorrenteTo;import Financeiro.to.EmpresaTo;
import Financeiro.to.FilialTo;
import Financeiro.to.FormaPagamentoTo;

import Financeiro.to.MovimentacaoFinanceiraTo;
import Financeiro.to.TipoClienteTo;
import Financeiro.to.ContasPagarReceberTo;
import Financeiro.to.TipoDocumentoTo;
import Financeiro.to.UsuarioTo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hugo Fabrício
 */
public class HibernateUtil {

    private static final long serialVersionUID = 1L;
    private static HibernateUtil me;
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new AnnotationConfiguration()
                .setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.connection.driver.class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url","jdbc:postgresql://127.0.0.1:5432/siscom_db")
                .setProperty("hibernate.connection.username", "admin")
                .setProperty("hibernate.connection.password", "12345")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty("hibernate.c3p0.acquire_increment", "1")
                .setProperty("hibernate.c3p0.idle_test_period", "100")
                .setProperty("hibernate.c3p0.max_size", "10")
                .setProperty("hibernate.c3p0.max_statements", "0")
                .setProperty("hibernate.c3p0.min_size", "5")
                .setProperty("hibernate.c3p0.time_out", "100")
                .addAnnotatedClass(CidadeTo.class)
                .addAnnotatedClass(ClienteFornecTo.class)
                .addAnnotatedClass(TipoClienteTo.class)
                .addAnnotatedClass(BancosTo.class)
                .addAnnotatedClass(CentroCustoTo.class)
                .addAnnotatedClass(FormaPagamentoTo.class)
                .addAnnotatedClass(EmpresaTo.class)
                .addAnnotatedClass(ContaCorrenteTo.class)
                .addAnnotatedClass(FilialTo.class)
                .addAnnotatedClass(MovimentacaoFinanceiraTo.class)
                .addAnnotatedClass(ContasPagarReceberTo.class)
                .addAnnotatedClass(TipoDocumentoTo.class)
                .addAnnotatedClass(UsuarioTo.class)
                .buildSessionFactory();

    }
    public Session getSession(){
        Session toReturn = sessionFactory.openSession();
        toReturn.beginTransaction();
        return toReturn;
    }
    public static  HibernateUtil getInstace() {
        if (me == null) {
            me = new HibernateUtil();
        }
        return me;
    }
}
