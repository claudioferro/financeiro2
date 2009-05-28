package Financeiro.to;

/***********************************************************************
 * Module:  MovimentacaoFinanceiraTo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class MovimentacaoFinanceiraTo
 ***********************************************************************/
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name = "movimentacaofinanceira_codmovimentacaofinanceira_seq", sequenceName = "movimentacaofinanceira_codmovimentacaofinanceira_seq")
@Table(name = "public.movimentacaofinanceira")
public class MovimentacaoFinanceiraTo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "movimentacaofinanceira_codmovimentacaofinanceira_seq")
    @Column(name = "codmovimentacaofinanceira")
    private Integer codMovimentacaoFinanceira;

    @ManyToOne
    @JoinColumn(name="codfornecedorcliente")
    private ClienteFornecTo clienteFornecedor;

    @ManyToOne
    @JoinColumn(name = "numbanco")
    private BancosTo banco;

    @ManyToOne
    @JoinColumn(name = "codempresa")
    private EmpresaTo empresa;
    @Column(name = "historico")
    private String historico;
    @Column(name = "datalancamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;
    @Column(name = "operacao")
    private String operacao;
    @Column(name = "valorlancamento")
    private Double valorLancamento;

    @ManyToOne
    @JoinColumn(name = "codcontacorrente")
    private ContaCorrenteTo contaCorrente;
    
    @ManyToOne
    @JoinColumn(name = "codcentrocusto")
    private CentroCustoTo centroCusto;

    public Integer getCodMovimentacaoFinanceira() {
        return codMovimentacaoFinanceira;
    }

    public void setCodMovimentacaoFinanceira(Integer codMovimentacaoFinanceira) {
        this.codMovimentacaoFinanceira = codMovimentacaoFinanceira;
    }

    public CentroCustoTo getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroCustoTo centroCusto) {
        this.centroCusto = centroCusto;
    }

    public ContaCorrenteTo getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrenteTo contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

   

   
    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    public BancosTo getBanco() {
        return banco;
    }

    public void setBanco(BancosTo banco) {
        this.banco = banco;
    }

    public ClienteFornecTo getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(ClienteFornecTo clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
    }

    public EmpresaTo getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaTo empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovimentacaoFinanceiraTo other = (MovimentacaoFinanceiraTo) obj;
        if (this.codMovimentacaoFinanceira != other.codMovimentacaoFinanceira && (this.codMovimentacaoFinanceira == null || !this.codMovimentacaoFinanceira.equals(other.codMovimentacaoFinanceira))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.codMovimentacaoFinanceira != null ? this.codMovimentacaoFinanceira.hashCode() : 0);
        return hash;
    }
    
}