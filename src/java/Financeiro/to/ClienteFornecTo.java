package Financeiro.to;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/***********************************************************************
 * Module:  ClienteFornecTo.java
 * Author:  Hugo Fabrício G. e Silva
 * Purpose: Defines the Class ClienteFornecTo
 ***********************************************************************/
@Entity
@SequenceGenerator(name = "fornecedorcliente_codfornecedorcliente_seq", sequenceName = "fornecedorcliente_codfornecedorcliente_seq")
@Table(name = "public.fornecedorcliente")
public class ClienteFornecTo implements java.io.Serializable {
    @OneToMany(mappedBy = "clienteFornecedor")
    private List<MovimentacaoFinanceiraTo> movimentacaoFinanceiraTos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "fornecedorcliente_codfornecedorcliente_seq")
    @Column(name = "codfornecedorcliente")
    private Integer codCliente;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "cpfcnpj")
    private String cpfCnpj;
    @Column(name = "inscricaoestadual")
    private String inscricaoEstadual;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nomefantasia")
    private String nomeFantasia;
    @Column(name = "contato")
    private String contato;
    @Column(name = "datanascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "datacadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "atividade")
    private String atividade;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "municipio")
    private CidadeTo cidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "telefonealternativo")
    private String telefoneAlternativo;
    @Column(name = "fax")
    private String fax;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "emailalternativo")
    private String emailAlternativo;
    @ManyToOne
    @JoinColumn(name = "codtipocliente")
    private TipoClienteTo tipoCliente;
    @Column(name = "tipocadastro",length=1)
    private String tipoCadastro;

    public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

    public TipoClienteTo getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClienteTo tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public CidadeTo getCidade() {
        return cidade;
    }

    public void setCidade(CidadeTo cidade) {
        this.cidade = cidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String newCategoria) {
        categoria = newCategoria;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String newCpfCnpj) {
        cpfCnpj = newCpfCnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String newInscricaoEstadual) {
        inscricaoEstadual = newInscricaoEstadual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        nome = newNome.toUpperCase();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String newNomeFantasia) {
        nomeFantasia = newNomeFantasia.toUpperCase();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String newContato) {
        contato = newContato.toUpperCase();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String newSexo) {
        sexo = newSexo;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String newAtividade) {
        atividade = newAtividade.toUpperCase();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String newLogradouro) {
        logradouro = newLogradouro.toUpperCase();
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String newComplemento) {
        complemento = newComplemento.toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String newBairro) {
        bairro = newBairro.toUpperCase();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String newCep) {
        cep = newCep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String newTelefone) {
        telefone = newTelefone;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String newTelefoneAlternativo) {
        telefoneAlternativo = newTelefoneAlternativo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String newFax) {
        fax = newFax;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String newCelular) {
        celular = newCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String newEmailAlternativo) {
        emailAlternativo = newEmailAlternativo;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteFornecTo other = (ClienteFornecTo) obj;
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codCliente;
        return hash;
    }
    @Override
   public String toString (){
    return nome;
   }   
}