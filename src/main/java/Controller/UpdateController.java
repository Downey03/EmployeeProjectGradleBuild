package Controller;

import DTO.Employee;
import Service.ServiceImple;
import Service.ServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateController extends HttpServlet {
    ServiceInterface serviceInstance;

    @Override
    public void init() throws ServletException {
        serviceInstance = ServiceInterface.getInstance();
    }

    protected void updateDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = serviceInstance.updateDetails(Integer.parseInt((String)req.getSession().getAttribute("sessionId")),
                (String)req.getParameter("name"),
                (String)req.getParameter("number"));
        req.setAttribute("Employee",employee);
        req.getRequestDispatcher("home.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateDetails(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateDetails(req, resp);
    }
}
