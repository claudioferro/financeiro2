package Financeiro.bo;

import Financeiro.dao.EmpresaDao;
//import Financeiro.to.EmpresaTo;


import Financeiro.dao.BancosDao;
import Financeiro.to.BancosTo;
import Financeiro.dao.FormaPagamentoDao;
import Financeiro.to.FormaPagamentoTo;
import Financeiro.dao.CentroCustoDao;
import Financeiro.to.CentroCustoTo;
import Financeiro.dao.ContaCorrenteDao;
import Financeiro.to.ContaCorrenteTo;

import Financeiro.dao.ContasPagarReceberDao;
import Financeiro.dao.TipoDocumentoDao;
import Financeiro.dao.MovimentacaoFinanceiraDao;
import Financeiro.to.ContasPagarReceberTo;
import Financeiro.to.TipoDocumentoTo;
//import Financeiro.to.MovimentacaoFinanceiraTo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/***********************************************************************
 * Module:  FornecedorBo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FornecedorBo
 ***********************************************************************/
public class ContasPagarReceberBo {

    public boolean botaoSeleciona = false;
    public boolean rederConsultaData = false;
    public boolean rederConsulta = true;
    

    private ContasPagarReceberDao contasDao = new ContasPagarReceberDao();
    private ContasPagarReceberTo selectContasPagarReceber;
    private EmpresaDao empresaDao = new EmpresaDao();
    private TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao();
    private MovimentacaoFinanceiraDao movimentacaoFinanceiraDao = new MovimentacaoFinanceiraDao();
    private BancosDao bancosDao = new BancosDao();
    private FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao();
    private CentroCustoDao centroCustoDao = new CentroCustoDao();
    private ContaCorrenteDao contaCorrenteDao = new ContaCorrenteDao();
    private List<ContasPagarReceberTo> contasPagarReceber = null;
    private List<SelectItem> empresa;
    private List<SelectItem> tipoDocumento;
    private List<SelectItem> movimFinanceira;
    private List<SelectItem> bancos;
    private List<SelectItem> formaPagto;
    private List<SelectItem> CentroCusto;
    private List<SelectItem> contaCorrente;
    private ClienteBo clienteBo = new ClienteBo();
    private FornecedorBo fornecedorBo = new FornecedorBo();
    private String mensagem = "";
    private String status;
    private boolean alt_cod;
    private String valConsulta = "";
    private String tipoConsulta = "numDoc";
    private String tipo = "C";
    private boolean disabled = true;
    private String statusConta;
    private boolean rederLiquidacao;

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }

    public ContasPagarReceberBo() {
        ClienteBo cliente = new ClienteBo();
        cliente.limparCons();
        setRederLiquidacao(true);
    }

    public String setarTipoConsulta() {
        if (tipoConsulta.equals("data")) {
            setRederConsultaData(true);
            setRederConsulta(false);
        } else {
            setRederConsultaData(false);
            setRederConsulta(true);
        }
        return "";
    }

    public boolean isRederLiquidacao() {
        return rederLiquidacao;
    }

    public void setRederLiquidacao(boolean rederLiquidacao) {
        this.rederLiquidacao = rederLiquidacao;
    }

    public boolean isBotaoSeleciona() {
        return botaoSeleciona;
    }

    public void setBotaoSeleciona(boolean botaoSeleciona) {
        this.botaoSeleciona = botaoSeleciona;
    }

    public boolean isRederConsulta() {
        return rederConsulta;
    }

    public void setRederConsulta(boolean rederConsulta) {
        this.rederConsulta = rederConsulta;
    }

    public boolean isRederConsultaData() {
        return rederConsultaData;
    }

    public void setRederConsultaData(boolean rederConsultaData) {
        this.rederConsultaData = rederConsultaData;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public ContasPagarReceberTo getSelectContasPagarReceber() {
        return selectContasPagarReceber;
    }

    public void setSelectContasPagarReceber(ContasPagarReceberTo selectCtnPagarReceber) {
        this.selectContasPagarReceber = selectCtnPagarReceber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String limpar() {
        setSelectContasPagarReceber(new ContasPagarReceberTo());
        setBotaoSeleciona(false);
        setStatus("s");
        contasPagarReceber = null;
        setMensagem("");
        setDisabled(true);
        return "gotoContasPagarReceber";
    }

    public String addContas() {
        contasPagarReceber = null;
        selectContasPagarReceber = new ContasPagarReceberTo();

        fornecedorBo.setRederBotaoAlterar(false);

        setStatus("s");
        setMensagem("");
        return "gotoContasPagarReceber";
    }

    public String salvar() {
        //try{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String object = (String) session.getAttribute("codEmpresa");
        int codEmpresa = 0;
        try {
             codEmpresa = Integer.parseInt(object);
        } catch (Exception e) {
        }

        if (selectContasPagarReceber.getValorPago() > 0 && selectContasPagarReceber.getDataLiquidacao() == null) {
            setMensagem("Data de Liquidação obrigatória!");
            return "gotoContasPagarReceber";
        }

        // Se valor pago for igual ao valor da conta, então status ficará como Liquidado,
        // caso contrário fica com status Aberto.
        if (selectContasPagarReceber.getValor() == selectContasPagarReceber.getValorPago()) {
            selectContasPagarReceber.setStatus("L");
            setStatusConta("LIQUIDADO");
        } else {
            selectContasPagarReceber.setStatus("A");
            setStatusConta("ABERTO");
        }

        if (getStatus().equals("s")) {

            if (selectContasPagarReceber.getTipoConta().equals("")) {
                setMensagem("Campo Tipo de Conta obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getStatus().equals("Selecione")) {
                setMensagem("Campo Status obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getNumDocumento().equals("")) {
                setMensagem("Campo Número Documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getTipoDocumento().getCodTipoDocumento() == 0) {
                setMensagem("Campo Tipo documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getSituacaoDocumento().equals("")) {
                setMensagem("Campo Situação documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getValor() <= 0) {
                setMensagem("Campo Valor obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getCentroCusto().getCodCentroCusto() == 0) {
                setMensagem("Campo Centro de Custo obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (ValidaData.Nascimento(selectContasPagarReceber.getDataEmissao()) == false) {
                setMensagem("Data de Emissão inválida!");
                return "gotoContasPagarReceber";
            }

            if (selectContasPagarReceber.getClienteFornec() == null) {
                setMensagem("Campo Cliente/Fornecedor obrigatorio!");
                return "gotoContasPagarReceber";
            }

            
            selectContasPagarReceber.getEmpresa().setCodEmpresa(codEmpresa);
            contasDao.salvar(getSelectContasPagarReceber());
            limpar();
            setStatus("a");
            setMensagem("Registro incluido com sucesso!");
        } else {
            if (selectContasPagarReceber.getTipoConta().equals("")) {
                setMensagem("Campo Tipo de Conta obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getStatus().equals("Selecione")) {
                setMensagem("Campo Status obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getNumDocumento().equals("")) {
                setMensagem("Campo Número Documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getTipoDocumento().getCodTipoDocumento() == 0) {
                setMensagem("Campo Tipo documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getSituacaoDocumento().equals("")) {
                setMensagem("Campo Situação documento obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getValor() <= 0) {
                setMensagem("Campo Valor obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getCentroCusto().getCodCentroCusto() == 0) {
                setMensagem("Campo Centro de Custo obrigatorio!");
                return "gotoContasPagarReceber";
            }
            if (ValidaData.Nascimento(selectContasPagarReceber.getDataEmissao()) == false) {
                setMensagem("Data de Emissão inválida!");
                return "gotoContasPagarReceber";
            }
            if (selectContasPagarReceber.getClienteFornec().getCodCliente() == 0) {
                setMensagem("Campo Cliente/Fornecedor obrigatorio!");
                return "gotoContasPagarReceber";
            }

            selectContasPagarReceber.getEmpresa().setCodEmpresa(codEmpresa);
            contasDao.alterar(getSelectContasPagarReceber());
            limpar();
            setStatus("a");
            setMensagem("Registro alterado com sucesso!");
        }

        contasPagarReceber = null;
        return "gotoContasPagarReceber";
    /*}catch(Exception e){
    setMensagem("Ocorreu um erro interno no Servidor!");
    return "gotoContasPagarReceber";
    }*/
    }

    public String alterar() {
        contasDao.alterar(getSelectContasPagarReceber());
        //Limpar cache
        contasPagarReceber = null;
        return "gotoContasPagarReceber";
    }

    public String excluir() {
        //Validação efetuado por Tiago Portella
        if (selectContasPagarReceber.getNumDocumento().equals("")) {
            setMensagem("Informe um registro para a exclusão!");
            return "gotoContasPagarReceber";
        }

        contasDao.excluir(getSelectContasPagarReceber());
        setStatusConta("");
        
        //Limpar cache
        contasPagarReceber = null;
        limpar();
        setMensagem("Registro excluido com sucesso!");
        return "gotoContasPagarReceber";
    }

    public String consultar() {
        contasPagarReceber = null;
        valConsulta = null;
        return "cons_ContasPagarReceber";
    }

    public String limparCons() {
        contasPagarReceber = null;
        valConsulta = null;
        return "cons_ContasPagarReceber";
    }

    public String fechar() {
        setBotaoSeleciona(false);
        contasPagarReceber = null;
        return "gotoMain";
    }

    public String iniciaEditContas() {
        setRederLiquidacao(true);
        if (selectContasPagarReceber.getStatus().equals("L")) {
            setStatusConta("LIQUDADO");
        } else {
            setStatusConta("ABERTO");
        }

        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoContasPagarReceber";
    }

    public String consult_ContasPagarReceber() {
        contasPagarReceber = null;
        selectContasPagarReceber = new ContasPagarReceberTo();
        if (valConsulta.equals("")) {
            contasPagarReceber = contasDao.consultar();
        } else if (tipoConsulta.equals("numDoc") && !valConsulta.equals("")) {
            contasPagarReceber = contasDao.consultar_p(valConsulta);
        } else if (tipoConsulta.equals("cod") && !valConsulta.equals("")) {
            contasPagarReceber = contasDao.consultar_cod(Integer.parseInt(valConsulta));
        } else if (tipoConsulta.equals("valor") && !valConsulta.equals("")) {
            contasPagarReceber = contasDao.consultar_valor(Float.parseFloat(valConsulta));
        } else if (tipoConsulta.equals("clie") && !valConsulta.equals("")) {
            contasPagarReceber = contasDao.consultar_clie(valConsulta.toUpperCase() + "%");
        }


        //else if (tipoConsulta.equals("data") && !valConsulta.equals("")) {
        //    contasPagarReceber = contasDao.consultar_datavenc(valConsulta);
        //}

        return "cons_ContasPagarReceber";
    }

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta.toUpperCase();
    }

    public List<ContasPagarReceberTo> getContasPagarReceberTo() {
        return contasPagarReceber;
    }

    public boolean isAlt_cod() {
        return alt_cod;
    }

    public void setAlt_cod(boolean alt_cod) {
        this.alt_cod = alt_cod;
    }

    public List<SelectItem> getBancos() {
        return bancos;
    }

    public List<SelectItem> getContaCorrente() {
        return contaCorrente;
    }

    public List<ContasPagarReceberTo> getContasPagarReceber() {
        return contasPagarReceber;
    }

    public List<SelectItem> getEmpresa() {
        return empresa;
    }

    public List<SelectItem> getFormaPagto() {
        return formaPagto;
    }

    public List<SelectItem> getMovimFinanceira() {
        return movimFinanceira;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String consultarClienteFornecedor() {
        setBotaoSeleciona(true);

        if (getTipo().equals("C")) {
            ClienteBo cliente = new ClienteBo();
            cliente.setRenderedAlterar(false);
            clienteBo.consultar();
            return "cons_cliente";
        } else {
            fornecedorBo.setRederBotaoAlterar(false);
            fornecedorBo.consultar();
            return "cons_fornecedor";
        }
    }

    public List<SelectItem> getBancosSystem() {
        List<BancosTo> bancosTo = bancosDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(bancosTo.size());
        for (BancosTo banco : bancosTo) {
            toReturn.add(new SelectItem(banco, banco.getDescricaoBanco()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getFormaPagtoSystem() {
        List<FormaPagamentoTo> formaPagtoTo = formaPagamentoDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(formaPagtoTo.size());
        for (FormaPagamentoTo forma_Pagto : formaPagtoTo) {
            toReturn.add(new SelectItem(forma_Pagto, forma_Pagto.getDescricao()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getTipoDocumentoSystem() {
        List<TipoDocumentoTo> tipodocumentoto = tipoDocumentoDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(tipodocumentoto.size());
        for (TipoDocumentoTo tpdoc : tipodocumentoto) {
            toReturn.add(new SelectItem(tpdoc, tpdoc.getDescricao()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getCentroCustoSystem() {
        List<CentroCustoTo> centroCustoto = centroCustoDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(centroCustoto.size());
        for (CentroCustoTo centroCusto : centroCustoto) {
            toReturn.add(new SelectItem(centroCusto, centroCusto.getDescricaoCentroCusto()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getContaCorrenteSystem() {
        List<ContaCorrenteTo> contaCorrenteto = contaCorrenteDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(contaCorrenteto.size());
        for (ContaCorrenteTo contaCorr : contaCorrenteto) {
            toReturn.add(new SelectItem(contaCorr, contaCorr.getDescricao()));
        }// for end
        return toReturn;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String selecionaClienteFornecedor() {
        setBotaoSeleciona(false);
        return "gotoContasPagarReceber";
    }
}
