package Controller;

import Service.ServiceImple;
import Service.ServiceInterface;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private ServiceInterface serviceInstance;
    @Override
    public void init() throws ServletException {
        serviceInstance = new ServiceImple();
    }

    protected void loginValidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.valueOf(req.getParameter("id"));
            serviceInstance.employeeLogin(id,(String)req.getParameter("password"));
            req.getSession().setAttribute("id",id);
        }catch (Exception e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
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
