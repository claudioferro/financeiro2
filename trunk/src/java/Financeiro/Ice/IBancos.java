package Financeiro.Ice;

import Financeiro.to.BancosTo;

/***********************************************************************
 * Module:  IBancos.java
 * Author:  Hugo Fabrício Gonçalves e Silva
 * Purpose: Defines the Interface IBancos
 ***********************************************************************/

public interface IBancos
{
   void limpar();
   String salvar(BancosTo bancos);
   BancosTo consultar(String bancos);
   void excluir(BancosTo bancos);

}