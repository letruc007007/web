/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDAO;
import dao.LoaiDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hoa;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ProductManagement", urlPatterns = {"/ProductManagement"})
public class ProductManagement extends HttpServlet {

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

    // xác thực thông tin đăng nhập
    HttpSession session = request.getSession();
    if (session.getAttribute("username") == null) { // chưa đăng nhập
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    HoaDAO hoaDAO = new HoaDAO();
    LoaiDAO loaiDAO = new LoaiDAO();

    String action = "list";
    if (request.getParameter("action") != null) {
        action = request.getParameter("action");
    }
    switch (action) {
        case "list":
            System.out.println("list");
            ArrayList<Hoa> dsHoa = hoaDAO.getAll(); 
            request.setAttribute("dsHoa", dsHoa);
            request.getRequestDispatcher("/admin/list.jsp").forward(request, response); 
            break;

        case "add":
            System.out.println("add");
            request.getRequestDispatcher("/admin/list.jsp").forward(request, response); 
            break;

        case "edit":
            System.out.println("edit");
            request.getRequestDispatcher("/admin/list.jsp").forward(request, response); 
            break;

        case "update":
            System.out.println("update");
            request.getRequestDispatcher("/admin/list.jsp").forward(request, response); 
            break;

        case "delete":
            int mahoa=Integer.parseInt(request.getParameter("mahoa"));
            if (hoaDAO.Delete(mahoa)){
                request.setAttribute("success","Xoá Sản Phảm Thành Công");
            }else{
                request.setAttribute("success","Xoá Sản Phảm Thất Bại");
            }
            request.getRequestDispatcher("ProductManagement?action=list").forward(request, response);
            break;

        
            
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