package Controller;

import Service.ServiceImple;
import Service.ServiceInterface;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpController extends HttpServlet {

    private ServiceInterface serviceInstance;
    @Override
    public void init() throws ServletException {
        serviceInstance = ServiceInterface.getInstance();
      //  serviceInstance.generateAdmin();
    }

    protected void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = serviceInstance.addEmployee((String) req.getParameter("name"),(String)(req.getParameter("mobile")),(String) req.getParameter("password"));
        req.setAttribute("msg","Sign Up Successful Your ID is "+id);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addEmployee(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addEmployee(req, resp);
    }
}
