package Financeiro.Ice;

import Financeiro.to.CidadeTo;

/***********************************************************************
 * Module:  ICidade.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Interface ICidade
 ***********************************************************************/


public interface ICidade
{
   void limpar();
   String salvar(CidadeTo cidade);
   CidadeTo consultar(String cidade);
   void excluir(CidadeTo cidade);

}