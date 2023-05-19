package Controller;

import Data.Data;
import Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LogoutController extends HttpServlet {

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HashMap<Integer, Employee> data = Data.getDatabase();
//        data.put(1,new Employee());
//        Data.setDatabase(data);
        req.getSession().invalidate();
        resp.sendRedirect( resp.encodeRedirectURL(req.getContextPath()+"/login.jsp"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }
}
