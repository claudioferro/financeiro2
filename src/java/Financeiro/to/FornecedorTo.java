package Financeiro.to;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/***********************************************************************
 * Module:  FornecedorTo.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Class FornecedorTo
 ***********************************************************************/
@Entity
@SequenceGenerator(name = "fornecedorcliente_codfornecedorcliente_seq", sequenceName = "fornecedorcliente_codfornecedorcliente_seq")
@Table(name = "public.fornecedor")
public class FornecedorTo implements java.io.Serializable {

    @Column(name = "codfornecedor")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "fornecedorcliente_codfornecedorcliente_seq")
    private Integer codFornecedor;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "cpfCnpj")
    private String cpfCnpj;
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "contato")
    private String contato;
    @Column(name = "datacadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "atividade")
    private String atividade;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "uf")
    private String uf;
    @ManyToOne
    @JoinColumn(name = "municipio")
    private CidadeTo cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "telefoneAlternativo")
    private String telefoneAlternativo;
    @Column(name = "fax")
    private String fax;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @Column(name = "emailAlternativo")
    private String emailAlternativo;

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
        nome = newNome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String newNomeFantasia) {
        nomeFantasia = newNomeFantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String newContato) {
        contato = newContato;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String newAtividade) {
        atividade = newAtividade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String newLogradouro) {
        logradouro = newLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String newComplemento) {
        complemento = newComplemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String newUf) {
        uf = newUf;
    }

    public CidadeTo getCidade() {
        return cidade;
    }

    public void setCidade(CidadeTo cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String newBairro) {
        bairro = newBairro;
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

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer newCodFornecedor) {
        codFornecedor = newCodFornecedor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FornecedorTo other = (FornecedorTo) obj;
        if ((this.codFornecedor == null) ? (other.codFornecedor != null) : !this.codFornecedor.equals(other.codFornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.codFornecedor != null ? this.codFornecedor.hashCode() : 0);
        return hash;
    }
}