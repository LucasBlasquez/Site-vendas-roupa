/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class Venda {
    private int codigo;
    private double total;
    private Timestamp datav;
    private int codcli;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    public void setTotal(String total) {
        this.total = Double.parseDouble(total);
    }

    /**
     * @return the datav
     */
    public Timestamp getDatav() {
        return datav;
    }

    /**
     * @param datav the datav to set
     */
    public void setDatav(Timestamp datav) {
        this.datav = datav;
    }
    
    public void setDatav(String datav) throws Exception {
        this.datav = Timestamp.valueOf(datav);
    }

    /**
     * @return the codcli
     */
    public int getCodcli() {
        return codcli;
    }

    /**
     * @param codcli the codcli to set
     */
    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }
}
