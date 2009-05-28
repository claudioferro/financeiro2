package Financeiro.Ice;

import Financeiro.to.ClienteFornecTo;

/***********************************************************************
 * Module:  IFornecedor.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Interface IFornecedor
 ***********************************************************************/

public interface IFornecedor
{
   void limpar();
   void salvar(ClienteFornecTo fornecedor);
   ClienteFornecTo consultar(String fornecedor);
   void excluir(ClienteFornecTo fornecedor);
}