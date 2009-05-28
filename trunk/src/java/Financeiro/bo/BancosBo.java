package Financeiro.bo;

import Financeiro.dao.BancosDao;
import Financeiro.to.BancosTo;
import java.util.List;

/***********************************************************************
 * Module:  BancosBo.java
 * Author:  Hugo Fabrício Gonçalves e Silva
 * Purpose: Defines the Class BancosBo
 ***********************************************************************/
public class BancosBo {

    private BancosDao bancoDao = new BancosDao();
    private List<BancosTo> bancos;
    private BancosTo selectBanco;
    private String status;
    private boolean alt_cod;
    private String mensagem = "";
    private String valConsulta = "";
    private boolean disabled = true;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public BancosBo() {
        System.out.println("Banco Criada");
    }

    public String limpar() {
        setSelectBanco(new BancosTo());
        selectBanco.setNumBanco("");
        selectBanco.setDescricaoBanco("");

        setStatus("s");
        bancos = null;
        setAlt_cod(false);
        setDisabled(true);
        return "gotoAddNewbanco";
    }

    public String addBanco() {
        bancos = null;
        selectBanco = new BancosTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadBanco";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if (selectBanco.getNumBanco().equals("")) {
                    setMensagem("Campo Número banco obrigatório!");
                    return "gotoCadBanco";
                }else if (selectBanco.getDescricaoBanco().equals("")) {
                    setMensagem("Campo Descrição obrigatório!");
                    return "gotoCadBanco";
                }
                //Validação efetuada por Tiago Portella
                if(bancoDao.consultar_Codigo(selectBanco.getNumBanco()).size() > 0){
                    setMensagem("Banco já cadastrado!");
                    return "gotoCadBanco";
                }
                setStatus("s");
                bancoDao.salvar(getSelectBanco());
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectBanco.getNumBanco().equals("")) {
                    setMensagem("Campo Número banco obrigatório!");
                    return "gotoCadBanco";
                }else if (selectBanco.getDescricaoBanco().equals("")) {
                    setMensagem("Campo Descrição obrigatório!");
                    return "gotoCadBanco";
                }
                bancoDao.alterar(getSelectBanco());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            bancos = null;
            return "gotoCadBanco";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadBanco";
        }
    }

    public List<BancosTo> getBancosTos() {
        if (getBancos() == null) {
            bancos = bancoDao.consultar();
        }
        return bancos;
    }

    public String fechar() {
        bancos = null;
        valConsulta = null;
        return "gotoMain";
    }

    public String limparCons() {
        bancos = null;
        valConsulta = null;
        return "cons_bancos";
    }

    public String consultar() {
        bancos = null;
        valConsulta = null;
        return "cons_bancos";
    }

    public String getBancosDesc() {
        bancos = null;
        selectBanco = new BancosTo();
        bancos = bancoDao.consultar_p(valConsulta.toUpperCase() + "%");
        
        return "cons_bancos";
    }

    public String iniciaEditBanco() {
        setStatus("a");
        setAlt_cod(true);
        setMensagem("");
        setDisabled(false);
        return "gotoCadBanco";
    }

    public String alterar() {
        bancoDao.alterar(getSelectBanco());
        //Limpar cache
        bancos = null;
        return "gotoCadBanco";
    }

    public String excluir() {
        try{
            //Validação efetuada por Tiago Portella
            if(selectBanco.getNumBanco().equals("")){
                setMensagem("Informe um registro para a exclusão!");
                return "gotoCadBanco";
            }
            bancoDao.excluir(getSelectBanco() );
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            bancos = null;
            limpar();
            return "gotoCadBanco";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadBanco";
        }
    }

    public boolean getAlt_cod() {
        return alt_cod;
    }

    public void setAlt_cod(boolean alt_cod) {
        this.alt_cod = alt_cod;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<BancosTo> getBancos() {
        return bancos;
    }

    public void setBancos(List<BancosTo> bancos) {
        this.bancos = bancos;
    }

    public BancosTo getSelectBanco() {
        return selectBanco;
    }

    public void setSelectBanco(BancosTo selectBanco) {
        this.selectBanco = selectBanco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }
}