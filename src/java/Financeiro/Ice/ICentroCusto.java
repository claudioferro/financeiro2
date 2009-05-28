package Financeiro.Ice;

import Financeiro.to.CentroCustoTo;


public interface ICentroCusto
{
   
   void limpar();
   
   void salvar(CentroCustoTo centroCusto);
   
   CentroCustoTo consultar(int centroCusto);
   
   void excluir(CentroCustoTo centroCusto);

}