package restClient;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@WebServlet(name = "RESTFfullServlet", urlPatterns = {"/RESTFfullServlet"})
public class RESTFfullServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String tdirect = request.getParameter("direct");
        String tfolder = request.getParameter("folder");

        boolean direct = request.getParameter("direct") != null;
        boolean sfolder = request.getParameter("sfolder") != null;

        RESTFfullClient rst2 = new RESTFfullClient();

        String result = null;
        String resultdir;
        try (PrintWriter out = response.getWriter()) {
            if (direct) {
                String resCon = rst2.altGetContent(tdirect);
                result = resCon;              
            }
            if (sfolder) {
                File f = new File(result);
                  resultdir = result;
// boolean isDirectory() - Проверяет, является ли файл, обозначенный этим абстрактным путем, каталогом.
                if(f.isDirectory()) {
                  result = rst2.findFile(resultdir, tfolder);
                }
                result = rst2.altFindFile(resultdir, tfolder);
                //               rst2.close();
            }
            request.setAttribute("result", "\n" + result.toString());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        rst2.close();
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
