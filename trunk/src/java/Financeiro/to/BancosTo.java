package Financeiro.to;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***********************************************************************
 * Module:  BancosTo.java
 * Author:  Hugo Fabrício Gonçalves e Silva
 * Purpose: Defines the Class BancosTo
 ***********************************************************************/

@Entity
@Table(name="public.bancos")
public class BancosTo implements java.io.Serializable
{
    @OneToMany(mappedBy = "banco")
    private List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos;
   @Id
   @Column(name="numbanco",nullable=false,length=3)
   private String numBanco;
   @Column(name="descricao",nullable=false, length=50)
   private String descricaoBanco;

    public String getDescricaoBanco() {
        return descricaoBanco;
    }

    public void setDescricaoBanco(String descricaoBanco) {
        this.descricaoBanco = descricaoBanco.toUpperCase();
    }

    public String getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(String numBanco) {
        this.numBanco = numBanco.toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BancosTo other = (BancosTo) obj;
        if ((this.numBanco == null) ? (other.numBanco != null) : !this.numBanco.equals(other.numBanco)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.numBanco != null ? this.numBanco.hashCode() : 0);
        return hash;
    }

   
  
}