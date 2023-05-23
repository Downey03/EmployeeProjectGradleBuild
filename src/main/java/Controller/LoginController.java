package Controller;

import DTO.Employee;
import Service.ServiceImple;
import Service.ServiceInterface;
import com.google.api.client.json.webtoken.JsonWebToken;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet {
    private ServiceInterface serviceInstance;

    @Override
    public void init() throws ServletException {
        serviceInstance = ServiceInterface.getInstance();
    }

    protected void loginValidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = (String)(req.getParameter("id"));
            req.getSession().setAttribute("sessionId",id);
            if(id.equals("admin")) {
                serviceInstance.adminLogin(id,(String)req.getParameter("password"));
                resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
                resp.setHeader("Pragma","no-cache");
                resp.setHeader("Expires","0");
                resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/admin.jsp"));
            }else{
                serviceInstance.employeeLogin(Integer.valueOf(id),(String)req.getParameter("password"));
                resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
                resp.setHeader("Pragma","no-cache");
                resp.setHeader("Expires","0");
                resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+"/home.jsp"));
            }

        }catch (Exception e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginValidate(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginValidate(req, resp);
    }
}
