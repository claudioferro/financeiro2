package Financeiro.bo;

import Financeiro.dao.CidadeDao;
import Financeiro.to.CidadeTo;
import Financeiro.dao.FornecedorDao;
import Financeiro.to.ClienteFornecTo;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.faces.model.SelectItem;


/***********************************************************************
 * Module:  FornecedorBo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FornecedorBo
 ***********************************************************************/
public class FornecedorBo {

    private List<ClienteFornecTo> fornecedor = null;
    private FornecedorDao fornecDao = new FornecedorDao();
    private ClienteFornecTo selectFornecedor;
    private CidadeDao cidadeDao = new CidadeDao();
    private List<SelectItem> cidades;
    private String mensagem = "";
    private String status;
    private boolean alt_cod;
    private String valConsulta = "";
    private String tipoConsulta = "nome";
    private String uf = "";
    private boolean disabled = true;
    public boolean rederBotaoAlterar;

    public FornecedorBo() {
    }

    public boolean isRederBotaoAlterar() {
        return rederBotaoAlterar;
    }

    public void setRederBotaoAlterar(boolean rederBotaoAlterar) {
        this.rederBotaoAlterar = rederBotaoAlterar;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String limpar() {
        setSelectFornecedor(new ClienteFornecTo());
        setStatus("s");
        fornecedor = null;
        setMensagem("");
        setDisabled(true);
        return "gotoFornecedor";
    }

    public String addFornecedor() {
        fornecedor = null;
        selectFornecedor = new ClienteFornecTo();
        setStatus("s");
        setMensagem("");
        setRederBotaoAlterar(true);
        return "gotoFornecedor";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("")){
                    setMensagem("Selecione uma categoria!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCpfCnpj().equals("")){
                    setMensagem("Campo CPF/CNPJ obrigatório!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("F")){
                    if(ValidaCpf.validacpf(selectFornecedor.getCpfCnpj()) == false){
                        setMensagem("CPF inválido!");
                        return "gotoFornecedor";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("J")){
                    if(ValidaCnpj.validaCnpj(selectFornecedor.getCpfCnpj()) == false){
                        setMensagem("CNPJ inválido!");
                        return "gotoFornecedor";
                    }
                }

                if (selectFornecedor.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatorio!");
                    return "gotoFornecedor";
                }

                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("F") && !selectFornecedor.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia é apenas para pessoa Juridica!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                Date dtHoje = new Date();
                selectFornecedor.setDataCadastro(dtHoje);


                /*if(ValidaData.Nascimento(selectFornecedor.getDataCadastro()) == false){
                    setMensagem("Data do cadastro é inválida");
                    return "gotoFornecedor";
                }*/

                //Validação efetuada por Tiago Portella
                if(!selectFornecedor.getEmail().equals("")){
                    if(selectFornecedor.getEmail().indexOf("@") < 0){
                        setMensagem("Email inválido!");
                        return "gotoFornecedor";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(!selectFornecedor.getEmailAlternativo().equals("")){
                    if(selectFornecedor.getEmailAlternativo().indexOf("@") < 0){
                        setMensagem("Email Alternativo inválido!");
                        return "gotoFornecedor";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(fornecDao.consultar_cpfCnpj(selectFornecedor.getCpfCnpj()).size() > 0){
                    setMensagem("Fornecedor já existe!");
                    return "gotoFornecedor";
                }

                selectFornecedor.setTipoCadastro("F");
                fornecDao.salvar(getSelectFornecedor());
                setStatus("s");
                limpar();
                setMensagem("Registro incluido com sucesso!");
            } else {
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("")){
                    setMensagem("Selecione uma categoria!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCpfCnpj().equals("")){
                    setMensagem("Campo CPF/CNPJ obrigatório!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("F")){
                    if(ValidaCpf.validacpf(selectFornecedor.getCpfCnpj()) == false){
                        setMensagem("CPF inválido!");
                        return "gotoFornecedor";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("J")){
                    if(ValidaCnpj.validaCnpj(selectFornecedor.getCpfCnpj()) == false){
                        setMensagem("CNPJ inválido!");
                        return "gotoFornecedor";
                    }
                }

                if (selectFornecedor.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatorio!");
                    return "gotoFornecedor";
                }

                //Validação efetuada por Tiago Portella
                if(selectFornecedor.getCategoria().equals("F") && !selectFornecedor.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia é apenas para pessoa Juridica!");
                    return "gotoFornecedor";
                }
                //Validação efetuada por Tiago Portella
                /*if(ValidaData.Nascimento(selectFornecedor.getDataCadastro()) == false){
                    setMensagem("Data do cadastro é inválida");
                    return "gotoFornecedor";
                }*/

                //Validação efetuada por Tiago Portella
                if(!selectFornecedor.getEmail().equals("")){
                    if(selectFornecedor.getEmail().indexOf("@") < 0){
                        setMensagem("Email inválido!");
                        return "gotoFornecedor";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(!selectFornecedor.getEmailAlternativo().equals("")){
                    if(selectFornecedor.getEmailAlternativo().indexOf("@") < 0){
                        setMensagem("Email Alternativo inválido!");
                        return "gotoFornecedor";
                    }
                }

                fornecDao.alterar(getSelectFornecedor());
                setStatus("a");
                limpar();
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            fornecedor = null;
            return "gotoFornecedor";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoFornecedor";
        }
    }

    public String alterar() {
        fornecDao.alterar(getSelectFornecedor());
        //Limpar cache
        fornecedor = null;
        return "gotoFornecedor";
    }

    public String excluir() {
        try{
            //Validação efetuado por Tiago Portella
            if(selectFornecedor.getCpfCnpj().equals("")){
                setMensagem("Informe um registro para a exclusão!");
                return "gotoFornecedor";
            }

            fornecDao.excluir(getSelectFornecedor());
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            fornecedor = null;
            limpar();
            return "gotoFornecedor";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoFornecedor";
        }
    }

    public String consultar() {
        fornecedor = null;
        valConsulta = null;
        return "cons_fornecedor";
    }

    public String limparCons() {
        fornecedor = null;
        valConsulta = null;
        return "cons_fornecedor";
    }

    public String fechar() {
        fornecedor = null;
        return "gotoMain";
    }

    public String iniciaEditFornecedor() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoFornecedor";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public String consult_Fornecedor() {
        fornecedor = null;
        selectFornecedor = new ClienteFornecTo();
        if (tipoConsulta.equals("nome")) {
            fornecedor = fornecDao.consultar_p(valConsulta.toUpperCase() + "%");
        } else if (tipoConsulta.equals("cod") && !valConsulta.equals("")) {
            fornecedor = fornecDao.consultar_cod(Integer.parseInt(valConsulta));
        } else if (tipoConsulta.equals("cpf")) {
            fornecedor = fornecDao.consultar_cpfCnpj(valConsulta.toUpperCase());

        } else {
            fornecedor = fornecDao.consultar_fant(valConsulta.toUpperCase() + "%");
        }

        return "cons_fornecedor";
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta.toUpperCase();
    }

    public List<ClienteFornecTo> getFornecedorTo() {
        return fornecedor;
    }

    public void setFornecedor(List<ClienteFornecTo> fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClienteFornecTo getSelectFornecedor() {
        return selectFornecedor;
    }

    public void setSelectFornecedor(ClienteFornecTo selectFornecedor) {
        this.selectFornecedor = selectFornecedor;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}