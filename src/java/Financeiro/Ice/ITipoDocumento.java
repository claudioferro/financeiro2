package Financeiro.Ice;

import Financeiro.to.TipoDocumentoTo;

/***********************************************************************
 * Module:  ITipoCliente.java
 * Author:  Carlos Wagner
 * Purpose: Defines the Interface ITipoDocumento
 ***********************************************************************/

public interface ITipoDocumento
{
   void limpar();
   void salvar(TipoDocumentoTo tipoDocumento);
   TipoDocumentoTo consultar(int tipoDocumento);
   void excluir(TipoDocumentoTo tipoDocumento);
}