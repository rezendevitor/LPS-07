package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdministradorServlet", urlPatterns = {"/AdministradorServlet"})
public class AdministradorServlet extends HttpServlet {
    private int resultado;
    private String operacao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if(request.getParameter("listar").equals("Listar")){
        AdministradorController adminController = new AdministradorController();
        String cond2 = request.getParameter("listar");
        String cond = request.getParameter("salvar");
        
        if(cond != null && cond.equals("Salvar")) {
            Object[] arrayObj = new Object[8];
            float salario = Float.parseFloat(request.getParameter("salario"));
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            Date dataNasc = null;
            try {
                dataNasc = formatoData.parse(request.getParameter("nascimento"));
            } catch (ParseException ex) {
                Logger.getLogger(AdministradorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            arrayObj[0] = request.getParameter("nome");
            arrayObj[1] = request.getParameter("cpf");
            arrayObj[2] = request.getParameter("telefone");
            arrayObj[3] = request.getParameter("e-mail");
            arrayObj[4] = request.getParameter("senha");
            arrayObj[5] = request.getParameter("sexo");
            arrayObj[6] = dataNasc;
            arrayObj[7] = salario;
            adminController = new AdministradorController();
            resultado = adminController.inserir(arrayObj);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastro Administrador</title>");
                out.println("</head>");
                out.println("<body>");
                //out.println("<h1>Servlet AdministradorServlet at " + request.getContextPath() + "</h1>");
                if (resultado > 0) {
                    out.println("<h1 align='center'> Administrador Cadastrado com Sucesso! </h1>");
                } else if (resultado == 0) {
                    out.println("<h1 align='center'> Erro ao Cadastrar Administrador. </h1>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        } if(cond2 != null && cond2.equals("Listar")) {
            adminController = new AdministradorController();
            ArrayList<Object[]> arrayAdmins = adminController.buscarAdmin(null);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadastro Administrador</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table align='center'>");
                out.println("<tr>");
                out.println("<th style='width:10%'>Nome</td>");
                out.println("<th style='width:10%'>CPF</td>");
                out.println("<th style='width:10%'>Telefone</td>");
                out.println("<th style='width:10%'>E-mail</td>");
                out.println("<th style='width:10%'>Senha</td>");
                out.println("<th style='width:10%'>Sexo</td>");
                out.println("<th style='width:10%'>Data de Nascimento</td>");
                out.println("<th style='width:10%'>Salario</td>");
                out.println("</tr>");
                for (Object[] admin : arrayAdmins) {
                    out.println("<tr>");
                    out.println("<td align='center'>" + admin[0] + "</td>");
                    out.println("<td align='center'>" + admin[1] + "</td>");
                    out.println("<td align='center'>" + admin[2] + "</td>");
                    out.println("<td align='center'>" + admin[3] + "</td>");
                    out.println("<td align='center'>" + admin[4] + "</td>");
                    out.println("<td align='center'>" + admin[5] + "</td>");
                    out.println("<td align='center'>" + admin[6] + "</td>");
                    out.println("<td align='center'>" + admin[7] + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
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