package Financeiro.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/***********************************************************************
 * Module:  FilialTo.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Class FilialTo
 ***********************************************************************/

@Entity
@Table(name="public.filial")
@PrimaryKeyJoinColumn(name="codempresa")
public class FilialTo extends EmpresaTo implements java.io.Serializable
{
    @Column(name="cnpj")
   private String cnpj;
    @Column(name="inscricaoestadual")
   private String inscricaoEstadual;
    @Column(name="inscricaomunicipal")
   private String inscricaoMunicipal;
    @Column(name="logradouro")
   private String logradouro;
    @Column(name="complemento")
   private String complemento;
    @Column(name="numero")
   private String numero;
    @Column(name="bairro")
   private String bairro;
    @Column(name="registrojuntacomercial")
   private String registroJuntaComercial;
    @Column(name="email")
   private String email;
    @Column(name="telefone")
   private String telefone;
    @Column(name="fax")
   private String fax;
    @Column(name="contato")
   private String contato;


    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento.toUpperCase();
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro.toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRegistroJuntaComercial() {
        return registroJuntaComercial;
    }

    public void setRegistroJuntaComercial(String registroJuntaComercial) {
        this.registroJuntaComercial = registroJuntaComercial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  

}