package Financeiro.bo;

import Financeiro.dao.CentroCustoDao;
import Financeiro.to.CentroCustoTo;
import java.util.List;

public class CentroCustoBo {

    private CentroCustoDao centroCustoDao = new CentroCustoDao();
    private List<CentroCustoTo> centroCustos;
    private CentroCustoTo selectcentroCusto;
    private String valConsulta = "";
    private String status;
    private String mensagem = "";
    private boolean disabled = true;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public CentroCustoBo() {
    }

    public String limpar() {
        setSelectcentroCusto(new CentroCustoTo());
        selectcentroCusto.setDescricaoCentroCusto("");
        selectcentroCusto.setCodigoCentroCusto("");
        selectcentroCusto.setCodCentroCusto(0);
        setStatus("s");
        centroCustos = null;
        //setMensagem("");
        setDisabled(true);
        return "gotoCadCentrocusto";
    }

    public String addCentroCusto() {
        centroCustos = null;
        selectcentroCusto = new CentroCustoTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadCentrocusto";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if (selectcentroCusto.getDescricaoCentroCusto().equals("")) {
                    setMensagem("Campo descrição obrigatório!");
                    return "gotoCadCentrocusto";
                }
                //Validação efetuada por Tiago Portella
                else if (selectcentroCusto.getCodigoCentroCusto().equals("")){
                    setMensagem("Campo código centro de custo obrigatório");
                    return "gotoCadCentrocusto";
                }
                //Validação efetuada por Tiago Portella
                if(centroCustoDao.consultar_Codigo(selectcentroCusto.getCodigoCentroCusto()).size() > 0){
                    setMensagem("Centro de Custo já cadastrado!");
                    return "gotoCadCentrocusto";
                }
                centroCustoDao.salvar(getSelectcentroCusto());
                setStatus("s");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectcentroCusto.getDescricaoCentroCusto().equals("")) {
                    setMensagem("Campo descrição obrigatório!");
                    return "gotoCadCentrocusto";
                }
                //Validação efetuada por Tiago Portella
                else if (selectcentroCusto.getCodigoCentroCusto().equals("")){
                    setMensagem("Campo código centro de custo obrigatório");
                    return "gotoCadCentrocusto";
                }
                centroCustoDao.alterar(getSelectcentroCusto());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            centroCustos = null;
            return "gotoCadCentrocusto";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadCentrocusto";
        }
    }

    public List<CentroCustoTo> getCentroCustos() {
        return centroCustos;
    }

    public void setCentroCustos(List<CentroCustoTo> centroCustos) {
        this.centroCustos = centroCustos;
    }

    public CentroCustoTo getSelectcentroCusto() {
        return selectcentroCusto;
    }

    public void setSelectcentroCusto(CentroCustoTo selectcentroCusto) {
        this.selectcentroCusto = selectcentroCusto;
    }

    public String excluir() {
        try{
            //Validação efetuada por Tiago Portella
            if(selectcentroCusto.getCodigoCentroCusto().equals("")){
                setMensagem("Informe um registro para a exclusão!");
                return "gotoCadCentrocusto";
            }
            centroCustoDao.excluir(getSelectcentroCusto());
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            centroCustos = null;
            limpar();
            return "gotoCadCentrocusto";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadCentrocusto";
        }
    }

    public String fechar() {
        centroCustos = null;
        return "gotoMain";
    }

    public String limparCons() {
        centroCustos = null;
        valConsulta = null;
        return "cons_centroCusto";
    }

    public String consult_CentroCusto() {
        centroCustos = null;
        selectcentroCusto = new CentroCustoTo();
        centroCustos = centroCustoDao.consultar_p(valConsulta.toUpperCase() + "%");
        // cidades = cidDao.consultar_p("%G");
        return "cons_centroCusto";
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CentroCustoTo> getCentroCustoTos() {
        if (centroCustos == null) {
            centroCustos = centroCustoDao.consultar();
        }
        return centroCustos;
    }

    public List<CentroCustoTo> getCentroCustoTo() {
        return centroCustos;

    }

    public void setCentroCusto(List<CentroCustoTo> centroCustos) {
        this.centroCustos = centroCustos;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public String consultar() {
        centroCustos = null;
        return "cons_centroCusto";
    }

    public String iniciaEditCentroCusto() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadCentrocusto";
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }
}