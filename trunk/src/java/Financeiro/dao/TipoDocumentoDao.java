package Financeiro.dao;

import Financeiro.Ice.ITipoDocumento;
import Financeiro.to.TipoDocumentoTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  FormaPagamentoDao.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FormaPagamentoDao
 ***********************************************************************/

public class TipoDocumentoDao extends GenericDao implements ITipoDocumento
{

    private Session session;
    public TipoDocumentoDao(Session session){
        this.session = session;
    }
    public TipoDocumentoDao(){
        this.session = getSession();
    }

    public void limpar() {

    }

    public void salvar(TipoDocumentoTo tipoDoc) {
        savePojo(tipoDoc);
    }

    public void excluir(TipoDocumentoTo tipoDoc) {
        removePojo(tipoDoc);
    }

    public String alterar(TipoDocumentoTo tipoDoc) {
        saveorUpdatePojo(tipoDoc);
        return tipoDoc.getDescricao();
    }

    public TipoDocumentoTo consultar(String descricao) {
        TipoDocumentoTo tipoDoc = getPojo(TipoDocumentoTo.class, descricao);
        return tipoDoc;
    }

    public List<TipoDocumentoTo> consultarDesc(String descricao) {
        List<TipoDocumentoTo> tipoDoc = getPureList(TipoDocumentoTo.class, "from TipoDocumentoTo tipoDoc where tipoDoc.descricao = ?", descricao);
        return tipoDoc;
    }

    public List<TipoDocumentoTo> consultar() {
        return getPureList(TipoDocumentoTo.class, "from TipoDocumentoTo tipodoc order by tipodoc.descricao");
    }

    public List<TipoDocumentoTo> consultar_p(String desc_TipoDoc) {
        return getPureList(TipoDocumentoTo.class, "from TipoDocumentoTo tipodoc where tipodoc.descricao like ? order by tipodoc.codTipoDocumento", desc_TipoDoc);
    }

    public TipoDocumentoTo consultar(int tipoDocumento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TipoDocumentoTo> consultar_tpdoc() {
        return getPureList(TipoDocumentoTo.class, "from TipoDocumentoTo tipodoc order by tipodoc.descricao");
    }

}
