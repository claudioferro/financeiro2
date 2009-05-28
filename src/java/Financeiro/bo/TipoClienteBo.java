package Financeiro.bo;

import Financeiro.dao.TipoClienteDao;
import Financeiro.to.TipoClienteTo;
import java.util.List;

/**
 *
 * @author Hugo Fabrício
 */
public class TipoClienteBo {

    private TipoClienteDao tipoClienteDao = new TipoClienteDao();
    private List<TipoClienteTo> tipoClientes;
    private TipoClienteTo selectTipocliente;
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

    public TipoClienteBo() {
    }

    public String limpar() {
        setSelectTipocliente(new TipoClienteTo());
        selectTipocliente.setDescricao("");
        selectTipocliente.setDescricaoReduzida("");
        selectTipocliente.setCodTipoCliente(0);
        setStatus("s");
        tipoClientes = null;
        //setMensagem("");
        setDisabled(true);
        return "gotoCadTipocliente";
    }

    public String addtipo() {
        tipoClientes = null;
        selectTipocliente = new TipoClienteTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadTipocliente";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if (selectTipocliente.getDescricaoReduzida().equals("")) {
                    setMensagem("Campo tipo obrigatório!");
                    return "gotoCadTipocliente";
                }
                if (selectTipocliente.getDescricao().equals("")) {
                    setMensagem("Campo descrição obrigatório!");
                    return "gotoCadTipocliente";
                }
                //Validaçao efetuada por Tiago Portella
                if(tipoClienteDao.consultar_DescricaoReduzida(selectTipocliente.getDescricaoReduzida()).size() > 0){
                    setMensagem("Tipo de Cliente já cadastrado!");
                    return "gotoCadTipocliente";
                }
                tipoClienteDao.salvar(getSelectTipocliente());
                setStatus("s");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectTipocliente.getDescricaoReduzida().equals("")) {
                    setMensagem("Campo descrição reduzida obrigatório!");
                    return "gotoCadTipocliente";
                }
                if (selectTipocliente.getDescricao().equals("")) {
                    setMensagem("Campo descrição obrigatório!");
                    return "gotoCadTipocliente";
                }
                tipoClienteDao.alterar(getSelectTipocliente());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            tipoClientes = null;
            return "gotoCadTipocliente";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadTipocliente";
        }
    }

    public String excluir() {
        try{
            //Validação efetuada por Tiago Portella
            if(selectTipocliente.getCodTipoCliente() == null){
                setMensagem("Informe um registro para a exclusão!");
                return "gotoCadTipocliente";
            }
            tipoClienteDao.excluir(getSelectTipocliente());
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            tipoClientes = null;
            limpar();
            return "gotoCadTipocliente";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadTipocliente";
        }
    }

    public String fechar() {
        tipoClientes = null;
        return "gotoMain";
    }

    public String limparCons() {
        tipoClientes = null;
        valConsulta = null;
        return "cons_tipoCliente";
    }

    public String consult_TipoCliente() {
        tipoClientes = null;
        selectTipocliente = new TipoClienteTo();
        tipoClientes = tipoClienteDao.consultar_p(valConsulta.toUpperCase() + "%");
        // cidades = cidDao.consultar_p("%G");
        return "cons_tipoCliente";
    }

    public TipoClienteTo getSelectTipocliente() {
        return selectTipocliente;
    }

    public void setSelectTipocliente(TipoClienteTo selectTipocliente) {
        this.selectTipocliente = selectTipocliente;
    }

    public List<TipoClienteTo> getTipoClientes() {
        if (tipoClientes == null) {
            tipoClientes = tipoClienteDao.consultar();
        }
        return tipoClientes;
    }

    public List<TipoClienteTo> getTipoClientesTo() {
        return tipoClientes;

    }

    public void setTipoClientes(List<TipoClienteTo> tipoClientes) {
        this.tipoClientes = tipoClientes;
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

    public String consultar() {
        tipoClientes = null;
        return "cons_tipoCliente";
    }

    public String iniciaEditTipocliente() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadTipocliente";
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }
}
