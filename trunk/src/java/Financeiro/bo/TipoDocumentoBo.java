package Financeiro.bo;

import Financeiro.dao.TipoDocumentoDao;
import Financeiro.to.TipoDocumentoTo;
import java.util.List;

/************************************************
 * Module:  FormaPagamentoBo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class TipoDocumentoBo
 ************************************************/

public class TipoDocumentoBo {

    private TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao();
    private List<TipoDocumentoTo> tipoDocumento;
    private TipoDocumentoTo selectTipoDocumento;
    private String valConsulta = "";
    private String status;
    private boolean alt_cod;
    private String mensagem = "";
    private boolean disabled = true;


    public TipoDocumentoBo() {
        System.out.println("Tipo Documento Criado");
    }

    public String limpar() {
        setSelectTipoDocumento(new TipoDocumentoTo());
        selectTipoDocumento.setDescricao("");
        selectTipoDocumento.setDescricaoReduzida("");
        selectTipoDocumento.setCodTipoDocumento(0);
        setStatus("s");
        setDisabled(true);
        tipoDocumento = null;
        setMensagem("");
        return "gotoFormaPagto";
    }

    public String addTipoDocumento() {
        tipoDocumento = null;
        selectTipoDocumento = new TipoDocumentoTo();
        setStatus("s");
        setMensagem("");
        return "gotoTipoDocumento";
    }

   public String salvar() {
      try{
          if (getStatus().equals("s")) {
             
             if (selectTipoDocumento.getDescricaoReduzida().equals("")) {
                setMensagem("Campo Descrição Reduzida obrigatorio!");
                return "gotoTipoDocumento";
             }
             if (selectTipoDocumento.getDescricao().equals("")) {
                setMensagem("Campo Descrição obrigatorio!");
                return "gotoTipoDocumento";
             }
             if(tipoDocumentoDao.consultarDesc(selectTipoDocumento.getDescricao()).size() > 0){
                setMensagem("Já existe um registro com essa descrição!");
                return "gotoTipoDocumento";
             }

             tipoDocumentoDao.salvar(getSelectTipoDocumento());
             setStatus("a");
             limpar();
             setMensagem("Registro incluido com sucesso!");
          }
          else {
             if (selectTipoDocumento.getDescricaoReduzida().equals("")) {
                setMensagem("Campo Descrição Reduzida obrigatorio!");
                return "gotoTipoDocumento";
             }
             if (selectTipoDocumento.getDescricao().equals("")) {
                setMensagem("Campo Descrição obrigatorio!");
                return "gotoTipoDocumento";
             }
             tipoDocumentoDao.alterar(getSelectTipoDocumento());
             setStatus("a");
             limpar();
             setMensagem("Registro alterado com sucesso!");
          }

          //Limpar cache
          tipoDocumento = null;
          return "gotoTipoDocumento";
        }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoTipoDocumento";
        }
   }

   public List<TipoDocumentoTo> getTipoDocumentoTos(){
      if (getTipoDocumento() == null) {
         tipoDocumento = tipoDocumentoDao.consultar();
      }
      return tipoDocumento;
   }

   public String fechar() {
      tipoDocumentoDao = null;
      return "gotoMain";
   }

   public String limparCons() {
      tipoDocumento = null;
      valConsulta = null;
      return "cons_tipoDocumento";
   }

   public String consultar() {
      tipoDocumento = null;
      valConsulta = null;
      return "cons_tipoDocumento";
   }

   public String consult_TipoDocumento() {
        tipoDocumento = null;
        selectTipoDocumento = new TipoDocumentoTo();
        tipoDocumento = tipoDocumentoDao.consultar_p(valConsulta.toUpperCase() + "%");
        // cidades = cidDao.consultar_p("%G");
        return "cons_tipoDocumento";
    }
   public String iniciaEditTipoDoc() {
      setStatus("a");
      setAlt_cod(true);
      setMensagem("");
      setDisabled(false);
      return "gotoTipoDocumento";
   }

   public String alterar() {
      tipoDocumentoDao.alterar(getSelectTipoDocumento());
      //Limpar cache
      tipoDocumento = null;
      return "gotoTipoDocumentoList";
   }

   public String excluir() {
      try{
          tipoDocumentoDao.excluir(getSelectTipoDocumento());
          setMensagem("Registro excluido com sucesso!");
          //Limpar cache
          tipoDocumento = null;
          limpar();
          setMensagem("Registro excluido com sucesso!");
          return "gotoTipoDocumento";
       }catch(Exception e){
            setMensagem("Ocorreu um erro interno no Servidor!");
            return "gotoTipoDocumento";
       }
   }

   public TipoDocumentoTo getSelectTipoDocumento() {
      return selectTipoDocumento;
   }

   public void setSelectTipoDocumento(TipoDocumentoTo selectTipoDocumento) {
      this.selectTipoDocumento = selectTipoDocumento;
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

   public List<TipoDocumentoTo> getTipoDocumento() {
      return tipoDocumento;
   }

   public void setFormaPagamento(List<TipoDocumentoTo> tipoDocumento) {
      this.tipoDocumento = tipoDocumento;
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