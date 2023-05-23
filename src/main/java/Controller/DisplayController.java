package Controller;

import DTO.Employee;
import Service.ServiceImple;
import Service.ServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisplayController",urlPatterns = "/DisplayController")
public class DisplayController extends HttpServlet {

    private ServiceInterface serviceInstance;

    @Override
    public void init() throws ServletException {
        serviceInstance = new ServiceImple();
    }

    protected void displayDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt((String)req.getSession().getAttribute("sessionId"));
        req.setAttribute("Employee",serviceInstance.displayDetails(id));
        Employee employee = (Employee) req.getAttribute("Employee");
        System.out.println(employee.toString());
        req.getRequestDispatcher("profile-page.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        displayDetails(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        displayDetails(req, resp);
    }
}
