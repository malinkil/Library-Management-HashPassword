/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.servlet;

import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.BookMovementDetailsNew;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.entity.StockOrder;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.UserEntity;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb.BookMovementBean;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb.StockOrderBean;
import edu.iit.sat.itmd4515.malinkil.mp4.malinkil.mp4.domain.security.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mithun.alinkil
 */
@WebServlet(name = "SecurityServlet", urlPatterns = {"/app/SecurityServlet"})
public class SecurityServlet extends HttpServlet {

     @EJB
    private UserBean userBean;
    
    @EJB
    private BookMovementBean booksBean;
    
    @EJB
    private StockOrderBean stockBean;
    
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MySecurityServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "Library Management " + "</h1>");
            
            if (request.isUserInRole("customer")){
                UserEntity a = userBean.findByUsername(request.getRemoteUser());
                System.out.println("User Name" + a.getUserName());
                out.println("<h2>Welcome Customer:  " + a.getUserName());
                
                BookMovementDetailsNew b;
                
                List<BookMovementDetailsNew> books = booksBean.findAll(a.getUserId());
                if(!books.isEmpty()){
                    out.println("<P ALIGN = 'center'><TABLE BORDER=1>");
                    
                }
                out.println("<TR>");
                out.println("<TH>" + "BOOK NAME " +"</TH>");
                out.println("<TH>" + "TAKEN DATE " +"</TH>");
                out.println("<TH>" + "RETURN DATE " +"</TH>");
                out.println("<TH>" + "OVER DUE DAYS" +"</TH>");
                out.println("</TR>");
                
                for(BookMovementDetailsNew p : books){
                    out.println("<TR>");
                    out.println("<TD>" + p.getBookName() + "</TD>");
                    out.println("<TD>" + p.getBookTakenDate() + "</TD>");
                    out.println("<TD>" + p.getBookReturnDate() + "</TD>");
                    out.println("<TD>" + p.getOverDueDays() + "</TD>");
                    out.println("<TR>");
                }
                
                out.println("</TABLE></P>");
                
            }
            
            if(request.isUserInRole("vendor")){
                UserEntity a = userBean.findByUsername(request.getRemoteUser());
                System.out.println("User Name" + a.getUserName());
                out.println("<h2>Welcome Vendor: " + a.getUserName());
                
                List<StockOrder> stocks = stockBean.findAll(a.getUserId());
               // out.println(stocks.size());
                if(!stocks.isEmpty()){
                    out.println("<P ALIGN = 'center'><TABLE BORDER=1>");
                    
                out.println("<TR>");
                out.println("<TH>" + "BOOK NAME " +"</TH>");
                out.println("<TH>" + "BOOK EDITION " +"</TH>");
                out.println("<TH>" + "QUANTITY " +"</TH>");
                out.println("</TR>");
                
                for(StockOrder p : stocks){
                    out.println("<TR>");
                    out.println("<TD>" + p.getBookName() + "</TD>");
                    out.println("<TD>" + p.getBookEdition() + "</TD>");
                    out.println("<TD>" + p.getQuantity() + "</TD>");
                    out.println("<TR>");
                }
                
                out.println("</TABLE></P>");
                }
                
                
            }
            out.println("<a href=\"" +request.getContextPath() + "/logout\">Logout</a>");
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
