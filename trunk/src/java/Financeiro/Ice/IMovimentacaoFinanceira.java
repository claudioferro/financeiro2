package Financeiro.Ice;

import Financeiro.to.MovimentacaoFinanceiraTo;

/***********************************************************************
 * Module:  IMovimentacaoFinanceira.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Interface IMovimentacaoFinanceira
 ***********************************************************************/

public interface IMovimentacaoFinanceira
{
   void limpar();
   void salvar(MovimentacaoFinanceiraTo movimentacaoFinanceira);
   MovimentacaoFinanceiraTo consultar(String movimentacaoFinanceira);
   void excluir(MovimentacaoFinanceiraTo movimentacaoFinanceira);

}