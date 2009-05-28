package Financeiro.Ice;



import Financeiro.to.ContaCorrenteTo;


public interface IContaCorrente
{

   void limpar();

   void salvar(ContaCorrenteTo contaCorrente);

   ContaCorrenteTo consultar(int contaCorrente);

   void excluir(ContaCorrenteTo contaCorrente);

}