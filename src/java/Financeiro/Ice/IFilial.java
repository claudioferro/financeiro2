package Financeiro.Ice;

import Financeiro.to.FilialTo;

/***********************************************************************
 * Module:  IFilialDao.java
 * Author:  Hugo Fabrício
 * Purpose: Defines the Interface IFilialDao
 ***********************************************************************/


public interface IFilial
{
   void limpar();
   int salvar(FilialTo filial);
   FilialTo consultar(String filial);
   void excluir(FilialTo filial);

}