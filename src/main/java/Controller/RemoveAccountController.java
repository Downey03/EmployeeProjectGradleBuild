package Controller;

import Service.ServiceImple;
import Service.ServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveAccountController extends HttpServlet {
    private ServiceInterface serviceInstance;
    @Override
    public void init() throws ServletException {
        serviceInstance = ServiceInterface.getInstance();
    }

    protected void removeAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            serviceInstance.removeEmployee(Integer.parseInt((String)req.getSession().getAttribute("sessionId")));
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }catch (Exception e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        removeAccount(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        removeAccount(req, resp);
    }
}
