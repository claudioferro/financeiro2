package Financeiro.Ice;

import Financeiro.to.EmpresaTo;

/***********************************************************************
 * Module:  IEmpresa.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Interface IEmpresa
 ***********************************************************************/


public interface IEmpresa
{
   void limpar();
   void salvar(EmpresaTo empresa);
   EmpresaTo consultar(String empresa);
   void excluir(EmpresaTo empresa);

}