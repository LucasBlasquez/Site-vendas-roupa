/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Produto;

/**
 *
 * @author Enrique Yasuda
 */
@WebServlet(name = "SCarrinho", urlPatterns = {"/SCarrinho"})
public class SCarrinho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto obj;
        HttpSession sessao;
        ArrayList<Produto> lista;
        String s="";
        int coluna=0;
        
        double totalProduto=0.0;
        double aux=0.0;
        double totalCarrinho=0.0;
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");            
            out.println("</head>");
            out.println("<body>");

            sessao = request.getSession(true);  
            lista = (ArrayList<Produto>) sessao.getAttribute("lista");
            
            if(lista != null)
            {
                for (int i = 0; i < lista.size(); i++) {
                    
                    obj = lista.get(i);
                    totalProduto = obj.getQtde() * obj.getPreco();
                    aux += totalProduto;
                    
                    out.println("<table border='1'> <tbody> <tr>");
                    out.println("<td>");
                    
                            s="<form action='SRemoverProdutoCarrinho' method='post'>"+
                            "<input type='text' name='txtCodigo' hidden value='"+obj.getCodigo()+"' />"+
                            "<input type='text' name='txtCodigo' hidden value='"+obj.getCodigo()+"'/>"+
                            "<img src='Imagem/" + obj.getImagem() + "' width='150' heidht='150'/> <br/>"+ 
                            "<h1> " +obj.getDescricao()+ "</h1>"+
                            "<h1> Preco: R$ "+obj.getPreco()+"</h1>"+
                            "Quantidade: "+obj.getQtde()+" <br/>" +
                            "Total: " + Double.toString(totalProduto) + "<br/>"+
                            "<input type='submit' value='Remover' name='b1'/> <br/>"+
                            "</form>";
                            
                    out.println(s);
                    out.println("</td>");
                    out.println("</tr></tbody> </table>");
                                       
                    
                    coluna++;
                    
                    if(coluna==1) // define quantos produtos por linha
                    {
                        out.println("</tr><tr>"); // fecha e inicia uma nova linha
                        coluna=0;
                    }
                }
                out.println("</tr></tbody> </table>");
                
                totalCarrinho = aux;
            
            out.println("<form action='SFinalizar' method='post'"+
            "<div align='right'>" +
"           <input type='text' name='txtTotal' hidden value='"+Double.toString(totalCarrinho)+"' />" +
"            </div>" +
                
            "<div align='right'>" +
"            <h2>Total da compra: R$ " + Double.toString(totalCarrinho) +"</h2>" +
"            </div>" +
            
"            <div align='right'>" +
"            <h2><input type='submit' value='Finalizar compra' name='txtFinalizar' /></h2>" +
"            </div> </form>" +
            
            "<div align='right'>" +
"            <a href='index.html'><input type='button' value='Continuar comprando'></a>" +
"            </div></h2>");
            }
          
            else
            {
                out.println("<h1>Não há produtos no carrinho</h1>");
                out.println("<div align='left'>" +
"            <a href='index.html'><input type='button' value='Voltar ao menu inicial'></a>" +
"            </div></h2>");
            }    

            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Página de Erro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ERRO SCarrinho: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
