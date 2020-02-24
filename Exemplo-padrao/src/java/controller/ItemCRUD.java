/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Banco;
import model.Item;

/**
 *
 * @author PC
 */
public class ItemCRUD {
     public void gravar(Item obj) throws Exception
    {
        Banco bb;
        try
        {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("insert into item(qtde,precounit,codproduto,codvenda) values(?,?,?,?)");
            bb.comando.setInt(1, obj.getQtde());
            bb.comando.setDouble(2, obj.getPrecounit());
            bb.comando.setInt(3, obj.getCodproduto());
            bb.comando.setInt(4, obj.getCodvenda());
            Banco.conexao.close(); 
        }
        catch(Exception ex){
            throw new Exception("Erro ao gravar item: "+ex.getMessage());
        }
    }
}
