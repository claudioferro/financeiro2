package Financeiro.bo;

import Financeiro.dao.CidadeDao;
import Financeiro.dao.ClienteDao;
import Financeiro.dao.TipoClienteDao;
import Financeiro.to.CidadeTo;
import Financeiro.to.ClienteFornecTo;
import Financeiro.to.TipoClienteTo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hugo Fabrício
 */
public class ClienteBo {

    private List<ClienteFornecTo> clientes = null;
    private ClienteDao clienteDao = new ClienteDao();
    private ClienteFornecTo selectCliente;
    private TipoClienteDao tipoclDao = new TipoClienteDao();
    private CidadeDao cidadeDao = new CidadeDao();
    private List<SelectItem> cidades;
    private String mensagem = "";
    private String status;
    private String valConsulta = "";
    private String tipoConsulta = "nome";
    private String uf ="";
    private boolean disabled = true;
    private boolean renderedAlterar;

    public boolean isRenderedAlterar() {
        return renderedAlterar;
    }

    public void setRenderedAlterar(boolean renderedAlterar) {
        this.renderedAlterar = renderedAlterar;
    }    

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public ClienteBo() {
    }

    public String limpar() {
        setSelectCliente(new ClienteFornecTo());
        setStatus("s");
        clientes = null;
        //setMensagem("");
        setDisabled(true);
        return "gotoCadcliente";
    }

    public String addCl() {
        clientes = null;
        selectCliente = new ClienteFornecTo();
        setStatus("s");
        setMensagem("");
        setRenderedAlterar(true);
        return "gotoCadcliente";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("")){
                    setMensagem("Selecione uma Categoria!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCpfCnpj().equals("")){
                    setMensagem("Campo CPF/CNPJ obrigatório!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("F")){
                    if(ValidaCpf.validacpf(selectCliente.getCpfCnpj()) == false){
                        setMensagem("CPF inválido!");
                        return "gotoCadcliente";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("J")){
                    if(ValidaCnpj.validaCnpj(selectCliente.getCpfCnpj()) == false){
                        setMensagem("CNPJ inválido!");
                        return "gotoCadcliente";
                    }
                }

                if (selectCliente.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatorio!");
                    return "gotoCadcliente";
                }

                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("F") && !selectCliente.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia é apenas para pessoa Juridica!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                //if(ValidaData.Nascimento(selectCliente.getDataNascimento()) == false){
                //    setMensagem("Data de nascimneto é inválida");
                //    return "gotoCadcliente";
                //}
                //Validação efetuada por Tiago Portella

                Date dtHoje = new Date();
                selectCliente.setDataCadastro(dtHoje);

                if(selectCliente.getTipoCliente() == null){
                    setMensagem("Campo Tipo de Cliente obrigatório");
                    return "gotoCadcliente";
                }

                //Validação efetuada por Tiago Portella
                if(!selectCliente.getEmail().equals("")){
                    if(selectCliente.getEmail().indexOf("@") < 0){
                        setMensagem("Email inválido!");
                        return "gotoCadcliente";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(!selectCliente.getEmailAlternativo().equals("")){
                    if(selectCliente.getEmailAlternativo().indexOf("@") < 0){
                        setMensagem("Email Alternativo inválido!");
                        return "gotoCadcliente";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(clienteDao.consultar_cpfCnpj(selectCliente.getCpfCnpj()).size() > 0){
                    setMensagem("Cliente já existe!");
                    return "gotoCadcliente";
                }

                selectCliente.setTipoCadastro("C");
                clienteDao.salvar(getSelectCliente());
                setStatus("s");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if(selectCliente.getCategoria().equals("")){
                    setMensagem("Selecione uma Categoria!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCpfCnpj().equals("")){
                    setMensagem("Campo CPF/CNPJ obrigatório!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("F")){
                    if(ValidaCpf.validacpf(selectCliente.getCpfCnpj()) == false){
                        setMensagem("CPF inválido!");
                        return "gotoCadcliente";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("J")){
                    if(ValidaCnpj.validaCnpj(selectCliente.getCpfCnpj()) == false){
                        setMensagem("CNPJ inválido!");
                        return "gotoCadcliente";
                    }
                }

                if (selectCliente.getNome().equals("")) {
                    setMensagem("Campo Nome obrigatorio!");
                    return "gotoCadcliente";
                }

                //Validação efetuada por Tiago Portella
                if(selectCliente.getCategoria().equals("F") && !selectCliente.getNomeFantasia().equals("")){
                    setMensagem("Campo Nome Fantasia é apenas para pessoa Juridica!");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(ValidaData.Nascimento(selectCliente.getDataNascimento()) == false){
                    setMensagem("Data de nascimneto é inválida");
                    return "gotoCadcliente";
                }
                //Validação efetuada por Tiago Portella
                if(selectCliente.getTipoCliente() == null){
                    setMensagem("Campo Tipo de Cliente obrigatório");
                    return "gotoCadcliente";
                }

                //Validação efetuada por Tiago Portella
                if(!selectCliente.getEmail().equals("")){
                    if(selectCliente.getEmail().indexOf("@") < 0){
                        setMensagem("Email inválido!");
                        return "gotoCadcliente";
                    }
                }
                //Validação efetuada por Tiago Portella
                if(!selectCliente.getEmailAlternativo().equals("")){
                    if(selectCliente.getEmailAlternativo().indexOf("@") < 0){
                        setMensagem("Email Alternativo inválido!");
                        return "gotoCadcliente";
                    }
                }
                clienteDao.alterar(getSelectCliente());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            clientes = null;
            return "gotoCadcliente";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadcliente";
        }
    }

    public String alterar() {
        clienteDao.alterar(getSelectCliente());
        //Limpar cache
        clientes = null;
        return "";
    }

    public String excluir() {
        try{
            //Validação efetuada por Tiago Portella
            if(selectCliente.getCodCliente() == 0){
                setMensagem("Informe um registro para a exclusao");
                return "gotoCadcliente";
            }
            clienteDao.excluir(getSelectCliente());
            setMensagem("Registro excluido com sucesso!");
            clientes = null;
            limpar();
            return "";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "";
        }
    }

    public String fechar() {
        clientes = null;
        return "gotoMain";
    }

    public String iniciaEditCliente() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadcliente";
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<SelectItem> getTipoClienteSystem() {
        List<SelectItem> toReturn = new LinkedList<SelectItem>();

        for (TipoClienteTo tipoclienteto : tipoclDao.consultar()) {
            toReturn.add(new SelectItem(tipoclienteto, tipoclienteto.getDescricao()));
        }
        return toReturn;
    }

    public List<SelectItem> getCidadesSystem() {
        List<CidadeTo> cidadesto = cidadeDao.consultar_uf(getUf());
        List<SelectItem> toReturn = new ArrayList<SelectItem>(cidadesto.size());
        for (CidadeTo cid : cidadesto) {
            toReturn.add(new SelectItem(cid, cid.getDescricao()));
        }// for end
        return toReturn;
    }

//    public SelectItem[] getCidadesByUf(String estado) {
//        List<CidadeTo> cidadesto = cidadeDao.consultar_uf(estado);
//        List<SelectItem> itens = new ArrayList<SelectItem>(cidadesto.size());
//
//        for (CidadeTo cid : cidadesto) {
//            itens.add(new SelectItem(cid, cid.getDescricao()));
//        }// for end
//        return itens.toArray(new SelectItem[itens.size()]);
//    }

    public String actionCarregarCidade() {
        this.cidades = getCidadesSystem();
        return "SUCCESS";
    }

    public String consultar() {
        clientes = null;
        valConsulta = null;
        return "cons_cliente";
    }

    public String limparCons() {
        clientes = null;
        valConsulta = null;
        return "cons_cliente";
    }

    public String consult_Cliente() {
        clientes = null;
        selectCliente = new ClienteFornecTo();
        if (tipoConsulta.equals("nome")) {
            clientes = clienteDao.consultar_p(valConsulta.toUpperCase() + "%");
        } else if (tipoConsulta.equals("cod") && !valConsulta.equals("")) {
            clientes = clienteDao.consultar_cod(Integer.parseInt(valConsulta));
        } else if (tipoConsulta.equals("cpf")) {
            clientes = clienteDao.consultar_cpfCnpj(valConsulta.toUpperCase());

        } else {
            clientes = clienteDao.consultar_fant(valConsulta.toUpperCase() + "%");
        }

        return "cons_cons_cliente";
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }

    public List<ClienteFornecTo> getClientes() {
        if (clientes == null) {
            clientes = clienteDao.consultar();
        }
        return clientes;
    }

    public List<ClienteFornecTo> getClientesTo() {
        return clientes;

    }

    public void setClientes(List<ClienteFornecTo> clientes) {
        this.clientes = clientes;
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

    public ClienteFornecTo getSelectCliente() {
        return selectCliente;
    }

    public void setSelectCliente(ClienteFornecTo selectCliente) {
        this.selectCliente = selectCliente;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
