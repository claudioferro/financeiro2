package Financeiro.Ice;

import Financeiro.to.TipoClienteTo;

/***********************************************************************
 * Module:  ITipoCliente.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Interface ITipoCliente
 ***********************************************************************/

public interface ITipoCliente
{
   void limpar();
   void salvar(TipoClienteTo tipoCliente);
   TipoClienteTo consultar(int tipoCliente);
   void excluir(TipoClienteTo tipoCliente);

}