package Financeiro.bo;

import Financeiro.dao.ContaCorrenteDao;
import Financeiro.to.ContaCorrenteTo;
import java.util.List;

public class ContaCorrenteBo
{

    private ContaCorrenteDao contaCorrenteDao = new ContaCorrenteDao();
    private List<ContaCorrenteTo> contaCorrentes;
    private ContaCorrenteTo selectcontaCorrente;
    private String valConsulta = "";
    private String status;
    private String mensagem = "";
    private boolean disabled = true;

     public ContaCorrenteBo() {
    }

   public String limpar()
   {
        setSelectcontaCorrente(new ContaCorrenteTo());
        selectcontaCorrente.setDescricao("");
        selectcontaCorrente.setAgencia("");
        selectcontaCorrente.setCodContaCorrente(0);
        selectcontaCorrente.setNumeroContaCorrente(0);
        selectcontaCorrente.setSaldoInicial(0);
        setDisabled(true);
        setStatus("s");
        contaCorrentes = null;
        return "gotoCadContacorrente";
   }
   
   public String addContaCorrente() {
        contaCorrentes = null;
        selectcontaCorrente = new ContaCorrenteTo();
        setStatus("s");
        setMensagem("");
        return "gotoCadContacorrente";
    }

    public String salvar() {
        try{
            if (getStatus().equals("s")) {
                if(contaCorrenteDao.consultar(selectcontaCorrente.getNumeroContaCorrente()) != null){
                    setMensagem("Conta Corrente já cadastrada!");
                    return "gotoCadContacorrente";
                }
                if (selectcontaCorrente.getDescricao().equals("")) {
                    setMensagem("Campo Descrição obrigatório!");
                    return "gotoCadContacorrente";
                }
                if(selectcontaCorrente.getAgencia().equals("")){
                    setMensagem("Campo Agencia obrigatório!");
                    return "gotoCadContacorrente";
                }
                if(selectcontaCorrente.getNumeroContaCorrente() == 0){
                    setMensagem("Campo Num. Conta Corrente obrigatório!");
                    return "gotoCadContacorrente";
                }

                contaCorrenteDao.salvar(getSelectcontaCorrente());
                setStatus("a");
                setMensagem("Registro incluido com sucesso!");
            } else {
                if (selectcontaCorrente.getDescricao().equals("")) {
                    setMensagem("Campo Descrição obrigatório!");
                    return "gotoCadContacorrente";
                }
                if(selectcontaCorrente.getAgencia().equals("")){
                    setMensagem("Campo Agencia obrigatório!");
                    return "gotoCadContacorrente";
                }
                if(selectcontaCorrente.getNumeroContaCorrente() == 0){
                    setMensagem("Campo Num. Conta Corrente obrigatório!");
                    return "gotoCadContacorrente";
                }
                contaCorrenteDao.alterar(getSelectcontaCorrente());
                setStatus("a");
                setMensagem("Registro alterado com sucesso!");
            }
            //Limpar cache
            contaCorrentes = null;
            return "gotoCadContacorrente";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadContacorrente";
        }
    }

    public List<ContaCorrenteTo> getContaCorrentes() {
        return contaCorrentes;
    }

    public List<ContaCorrenteTo> getContaCorrenteTo() {
        return contaCorrentes;

    }
    public String excluir() {
        try{
            contaCorrenteDao.excluir(getSelectcontaCorrente());
            setMensagem("Registro excluido com sucesso!");
            //Limpar cache
            contaCorrentes = null;
            limpar();
            return "gotoCadContacorrente";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoCadContacorrente";
        }
    }

    public String fechar() {
        contaCorrentes = null;
        return "gotoMain";
    }

    public String limparCons() {
        contaCorrentes = null;
        valConsulta = null;
        return "cons_contaCorrente";
    }

    public String consult_ContaCorrente() {
        contaCorrentes = null;
        selectcontaCorrente = new ContaCorrenteTo();
        contaCorrentes = contaCorrenteDao.consultar_p(valConsulta.toUpperCase() + "%");
        
        return "cons_contaCorrente";
    }


    public List<ContaCorrenteTo> getContaCorrenteTos() {
        if (contaCorrentes == null) {
            contaCorrentes = contaCorrenteDao.consultar();
        }
        return contaCorrentes;
    }

   
    
    public String consultar() {
        contaCorrentes = null;
        return "cons_contaCorrente";
    }

    public String iniciaEditCentroCusto() {
        setStatus("a");
        setMensagem("");
        setDisabled(false);
        return "gotoCadContacorrente";
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

    public ContaCorrenteTo getSelectcontaCorrente() {
        return selectcontaCorrente;
    }

    public void setSelectcontaCorrente(ContaCorrenteTo selectcontaCorrente) {
        this.selectcontaCorrente = selectcontaCorrente;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }



}