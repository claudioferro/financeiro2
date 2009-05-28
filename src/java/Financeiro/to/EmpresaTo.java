package Financeiro.to;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/***********************************************************************
 * Module:  EmpresaTo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class EmpresaTo
 ***********************************************************************/
@Entity
@SequenceGenerator(name = "empresa_codempresa_seq", sequenceName = "empresa_codempresa_seq")
@Table(name = "public.empresa")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmpresaTo implements java.io.Serializable {

    @OneToMany(mappedBy = "empresa")
    private List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos;
    @Id
    @Column(name = "codempresa")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "empresa_codempresa_seq")
    private Integer codEmpresa;
    @Column(name = "razaosocial")
    private String razaoSocial;
    @Column(name = "nomefantasia")
    private String nomeFantasia;
    @Column(name = "porteempresa")
    private String porteEmpresa;
    @Column(name = "ramoatividade")
    private String ramoAtividade;
    @Column(name = "homepage")
    private String homePage;
    @ManyToOne
    @JoinColumn(name = "municipio")
    private CidadeTo cidade;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String newRazaoSocial) {
        razaoSocial = newRazaoSocial.toUpperCase();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String newNomeFantasia) {
        nomeFantasia = newNomeFantasia.toUpperCase();
    }

    public String getPorteEmpresa() {
        return porteEmpresa;
    }

    public void setPorteEmpresa(String newPorteEmpresa) {
        porteEmpresa = newPorteEmpresa.toUpperCase();
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String newRamoAtividade) {
        ramoAtividade = newRamoAtividade.toUpperCase();
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String newHomePage) {
        homePage = newHomePage;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public List<MovimentacaoFinanceiraTo> getMovimentacaoFinanceiraTos() {
        return movimentacaoFinanceiraTos;
    }

    public void setMovimentacaoFinanceiraTos(List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos) {
        this.movimentacaoFinanceiraTos = movimentacaoFinanceiraTos;
    }

    public CidadeTo getCidade() {
        return cidade;
    }

    public void setCidade(CidadeTo cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaTo other = (EmpresaTo) obj;
        if ((this.codEmpresa == null) ? (other.codEmpresa != null) : !this.codEmpresa.equals(other.codEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.codEmpresa != null ? this.codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return Integer.toString(codEmpresa);
    }
}