/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProdutoCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "SProduto", urlPatterns = {"/SProduto"})
public class SProduto extends HttpServlet {

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
        ResultSet tabela;
        ProdutoCRUD objCRUD;
        int coluna=0;
        String s="";
        
        String dep = request.getParameter ("dep");
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        try{
            objCRUD = new ProdutoCRUD();
            tabela = objCRUD.listar(Integer.parseInt(dep));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Produto</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(tabela!=null)
            {
                out.println("<table border='1'> <tbody> <tr>");
                while(tabela.next())
                {
                    out.println("<td>"); // inicio da coluna
                    s="<form action='SComprar' method='post'>"+
                            "<input type='text' name='txtCodigo' hidden value='" + tabela.getInt(1) + "'/>" +
                            "<input type='text' name='txtDescricao' hidden value='"+tabela.getString(2)+"'/>" +
                            "<input type='text' name='txtPreco' hidden value='"+tabela.getDouble(3)+"'/>" +
                            "<input type='text' name='txtImagem' hidden value='" + tabela.getString(5) + "'/>" +
                            
                            "<div> <center> <img src='Imagem/"+tabela.getString(5)+"' width='150' heidht='150'/></center></div> <br/>"+ // 5 = ordem da imagem nos atributos
                            "<h1> " +tabela.getString(2)+ "</h1>"+
                            "<h1> Preco: R$ "+tabela.getDouble(3)+"</h1>"+
                            "Quantidade <input type='text' name='txtQtde' value='1'/> <br/>"+
                            "<input type='submit' name='b1' value='Comprar'/>"+
                            "</form>";
                            
                            out.println(s);
                            
                    out.println("</td>");
                    coluna++;
                    if(coluna==4) // define quantos produtos por linha
                    {
                        out.println("</tr><tr>"); // fecha e inicia uma nova linha
                        coluna=0;
                    }
                }
                out.println("</tr></tbody> </table>");
            }
          
            else
            {
                out.println("<h1>Não há produtos nesse departamento</h1>");
            }           
      
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Página de Erro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
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
