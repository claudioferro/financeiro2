package Financeiro.to;

import java.io.Serializable;
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
@SequenceGenerator(name="contacorrente_codcontacorrente_seq",sequenceName="contacorrente_codcontacorrente_seq")

@Table(name = "public.contacorrente")
public class ContaCorrenteTo implements Serializable
{
    @OneToMany(mappedBy = "contaCorrente")
    private List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos;
    @Column(name = "codcontacorrente")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="contacorrente_codcontacorrente_seq")
    private Integer codContaCorrente;

   @Column(name = "descricao",length=50)
   private String descricao;

   @Column(name = "agencia",length=30)
   private String agencia;

   @Column(name = "numerocontacorrente",length=4)
   private Integer numeroContaCorrente;

   @Column(name = "saldoinicial",length=14)
   private float saldoInicial;

   @Column(name = "ativainativa",length=4)
   private boolean ativaInativa;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia.toUpperCase();
    }

    public boolean isAtivaInativa() {
        return ativaInativa;
    }

    public void setAtivaInativa(boolean ativaInativa) {
        this.ativaInativa = ativaInativa;
    }

    public Integer getCodContaCorrente() {
        return codContaCorrente;
    }

    public void setCodContaCorrente(Integer codContaCorrente) {
        this.codContaCorrente = codContaCorrente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public Integer getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(Integer numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaCorrenteTo other = (ContaCorrenteTo) obj;
        if (this.codContaCorrente != other.codContaCorrente && (this.codContaCorrente == null || !this.codContaCorrente.equals(other.codContaCorrente))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.codContaCorrente != null ? this.codContaCorrente.hashCode() : 0);
        return hash;
    }
    
   
   

}