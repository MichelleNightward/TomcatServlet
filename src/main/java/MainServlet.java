/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lrooo
 */
public class MainServlet extends HttpServlet {
    public static String phoneNumber;
    public static String resultMessage;
    
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
            out.println("<title>Fortune Text</title>"); 
            out.println("<style type=text/css>");
            out.println("body {");
            out.println("background-color: #ECECEC;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<div style=text-align:center>");
            out.println("<div><h1>" + resultMessage + "</h1></div>");
            out.println("<body text=\"#FF0000\">");
            out.println("<form method=POST action=MainServlet>");
            out.println("<input type=text name=numberInput value=Enter Phone Number Here size=50 />");
            out.println("<input type=submit value=Submit name=submitButton />");
            out.println("</form>");
            out.println("</div>");
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
        if (request.getParameter("submitButton") != null) {
            phoneNumber = request.getParameter("numberInput");
            phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
            phoneNumber = phoneNumber.trim();
            //System.out.println(phoneNumber.length());
            if (phoneNumber.length() == 11 && phoneNumber.charAt(0) == 1){
                phoneNumber = phoneNumber.substring(1);
                System.out.println(phoneNumber);
                FortuneList.findFortuneIndex();
                SendText.DoSmsStuff();
            } else {
                FortuneList.findFortuneIndex();
                SendText.DoSmsStuff();
            }
        }
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
