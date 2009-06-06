package Financeiro.bo;

import Financeiro.dao.BancosDao;
import Financeiro.dao.CentroCustoDao;
import Financeiro.dao.ContaCorrenteDao;
import Financeiro.dao.MovimentacaoFinanceiraDao;
import Financeiro.to.BancosTo;
import Financeiro.to.CentroCustoTo;
import Financeiro.to.ContaCorrenteTo;
import Financeiro.to.MovimentacaoFinanceiraTo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/***********************************************************************
 * Module:  MovimentacaoFinanceiraBo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class MovimentacaoFinanceiraBo
 ***********************************************************************/
public class MovimentacaoFinanceiraBo {

    private List<MovimentacaoFinanceiraTo> movFinanceiras = null;
    private MovimentacaoFinanceiraDao movFinanceiraDao = new MovimentacaoFinanceiraDao();
    private MovimentacaoFinanceiraTo selectMovFinanceira;
    private CentroCustoDao centroCustoDao = new CentroCustoDao();
    private ContaCorrenteDao contaCorrenteDao = new ContaCorrenteDao();
    private BancosDao bancoDao = new BancosDao();
    private ClienteBo clienteBo = new ClienteBo();
    private FornecedorBo fornecedorBo = new FornecedorBo();
    private String mensagem = "";
    private String status;
    private String valConsulta = "";
    private String tipoConsulta = "cod";
    private String tipo = "C";
    private boolean disabled = true;
    private boolean renderedSeleciona = false;
    public boolean botaoSeleciona = false;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    String object = (String) session.getAttribute("codEmpresa");
    int codEmpresa = Integer.parseInt(object);

    public boolean isRenderedSeleciona() {
        return renderedSeleciona;
    }

    public void setRenderedSeleciona(boolean renderedSeleciona) {
        this.renderedSeleciona = renderedSeleciona;
    }

    public MovimentacaoFinanceiraBo() {
    }

    public boolean isBotaoSeleciona() {
        return botaoSeleciona;
    }

    public void setBotaoSeleciona(boolean botaoSeleciona) {
        this.botaoSeleciona = botaoSeleciona;
    }

    public String limpar() {
        setSelectMovFinanceira(new MovimentacaoFinanceiraTo());
        setBotaoSeleciona(false);
        setStatus("s");
        setDisabled(true);
        movFinanceiras = null;
        setMensagem("");
        return "gotoCadMovFinanceira";
    }

    public String addMovFinanceira() {
        movFinanceiras = null;
        selectMovFinanceira = new MovimentacaoFinanceiraTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadMovFinanceira";
    }

    public String salvar() {
       // try {

            if (getStatus().equals("s")) {
                if (selectMovFinanceira.getOperacao().equals("")) {
                    setMensagem("Campo Operação obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getBanco().getNumBanco().equals("")) {
                    setMensagem("Campo Banco obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (ValidaData.Nascimento(selectMovFinanceira.getDataLancamento()) == false) {
                    setMensagem("Data de Lançamento inválida!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getValorLancamento() <= 0) {
                    setMensagem("Campo Valor obrigatorio e deve ser maior que 0(zero)!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getContaCorrente().getCodContaCorrente() == 0) {
                    setMensagem("Campo Conta Corrente obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getCentroCusto().getCodCentroCusto() == 0) {
                    setMensagem("Campo Centro de Custo obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getClienteFornecedor() == null) {
                    setMensagem("Campo Cliente / Fornecedor obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                selectMovFinanceira.getEmpresa().setCodEmpresa(codEmpresa);
                movFinanceiraDao.salvar(getSelectMovFinanceira());
                setStatus("a");
                limpar();
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectMovFinanceira.getOperacao().equals("")) {
                    setMensagem("Campo Operação obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getBanco().getNumBanco().equals("")) {
                    setMensagem("Campo Banco obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (ValidaData.Nascimento(selectMovFinanceira.getDataLancamento()) == false) {
                    setMensagem("Data de Lançamento inválida!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getValorLancamento() <= 0) {
                    setMensagem("Campo Valor obrigatorio e deve ser maior que 0(zero)!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getContaCorrente().getCodContaCorrente() == 0) {
                    setMensagem("Campo Conta Corrente obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getCentroCusto().getCodCentroCusto() == 0) {
                    setMensagem("Campo Centro de Custo obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                if (selectMovFinanceira.getClienteFornecedor() == null) {
                    setMensagem("Campo Cliente / Fornecedor obrigatorio!");
                    return "gotoCadMovFinanceira";
                }
                movFinanceiraDao.alterar(getSelectMovFinanceira());
                setStatus("a");
                limpar();
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            movFinanceiras = null;
            return "gotoCadMovFinanceira";
        //} catch (Exception e) {
         //   setMensagem("Ocorreu um erro interno no Servidor!");
         //   return "gotoCadMovFinanceira";
       // }
    }

    public String alterar() {
        movFinanceiraDao.alterar(getSelectMovFinanceira());
        //Limpar cache
        movFinanceiras = null;
        return "";
    }

    public String excluir() {
        try {
            movFinanceiraDao.excluir(getSelectMovFinanceira());
            limpar();
            setMensagem("Registro excluido com sucesso!");
            //movFinanceiras = null;
            
            return "";
        } catch (Exception e) {
            limpar();
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoFornecedor";
        }
    }

    public String fechar() {
        setBotaoSeleciona(false);
        movFinanceiras = null;
        return "gotoMain";
    }

    public String iniciaEditMovFinanceia() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadMovFinanceira";
    }

    public String consultar() {
        movFinanceiras = null;
        valConsulta = null;
        return "cons_mov";
    }

    public String consultarClienteFornecedor() {
        setBotaoSeleciona(true);
        if (getTipo().equals("C")) {
            setRenderedSeleciona(true);
            clienteBo.consultar();
            return "cons_cliente";
        } else {
            fornecedorBo.consultar();
            return "cons_fornecedor";
        }
    }

    public String selecionaClienteFornecedor() {
        setBotaoSeleciona(false);
        return "gotoCadMovFinanceira";
    }

    public String limparCons() {
        movFinanceiras = null;
        valConsulta = null;
        return "cons_mov";
    }

    public String consult_Mov() {
        movFinanceiras = null;
        selectMovFinanceira = new MovimentacaoFinanceiraTo();

        if (valConsulta.equals("")) {
            movFinanceiras = movFinanceiraDao.consultar(codEmpresa);
        } else if (tipoConsulta.equals("valor") && !valConsulta.equals("")) {
            movFinanceiras = movFinanceiraDao.consultar_valor(Double.parseDouble(valConsulta),codEmpresa);
        } else if (tipoConsulta.equals("cod") && !valConsulta.equals("")) {
            movFinanceiras = movFinanceiraDao.consultar_cod(Integer.parseInt(valConsulta),codEmpresa);
        } else if (tipoConsulta.equals("clie") && !valConsulta.equals("")) {
            movFinanceiras = movFinanceiraDao.consultar_nome(valConsulta.toUpperCase()+ "%",codEmpresa);

        }
        return "cons_cons_mov";
    }

    public List<SelectItem> getContaCorrenteSystem() {
        List<ContaCorrenteTo> contaCorrenteTo = contaCorrenteDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(contaCorrenteTo.size());
        for (ContaCorrenteTo ccorrente : contaCorrenteTo) {
            toReturn.add(new SelectItem(ccorrente, ccorrente.getDescricao()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getCentroCustoSystem() {
        List<CentroCustoTo> centroCustoTo = centroCustoDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(centroCustoTo.size());
        for (CentroCustoTo centroCusto : centroCustoTo) {
            toReturn.add(new SelectItem(centroCusto, centroCusto.getDescricaoCentroCusto()));
        }// for end
        return toReturn;
    }

    public List<SelectItem> getBancosSystem() {
        List<BancosTo> bancosTo = bancoDao.consultar();
        List<SelectItem> toReturn = new ArrayList<SelectItem>(bancosTo.size());
        for (BancosTo bancos : bancosTo) {
            toReturn.add(new SelectItem(bancos, bancos.getDescricaoBanco()));
        }// for end
        return toReturn;
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

    public String getValConsulta() {
        return valConsulta;
    }

    public void setValConsulta(String valConsulta) {
        this.valConsulta = valConsulta;
    }

    public List<MovimentacaoFinanceiraTo> getMovFinanceiras() {
        if (movFinanceiras == null) {
            movFinanceiras = movFinanceiraDao.consultar(codEmpresa);
        }
        return movFinanceiras;
    }

    public List<MovimentacaoFinanceiraTo> getMovFinanceirasTo() {
        return movFinanceiras;

    }

    public void setMovFinanceiras(List<MovimentacaoFinanceiraTo> movFinanceiras) {
        this.movFinanceiras = movFinanceiras;
    }

    public MovimentacaoFinanceiraTo getSelectMovFinanceira() {
        return selectMovFinanceira;
    }

    public void setSelectMovFinanceira(MovimentacaoFinanceiraTo selectMovFinanceira) {
        this.selectMovFinanceira = selectMovFinanceira;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    /*
    public boolean isRenderedSeleciona() {
    return renderedSeleciona;
    }

    public void setRenderedSeleciona(boolean renderedSeleciona) {
    this.renderedSeleciona = renderedSeleciona;
    }
     */
}