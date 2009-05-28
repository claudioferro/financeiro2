package Financeiro.Ice;

import Financeiro.to.ContasPagarReceberTo;

/***********************************************************************
 * Module:  IBancos.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Interface IContaPagarReceber
 ***********************************************************************/

public interface IContasPagarReceber
{
   void limpar();
   void salvar(ContasPagarReceberTo contas);
   ContasPagarReceberTo consultar(String contas);
   void excluir(ContasPagarReceberTo contas);
}
