package Financeiro.dao;

import Financeiro.Ice.IFilial;
import Financeiro.to.FilialTo;
import java.util.List;
import org.hibernate.Session;

/***********************************************************************
 * Module:  FilialDao.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class FilialDao
 ***********************************************************************/

public class FilialDao extends GenericDao implements IFilial
{
private static final long serialVersionUID = 1L;
    private Session session;

    public FilialDao(Session session) {
        this.session = session;
    }

    public FilialDao() {
        this.session = getSession();
    }
   public void limpar()
   {
      // TODO: implement
   }

   public int salvar(FilialTo filial)
   {
      savePojo(filial);
        return filial.getCodEmpresa();
   }

   public FilialTo consultar(String filial)
   {
      // TODO: implement
      return null;
   }
   public int alterar(FilialTo filial) {
        saveorUpdatePojo(filial);
        return filial.getCodEmpresa();
    }

    public FilialTo consultar(int codEmpresa) {
        FilialTo filial = getPojo(FilialTo.class, codEmpresa);
        return filial;
    }

    public List<FilialTo> consultar() {
        return getPureList(FilialTo.class, "from FilialTo fl order by fl.razaoSocial");
    }

    public List<FilialTo> consultar_p(String razaoSocial) {
        return getPureList(FilialTo.class, "from FilialTo fl where fl.razaoSocial like ? order by fl.razaoSocial", razaoSocial);
    }
   public List<FilialTo> consultar_cod(Integer codigo) {
        return getPureList(FilialTo.class, "from FilialTo fl where fl.codEmpresa = ? ", codigo);
    }
   public List<FilialTo> consultar_fant(String fantasia) {
        return getPureList(FilialTo.class, "from FilialTo fl where fl.nomeFantasia like ? order by fl.nomeFantasia", fantasia);
    }
   public List<FilialTo> consultar_cpfCnpj(String cnpj) {
        return getPureList(FilialTo.class, "from FilialTo fl where fl.cnpj = ? order by fl.razaoSocila", cnpj);
    }


   public void excluir(FilialTo filial)
   {
      removePojo(filial);
   }


}