package Financeiro.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/***********************************************************************
 * Module:  FormaPagamentoTo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FormaPagamentoTo
 ***********************************************************************/

@Entity
@SequenceGenerator(name="formapagtoseq", sequenceName="formapagtoseq")
@Table(name="public.formapagamento")

public class FormaPagamentoTo implements java.io.Serializable
{
   @Column(name="codformapagamento")
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator="formapagtoseq")
   private Integer codFormaPagamento;
   @Column(name="descricao")
   private String descricao;
   @Column(name="descricaoreduzida")
   private String descricaoReduzida;

   public String getDescricao()
   {
      return descricao;
   }
   
   public void setDescricao(String newDescricao)
   {
      descricao = newDescricao.toUpperCase();
   }
   
   public String getDescricaoReduzida()
   {
      return descricaoReduzida;
   }
   
   public void setDescricaoReduzida(String newDescricaoReduzida)
   {
      descricaoReduzida = newDescricaoReduzida.toUpperCase();
   }
   
   public Integer getCodFormaPagamento()
   {
      return codFormaPagamento;
   }
   
   public void setCodFormaPagamento(Integer newCodFormaPagamento)
   {
      codFormaPagamento = newCodFormaPagamento;
   }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormaPagamentoTo other = (FormaPagamentoTo) obj;
        if ((this.codFormaPagamento == null) ? (other.codFormaPagamento != null) : !this.codFormaPagamento.equals(other.codFormaPagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.codFormaPagamento != null ? this.codFormaPagamento.hashCode() : 0);
        return hash;
    }
}