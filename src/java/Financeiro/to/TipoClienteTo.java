package Financeiro.to;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/***********************************************************************
 * Module:  TipoClienteTo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class TipoClienteTo
 ***********************************************************************/
@Entity
@SequenceGenerator(name="tipocliente_codtipocliente_seq",sequenceName="tipocliente_codtipocliente_seq")

@Table(name = "public.tipocliente")
public class TipoClienteTo implements java.io.Serializable {

    
    @Column(name = "codtipocliente")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="tipocliente_codtipocliente_seq")
    private Integer codTipoCliente;
    @Column(name = "descricaoreduzida",length=2)
    private String descricaoReduzida;
    @Column(name = "descricao",length=50)
    private String descricao;
    @OneToMany(mappedBy = "tipoCliente")
    private List<ClienteFornecTo> clienteTos;

    public List<ClienteFornecTo> getClienteTos() {
        return clienteTos;
    }

    public void setClienteTos(List<ClienteFornecTo> clienteTos) {
        this.clienteTos = clienteTos;
    }

    public String getDescricaoReduzida() {
        return descricaoReduzida;
    }

    public void setDescricaoReduzida(String newDescricaoReduzida) {
        descricaoReduzida = newDescricaoReduzida.toUpperCase();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String newDescricao) {
        descricao = newDescricao.toUpperCase();
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer newCodTipoCliente) {
        codTipoCliente = newCodTipoCliente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoClienteTo other = (TipoClienteTo) obj;
        if (this.codTipoCliente != other.codTipoCliente && (this.codTipoCliente == null || !this.codTipoCliente.equals(other.codTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.codTipoCliente != null ? this.codTipoCliente.hashCode() : 0);
        return hash;
    }

   @Override
   public String toString (){
    return descricao;
   }
   

    
}