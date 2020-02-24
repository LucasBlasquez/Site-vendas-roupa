/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public class Item {
    private int qtde;
    private double precounit;
    private int codproduto;
    private int codvenda;

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the precounit
     */
    public double getPrecounit() {
        return precounit;
    }

    /**
     * @param precounit the precounit to set
     */
    public void setPrecounit(double precounit) {
        this.precounit = precounit;
    }
    public void setPrecounit(String precounit) throws Exception {
        this.precounit = Double.parseDouble(precounit);
    }

    /**
     * @return the codproduto
     */
    public int getCodproduto() {
        return codproduto;
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    /**
     * @return the codvenda
     */
    public int getCodvenda() {
        return codvenda;
    }

    /**
     * @param codvenda the codvenda to set
     */
    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }
    /*
    public void setCodvenda(ResultSet codvenda) {
        this.codvenda = ;
    }*/
}
