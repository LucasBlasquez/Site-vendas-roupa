/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ItemCRUD;
import controller.VendaCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Item;
import model.Produto;
import model.Venda;

/**
 *
 * @author PC
 */
@WebServlet(name = "SFinalizar", urlPatterns = {"/SFinalizar"})
public class SFinalizar extends HttpServlet {

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
        HttpSession sessao;
        ArrayList<Produto> lista=null;
        VendaCRUD objVCRUD;
        ItemCRUD objICRUD;
        Item objI;
        Venda objV;
        Cliente objC;
        Produto objP;
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            sessao = request.getSession(false);
            Timestamp dataatual; 
            lista = (ArrayList<Produto>) sessao.getAttribute("lista");
            objVCRUD = new VendaCRUD();
            objICRUD = new ItemCRUD();
            objV = new Venda();
            objI = new Item();
            objP = new Produto();
            objC = new Cliente();
            dataatual= new Timestamp(System.currentTimeMillis());
                      
            if(sessao.getAttribute("cliente") == null)
                response.sendRedirect("SLogin");
            
            else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Finalizar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            objC = (Cliente) sessao.getAttribute("cliente");
            lista = (ArrayList<Produto>)sessao.getAttribute("lista");
            objV.setCodcli(objC.getCodigo());
            objV.setTotal(request.getParameter("txtTotal"));
            objV.setDatav(dataatual);
	
            objVCRUD.gravar(objV);
                
            for(int i=0; i<lista.size(); i++)
            {
                objP=(lista.get(i));
                objI.setCodproduto(lista.get(i).getCodigo());
                objI.setPrecounit(lista.get(i).getPreco());
                objI.setQtde(lista.get(i).getQtde());
                objI.setCodvenda(objVCRUD.listarUltimaVenda());
                
                objICRUD.gravar(objI);
            }
                
            out.println("<h1>Compra realizada com sucesso!</h1>");
            lista.clear();
            out.println("<a href='index.html'><input type='button' value='Voltar ao Menu'></a>");
            
            out.println("</body>");
            out.println("</html>");
            }
        } catch (Exception ex)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Página de Erro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro ao finalizar compra: " + ex.getMessage() + "</h1>");
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