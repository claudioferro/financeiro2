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
@SequenceGenerator(name="tipodocumentoseq", sequenceName="tipodocumentoseq")
@Table(name="public.tipodocumento")

public class TipoDocumentoTo implements java.io.Serializable
{
   @Column(name="codtipodocumento")
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator="tipodocumentoseq")
   private Integer codTipoDocumento;
   @Column(name="descricao")
   private String descricao;
   @Column(name="descricaoreduzida")
   private String descricaoReduzida;

    public Integer getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(Integer codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getDescricaoReduzida() {
        return descricaoReduzida;
    }

    public void setDescricaoReduzida(String descricaoReduzida) {
        this.descricaoReduzida = descricaoReduzida.toUpperCase();
    }

   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoDocumentoTo other = (TipoDocumentoTo) obj;
        if ((this.codTipoDocumento == null) ? (other.codTipoDocumento != null) : !this.codTipoDocumento.equals(other.codTipoDocumento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.codTipoDocumento != null ? this.codTipoDocumento.hashCode() : 0);
        return hash;
    }
}
