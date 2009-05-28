package Financeiro.to;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***********************************************************************
 * Module:  CidadeTo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class CidadeTo
 ***********************************************************************/


@Entity
@Table(name="public.cidades")
public class CidadeTo implements java.io.Serializable
{

   @Id
   @Column(name="municipio",nullable=false,length=10)
   private String municipio;
   @Column(name="descricao",nullable=false, length=50)
   private String descricao;
   @Column(name="uf",nullable=false,length=2)
   private String uf;
   @OneToMany(mappedBy = "cidade")
   private List<ClienteFornecTo> clienteTos;
    @OneToMany(mappedBy = "cidade")
    private List<EmpresaTo> empresaTos;

    public List<EmpresaTo> getEmpresaTos() {
        return empresaTos;
    }

    public void setEmpresaTos(List<EmpresaTo> empresaTos) {
        this.empresaTos = empresaTos;
    }
    
  


   public List<ClienteFornecTo> getClienteTos() {
        return clienteTos;
    }

    public void setClienteTos(List<ClienteFornecTo> clienteTos) {
        this.clienteTos = clienteTos;
    }

  

    

    public String getMunicipio()
   {
      return municipio;
   }
   
   public void setMunicipio(String newMunicipio)
   {
      municipio = newMunicipio;
   }
   
   public String getDescricao()
   {
      return descricao;
   }
   
   public void setDescricao(String newDescricao)
   {
      descricao = newDescricao.toUpperCase();
   }
   
   public String getUf()
   {
      return uf;
   }
   
   public void setUf(String newUf)
   {
      uf = newUf.toUpperCase();
   }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CidadeTo other = (CidadeTo) obj;
        if ((this.municipio == null) ? (other.municipio != null) : !this.municipio.equals(other.municipio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.municipio != null ? this.municipio.hashCode() : 0);
        return hash;
    }

}