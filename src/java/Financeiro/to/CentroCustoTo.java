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

@Entity
@SequenceGenerator(name="centrocustos_codcentrocusto_seq",sequenceName="centrocustos_codcentrocusto_seq")

@Table(name = "public.centrocustos")
public class CentroCustoTo implements java.io.Serializable {
    @OneToMany(mappedBy = "centroCusto")
    private List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos;

    @Column(name = "codcentrocusto")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="centrocustos_codcentrocusto_seq")
    private Integer codCentroCusto;

   @Column(name = "descricaocentrocusto",length=50)
   private String descricaoCentroCusto;

   @Column(name = "codigocentrocusto",length=16)
   private String codigoCentroCusto;

    public Integer getCodCentroCusto() {
        return codCentroCusto;
    }

    public void setCodCentroCusto(Integer codCentroCusto) {
        this.codCentroCusto = codCentroCusto;
    }

    public String getCodigoCentroCusto() {
        return codigoCentroCusto;
    }

    public void setCodigoCentroCusto(String codigoCentroCusto) {
        this.codigoCentroCusto = codigoCentroCusto;
    }

    public String getDescricaoCentroCusto() {
        return descricaoCentroCusto;
    }

    public void setDescricaoCentroCusto(String descricaoCentroCusto) {
        this.descricaoCentroCusto = descricaoCentroCusto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CentroCustoTo other = (CentroCustoTo) obj;
        if (this.codCentroCusto != other.codCentroCusto && (this.codCentroCusto == null || !this.codCentroCusto.equals(other.codCentroCusto))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.codCentroCusto != null ? this.codCentroCusto.hashCode() : 0);
        return hash;
    }
   
   

}