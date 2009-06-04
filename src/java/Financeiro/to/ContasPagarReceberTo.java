package Financeiro.to;

import java.util.Date;
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

/***********************************************************************
 * Module:  ContaPagarReceberTo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class ContaPagarReceberTo
 ***********************************************************************/

@Entity
@SequenceGenerator(name = "cntpagarreceber_codcontas_seq", sequenceName = "cntpagarreceber_codcontas_seq")
@Table(name = "public.contas")
public class ContasPagarReceberTo implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cntpagarreceber_codcontas_seq")
    @Column(name = "codcontas")
    private Integer codContas;

    @ManyToOne
    @JoinColumn(name = "codempresa")
    private EmpresaTo empresa;
    @ManyToOne
    @JoinColumn(name = "codmovimentacaofinanceira")
    private MovimentacaoFinanceiraTo movimFinanceira;
    @ManyToOne
    @JoinColumn(name = "numbanco")
    private BancosTo numBanco;
    @ManyToOne
    @JoinColumn(name = "codformapagamento")
    private FormaPagamentoTo formaPagto;
    @ManyToOne
    @JoinColumn(name = "codtipodocumento")
    private TipoDocumentoTo tipoDocumento;
    @ManyToOne
    @JoinColumn(name = "codcentrocusto")
    private CentroCustoTo centroCusto;
    @ManyToOne
    @JoinColumn(name = "codcontacorrente")
    private ContaCorrenteTo contaCorrente;
    @ManyToOne
    @JoinColumn(name = "codfornecedorcliente")
    private ClienteFornecTo clienteFornec;

    @Column(name = "tipoconta")
    private String tipoConta;
    @Column(name = "numerodocumento")
    private String numDocumento;
    @Column(name = "status")
    private String status;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "situacaodocumento")
    private String situacaoDocumento;
    @Column(name = "numerocheque")
    private String numeroCheque;
    @Column(name = "numeronotafiscal")
    private String numNotaFiscal;
    @Column(name = "numeroboleto")
    private String numeroBoleto;
    @Column(name = "historico")
    private String historico;

    @Column(name = "dataliquidacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLiquidacao;
    @Column(name = "dataemissao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "datavencimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;

    @Column(name = "valor",length=14)
    private float valor;
    @Column(name = "valornotafiscal",length=14)
    private float valorNotaFiscal;
    @Column(name = "valorpago",length=14)
    private float valorPago;
    @Column(name = "diasprotesto")
    private Integer diasProtesto;

    public Integer getCodContas() {
        return codContas;
    }

    public void setCodContas(Integer codContas) {
        this.codContas = codContas;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento.toUpperCase();
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia.toUpperCase();
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

    public EmpresaTo getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaTo empresa) {
        this.empresa = empresa;
    }

    public FormaPagamentoTo getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(FormaPagamentoTo formaPagto) {
        this.formaPagto = formaPagto;
    }

    public TipoDocumentoTo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoTo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public MovimentacaoFinanceiraTo getMovimFinanceira() {
        return movimFinanceira;
    }

    public void setMovimFinanceira(MovimentacaoFinanceiraTo movimFinanceira) {
        this.movimFinanceira = movimFinanceira;
    }

    public BancosTo getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(BancosTo numBanco) {
        this.numBanco = numBanco;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public ClienteFornecTo getClienteFornec() {
        return clienteFornec;
    }

    public void setClienteFornec(ClienteFornecTo clienteFornec) {
        this.clienteFornec = clienteFornec;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataLiquidacao() {
        return dataLiquidacao;
    }

    public void setDataLiquidacao(Date dataLiquidacao) {
        this.dataLiquidacao = dataLiquidacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getDiasProtesto() {
        return diasProtesto;
    }

    public void setDiasProtesto(Integer diasProtesto) {
        this.diasProtesto = diasProtesto;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico.toUpperCase();
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getNumNotaFiscal() {
        return numNotaFiscal;
    }

    public void setNumNotaFiscal(String numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    public String getSituacaoDocumento() {
        return situacaoDocumento;
    }

    public void setSituacaoDocumento(String situacaoDocumento) {
        this.situacaoDocumento = situacaoDocumento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(float valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContasPagarReceberTo other = (ContasPagarReceberTo) obj;
        if (this.codContas != other.codContas) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codContas;
        return hash;
    }

    @Override
    public String toString (){
      return numDocumento;
    }
}


