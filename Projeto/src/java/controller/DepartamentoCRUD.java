/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import model.Banco;

/**
 *
 * @author PC
 */
public class DepartamentoCRUD {
    public ResultSet listar() throws Exception
   {
       Banco bb;
       try
       {
           bb=new Banco();
           bb.comando=Banco.conexao.prepareStatement("Select * from departamento");
           bb.tabela=bb.comando.executeQuery();
           Banco.conexao.close();
           return(bb.tabela);
       }
       catch(Exception ex)
       {   
        throw new Exception ("Erro ao listar produtos: " + ex.getMessage());   
       }
   }
}
