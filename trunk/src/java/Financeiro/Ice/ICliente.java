package Financeiro.Ice;

import Financeiro.to.ClienteFornecTo;

/***********************************************************************
 * Module:  ICliente.java
 * Author:  Hugo Fabrício G. e Silva
 * Purpose: Defines the Interface ICliente
 ***********************************************************************/


public interface ICliente
{
   void limpar();
   int salvar(ClienteFornecTo cliente);
   ClienteFornecTo consultar(int codCliente);
   void excluir(ClienteFornecTo cliente);

}