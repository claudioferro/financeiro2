package Financeiro.bo;

import Financeiro.dao.CidadeDao;
import Financeiro.to.CidadeTo;
import java.util.List;

/**
 *
 * @author Hugo Fabrício
 */
public class CidadeBo {

    private CidadeDao cidDao = new CidadeDao();
    private List<CidadeTo> cidades;
    private CidadeTo selectCidade;
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

    public CidadeBo() {
        System.out.println("cidade Criada");
    }

    public String limpar() {
        setSelectCidade(new CidadeTo());
        selectCidade.setDescricao("");
        selectCidade.setUf("");
        selectCidade.setMunicipio("");
        setStatus("s");
        cidades = null;
        setAlt_cod(false);
        setDisabled(true);
        //setMensagem("");
        return "gotoAddNewCid";
    }

    public String addCid() {
        cidades = null;
        selectCidade = new CidadeTo();
        setStatus("s");
        setMensagem("");
        setDisabled(true);
        return "gotoCadCid";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if(cidDao.consultar_CodigoMunicipio(selectCidade.getMunicipio()).size() > 0){
                    setMensagem("Municipio já cadastrado com este Código");
                    return "gotoCadCid";
                }

                if(selectCidade.getMunicipio().equals("")){
                    setMensagem("Campo Código Cidade obrigatório!");
                    return "gotoCadCid";
                }else if (selectCidade.getUf().equals("")) {
                    setMensagem("Campo UF obrigatório!");
                    return "gotoCadCid";
                }else if (selectCidade.getDescricao().equals("")) {
                    setMensagem("Campo Nome obrigatório!");
                    return "gotoCadCid";
                }
                //Validação efetuada por Tiago Portella
                if(cidDao.consultar_Municipio(selectCidade.getDescricao(), selectCidade.getUf()).size() > 0){
                    setMensagem("Municipio já cadastrado para este UF!");
                    return "gotoCadCid";
                }

                setStatus("s");
                cidDao.salvar(getSelectCidade());
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectCidade.getUf().equals("")) {
                    setMensagem("Campo UF obrigatório!");
                    return "gotoCadCid";
                }else if (selectCidade.getDescricao().equals("")) {
                    setMensagem("Campo Descrição obrigatório!");
                    return "gotoCadCid";
                }
                cidDao.alterar(getSelectCidade());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            cidades = null;
            return "gotoListCid";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoListCid";
        }
    }

    public List<CidadeTo> getCidadeTos() {
        if (getCidades() == null) {
            cidades = cidDao.consultar();
            setDisabled(false);
        }
        return cidades;
    }

    public String fechar() {
        cidades = null;
        valConsulta = null;
        return "gotoMain";
    }

    public String limparCons() {
        cidades = null;
        valConsulta = null;
        setDisabled(true);
        return "cons_cidade";
    }

    public String consultar() {
        cidades = null;
        valConsulta = null;
        return "cons_cidade";
    }

    public String getCidadeDesc() {
        cidades = null;
        selectCidade = new CidadeTo();
        cidades = cidDao.consultar_p(valConsulta.toUpperCase() + "%");
        // cidades = cidDao.consultar_p("%G");
        return "cons_cidade";
    }

    public String iniciaEditCid() {
        setStatus("a");
        setAlt_cod(true);
        setMensagem("");
        setDisabled(false);
        return "gotoCadCid";
    }

    public String alterar() {
        cidDao.alterar(getSelectCidade());
        //Limpar cache
        cidades = null;
        return "gotoListCid";
    }

    public String excluir() {
        //Validação efetuada por Tiago Portella
        try{
            if(selectCidade.getDescricao().equals("")){
               setMensagem("Informe um registro para a exclusão!");
               return "gotoListCid";
            }
            cidDao.excluir(getSelectCidade());
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            cidades = null;
            limpar();
            return "gotoListCid";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!"+" Mensagem para suporte:"+e);
            return "gotoListCid";
        }
    }

    public CidadeTo getSelectCidade() {
        return selectCidade;
    }

    public void setSelectCidade(CidadeTo selectCidade) {
        this.selectCidade = selectCidade;
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

    public List<CidadeTo> getCidades() {
        return cidades;
    }

    public void setCidades(List<CidadeTo> cidades) {
        this.cidades = cidades;
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta.toUpperCase();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
