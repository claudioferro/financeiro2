package Financeiro.bo;

import Financeiro.dao.CidadeDao;
import Financeiro.dao.FilialDao;
import Financeiro.to.CidadeTo;
import Financeiro.to.FilialTo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/***********************************************************************
 * Module:  EmpresaBo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class EmpresaBo
 ***********************************************************************/
public class EmpresaBo {

    private List<FilialTo> filiais = null;
    private FilialDao filialDao = new FilialDao();
    private FilialTo selectFilial;
    private CidadeDao cidadeDao = new CidadeDao();
    private List<SelectItem> cidades;
    private String mensagem = "";
    private String status;
    private String valConsulta = "";
    private String tipoConsulta = "nome";
    private String uf = "";
    private boolean disabled = true;

    public EmpresaBo() {
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String limpar() {
        setSelectFilial(new FilialTo());
        setStatus("s");
        filiais = null;
        //setMensagem("");
        setDisabled(true);
        return "gotoCadempresa";
    }

    public String addFilial() {
        filiais = null;
        selectFilial = new FilialTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadempresa";
    }
     public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if(ValidaCnpj.validaCnpj(selectFilial.getCnpj()) == false){
                    setMensagem("Cnpj inválido!");
                    return "gotoCadempresa";
                }
                if (selectFilial.getRazaoSocial().equals("")) {
                    setMensagem("Campo Razão Social obrigatorio!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getRamoAtividade().equals("")){
                    setMensagem("Campo Ramo de Atividade obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getCidade().getMunicipio().equals("Selecione")){
                    setMensagem("Campo Cidade obrigatório!");
                    return "gotoCadempresa";
                }
                if(!selectFilial.getEmail().equals("")){
                    if(selectFilial.getEmail().indexOf('@') == -1){
                        setMensagem("Formato de Email inválido!");
                        return "gotoCadempresa";
                    }
                }
                if(selectFilial.getContato().equals("")){
                    setMensagem("Campo Contato obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getRegistroJuntaComercial().equals("")){
                    setMensagem("Campo Reg. Junta Comercial obrigatório!");
                    return "gotoCadempresa";
                }
                filialDao.salvar(getSelectFilial());
                setStatus("a");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if(ValidaCnpj.validaCnpj(selectFilial.getCnpj()) == false){
                    setMensagem("Cnpj inválido!");
                    return "gotoCadempresa";
                }
                if (selectFilial.getRazaoSocial().equals("")) {
                    setMensagem("Campo Razão Social obrigatorio!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getRamoAtividade().equals("")){
                    setMensagem("Campo Ramo de Atividade obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getCidade().getMunicipio().equals("Selecione")){
                    setMensagem("Campo Cidade obrigatório!");
                    return "gotoCadempresa";
                }
                if(!selectFilial.getEmail().equals("")){
                    if(selectFilial.getEmail().indexOf('@') == -1){
                        setMensagem("Formato de Email inválido!");
                        return "gotoCadempresa";
                    }
                }
                if(selectFilial.getContato().equals("")){
                    setMensagem("Campo Contato obrigatório!");
                    return "gotoCadempresa";
                }
                if(selectFilial.getRegistroJuntaComercial().equals("")){
                    setMensagem("Campo Reg. Junta Comercial obrigatório!");
                    return "gotoCadempresa";
                }
                filialDao.alterar(getSelectFilial());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            filiais = null;
            return "gotoCadempresa";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadempresa";
        }
    }

    public String alterar() {
        filialDao.alterar(getSelectFilial());
        //Limpar cache
        filiais= null;
        return "";
    }

    public void excluir() {
        try{
            filialDao.excluir(getSelectFilial());
            setMensagem("Registro excluido com sucesso!");
            filiais = null;
            limpar();
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
        }
    }

    public String fechar() {
        filiais = null;
        return "gotoMain";
    }

    public String iniciaEditEmpresa() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadempresa";
    }
    public List<SelectItem> getCidadesSystem() {
        List<CidadeTo> cidadesto = cidadeDao.consultar_uf(getUf());
        List<SelectItem> toReturn = new ArrayList<SelectItem>(cidadesto.size());
        for (CidadeTo cid : cidadesto) {
            toReturn.add(new SelectItem(cid, cid.getDescricao()));
        }// for end
        return toReturn;
    }
     public String actionCarregarCidade() {
        this.cidades = getCidadesSystem();
        return "SUCCESS";
    }
   public String consultar() {
        filiais = null;
        valConsulta = null;
        return "cons_filial";
    }

    public String limparCons() {
        filiais = null;
        valConsulta = null;
        return "cons_filial";
    }
 public String consult_Empresa() {
        filiais = null;
        selectFilial = new FilialTo();
        if (tipoConsulta.equals("nome")) {
            filiais = filialDao.consultar_p(valConsulta.toUpperCase() + "%");
        } else if (tipoConsulta.equals("cod") && !valConsulta.equals("")) {
            filiais = filialDao.consultar_cod(Integer.parseInt(valConsulta));
        } else if (tipoConsulta.equals("cnpj")) {
            filiais = filialDao.consultar_cpfCnpj(valConsulta.toUpperCase());

        } else {
            filiais = filialDao.consultar_fant(valConsulta.toUpperCase() + "%");
        }

        return "cons_cons_filial";
    }
    public List<FilialTo> getFiliais() {
       if (filiais == null) {
            filiais = filialDao.consultar();
        }
        return filiais;
    }
     public List<FilialTo> getFiliaisTo() {
        return filiais;
    }


    public void setFiliais(List<FilialTo> filiais) {
        this.filiais = filiais;
    }

    public FilialTo getSelectFilial() {
        return selectFilial;
    }

    public void setSelectFilial(FilialTo selectFilial) {
        this.selectFilial = selectFilial;
    }

    

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }
}