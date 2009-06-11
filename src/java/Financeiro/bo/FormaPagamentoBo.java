package Financeiro.bo;

import Financeiro.dao.FormaPagamentoDao;
import Financeiro.to.FormaPagamentoTo;
import java.util.List;

/************************************************
 * Module:  FormaPagamentoBo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FormaPagamentoBo
 ************************************************/

public class FormaPagamentoBo
{
    private FormaPagamentoDao formapgDao = new FormaPagamentoDao();
    private List<FormaPagamentoTo> formaPagamento = null;
    private FormaPagamentoTo selectFormaPagamento;
    private String status;
    private boolean alt_cod;
    private String mensagem = "";
    private String valConsulta = "";
    private boolean disabled = true;

    public FormaPagamentoBo() {
        System.out.println("Forma de Pagamento Criada");
    }

    public String limpar() {
        setSelectFormaPagamento(new FormaPagamentoTo());
        selectFormaPagamento.setDescricao("");
        selectFormaPagamento.setDescricaoReduzida("");
        selectFormaPagamento.setCodFormaPagamento(0);
        setStatus("s");
        setDisabled(true);
        formaPagamento = null;
        setMensagem("");
        return "gotoFormaPagto";
    }

    public String addFormaPagto() {
        formaPagamento = null;
        selectFormaPagamento = new FormaPagamentoTo();
        setStatus("s");
        setMensagem("");
        return "gotoFormaPagto";
    }

   public String salvar() {
      try{
          if (getStatus().equals("s")) {
             if (selectFormaPagamento.getDescricaoReduzida().equals("")) {
                setMensagem("Campo Descrição Reduzida obrigatorio!");
                return "gotoFormaPagto";
             }
             if (selectFormaPagamento.getDescricao().equals("")) {
                setMensagem("Campo Descrição obrigatorio!");
                return "gotoFormaPagto";
             }
           if(formapgDao.consultarDesc(selectFormaPagamento.getDescricao()).size() > 0){
                setMensagem("Já existe um registro com esta descrição!");
                return "gotoFormaPagto";
             }

             formapgDao.salvar(getSelectFormaPagamento());
             setStatus("a");
             limpar();
             setMensagem("Registro incluido com sucesso!");
          }
          else {
             if (selectFormaPagamento.getDescricaoReduzida().equals("")) {
                setMensagem("Campo Descrição Reduzida obrigatorio!");
                return "gotoFormaPagto";
             }
             if (selectFormaPagamento.getDescricao().equals("")) {
                setMensagem("Campo Descrição obrigatorio!");
                return "gotoFormaPagto";
             }
             formapgDao.alterar(getSelectFormaPagamento());
             setStatus("a");
             limpar();
             setMensagem("Registro alterado com sucesso!");
          }

          //Limpar cache
          formaPagamento = null;
          return "gotoFormaPagto";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoFormaPagto";
        }
   }

   public List<FormaPagamentoTo> getFormaPagtoTos(){
      if (getFormaPagamento() == null) {
         formaPagamento = formapgDao.consultar();
      }
      return formaPagamento;
   }

   public String fechar() {
      formapgDao = null;
      return "gotoMain";
   }

   public String limparCons() {
      formaPagamento = null;
      valConsulta = null;
      return "cons_formaPagto";
   }

   public String consultar() {
      formaPagamento = null;
      valConsulta = null;
      return "cons_formaPagto";
   }

   public String consult_FormaPag() {
        formaPagamento = null;
        selectFormaPagamento = new FormaPagamentoTo();
        formaPagamento = formapgDao.consultar_p(valConsulta.toUpperCase() + "%");
        // cidades = cidDao.consultar_p("%G");
        return "cons_formaPagto";
    }
   public String iniciaEditFormaPg() {
      setStatus("a");
      setAlt_cod(true);
      setMensagem("");
      setDisabled(false);
      return "gotoFormaPagto";
   }

   public String alterar() {
      formapgDao.alterar(getSelectFormaPagamento());
      //Limpar cache
      formaPagamento = null;
      return "gotoFormaPGList";
   }

   public String excluir() {
      try{
          formapgDao.excluir(getSelectFormaPagamento());
          setMensagem("Registro excluido com sucesso!");
          //Limpar cache
          formaPagamento = null;
          limpar();
          return "gotoFormaPagto";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoFormaPagto";
        }
   }

   public FormaPagamentoTo getSelectFormaPagamento() {
      return selectFormaPagamento;
   }

   public void setSelectFormaPagamento(FormaPagamentoTo selectFormaPagamento) {
      this.selectFormaPagamento = selectFormaPagamento;
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

   public List<FormaPagamentoTo> getFormaPagamento() {
      return formaPagamento;
   }

   public void setFormaPagamento(List<FormaPagamentoTo> formaPagamento) {
      this.formaPagamento = formaPagamento;
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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}