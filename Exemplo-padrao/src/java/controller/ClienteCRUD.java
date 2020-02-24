/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Banco;
import model.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteCRUD {
    // cadastro e login
    public int gravar(Cliente obj) throws Exception
    {
        Banco bb;
        int qtde=0;
        try
        {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("insert into cliente(nome,login,senha) values(?,?,?)");
            bb.comando.setString(1, obj.getNome());
            bb.comando.setString(2, obj.getLogin());
            bb.comando.setString(3, obj.getSenha());
            qtde=bb.comando.executeUpdate(); // retornar quantos foram inserido na base
            Banco.conexao.close(); 
            return(qtde);
        }
        catch(Exception ex){
            throw new Exception("Erro ao gravar cliente da base: "+ex.getMessage());
        }
    }
    
    public Cliente login(String login, String senha) throws Exception
    {
            Banco bb;
            Cliente obj = null;
            
            try{
                bb=new Banco();
                bb.comando=Banco.conexao.prepareStatement(
                "Select codigo,nome,login,senha from cliente where "
                        + "login=? and senha=?");
                bb.comando.setString(1, login);
                bb.comando.setString(2, senha);
                bb.tabela=bb.comando.executeQuery(); // executar o SQL
                
                if(bb.tabela.next())
                {
                    obj=new Cliente();
                    obj.setCodigo(bb.tabela.getInt(1));
                    obj.setNome(bb.tabela.getString(2));
                    obj.setLogin(bb.tabela.getString(3));
                    obj.setSenha(bb.tabela.getString(4));
                }
                Banco.conexao.close();
                return(obj);
            }
            catch(Exception ex)
            {
                throw new Exception("Erro no login: "+ex.getMessage());
            }
    }
    
    public boolean listar(int cod) throws Exception
    {
        Banco bb;
        Cliente obj = null;
        boolean achou=false;

        try{
                bb=new Banco();
                bb.comando=Banco.conexao.prepareStatement(
                "Select codigo,nome,login,senha from cliente where "
                        + "codigo=?");
                bb.comando.setInt(1, cod);
                bb.tabela=bb.comando.executeQuery(); // executar o SQL
                
                if(bb.tabela.next())
                {
                    obj=new Cliente();
                    obj.setCodigo(bb.tabela.getInt(1));
                    obj.setNome(bb.tabela.getString(2));
                    obj.setLogin(bb.tabela.getString(3));
                    obj.setSenha(bb.tabela.getString(4));
                }
                Banco.conexao.close();
                achou=true;
                return (achou);
            }
            catch(Exception ex)
            {
                throw new Exception("Erro ao percorrer base cliente: "+ex.getMessage());
            }
    }
}
