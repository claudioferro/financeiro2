package Financeiro.dao;

import Financeiro.Ice.ICidade;
import Financeiro.to.CidadeTo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Hugo Fabrício
 */
public class CidadeDao extends GenericDao implements ICidade {

    private static final long serialVersionUID = 1L;
    private Session session;

    public CidadeDao(Session session) {
        this.session = session;
    }

    public CidadeDao() {
        this.session = getSession();
    }

    public void limpar() {
        // TODO: implement
    }

    public String salvar(CidadeTo cidade) {
        saveorUpdatePojo(cidade);
        return cidade.getMunicipio();
    }

    public void excluir(CidadeTo cidade) {
        removePojo(cidade);
    }

    public String alterar(CidadeTo cidade) {
        saveorUpdatePojo(cidade);
        return cidade.getMunicipio();
    }

    public CidadeTo consultar(String municipio) {
        CidadeTo cidade = getPojo(CidadeTo.class, municipio);
        return cidade;
    }

    public List<CidadeTo> consultar() {
        return getPureList(CidadeTo.class, "from CidadeTo cid order by cid.descricao");
    }

    public List<CidadeTo> consultar_p(String desc_Cidade) {
        return getPureList(CidadeTo.class, "from CidadeTo cid where cid.descricao like ? order by cid.municipio", desc_Cidade);
    }
    //Criado por Tiago Portella para validação
    public List<CidadeTo> consultar_Municipio(String municipio_Cidade, String uf_Cidade) {
        return getPureList(CidadeTo.class, "from CidadeTo cid where cid.descricao = ? and cid.uf = ?", municipio_Cidade, uf_Cidade);
    }

    public List<CidadeTo> consultar_CodigoMunicipio(String cod_Cidade) {
        return getPureList(CidadeTo.class, "from CidadeTo cid where cid.municipio = ?", cod_Cidade);
    }

     public List<CidadeTo> consultar_uf(String uf) {
        return getPureList(CidadeTo.class, "from CidadeTo cid where cid.uf = ? order by cid.municipio", uf);
    }
}
