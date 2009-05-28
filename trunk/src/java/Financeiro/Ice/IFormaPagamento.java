package Financeiro.Ice;

import Financeiro.to.FormaPagamentoTo;

/***********************************************************************
 * Module:  IFormaPagamento.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Interface IFormaPagamento
 ***********************************************************************/

public interface IFormaPagamento
{
   void limpar();
   void salvar(FormaPagamentoTo formaPagamento);
   FormaPagamentoTo consultar(String formaPagamento);
   void excluir(FormaPagamentoTo formaPagamento);
}