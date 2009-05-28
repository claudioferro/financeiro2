package Financeiro.Ice;

import Financeiro.to.UsuarioTo;

public interface IUsuario
{
   void limpar();

   void salvar(UsuarioTo usuario);

   UsuarioTo consultar(int usuario);

   void excluir(UsuarioTo usuario);

}