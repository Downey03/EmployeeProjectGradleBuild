package Controller;

import DTO.Employee;
import Service.ServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayDetailsController extends HttpServlet {
    private ServiceInterface serviceInstance;

    @Override
    public void init() throws ServletException {
        serviceInstance = ServiceInterface.getInstance();
    }

    protected void getAllDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = serviceInstance.getAllDetails();
        req.setAttribute("employeeList",employeeList);
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("admin-details.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAllDetails(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getAllDetails(req, resp);
    }
}
