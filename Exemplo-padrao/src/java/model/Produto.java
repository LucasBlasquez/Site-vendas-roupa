/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Produto {

    private int codigo;
    private String descricao;
    private double preco;
    private String imagem;
    private int qtde;
    private int coddep;
    
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
    
    public void setCodigo(String codigo) throws Exception {
        this.codigo = Integer.parseInt(codigo);
    }
    
    public String getDescricao() {
        return descricao;
    }
    

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void setPreco(String preco) {
        this.preco = Double.parseDouble(preco);
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

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
    
    public void setQtde(String qtde) throws Exception {
        this.qtde = Integer.parseInt(qtde);
    }

    /**
     * @return the coddep
     */
    public int getCoddep() {
        return coddep;
    }

    /**
     * @param coddep the coddep to set
     */
    public void setCoddep(int coddep) {
        this.coddep = coddep;
    }
    
    public void setCoddep(String coddep) {
        this.coddep = Integer.parseInt(coddep);
    }
    
    
    
}
