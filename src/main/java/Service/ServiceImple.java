package Service;

import DAO.DAOImple;
import DAO.DAOInterface;
import Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServiceImple implements ServiceInterface {

    private DAOInterface daoInstance = new DAOImple();

    @Override
    public int addEmployee(String name, String mobile, String password) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);
        employee.setMobileNumber(mobile);
        return daoInstance.addEmployee(employee);
    }

    @Override
    public void removeEmployee(int id) throws Exception {
        try{
            daoInstance.removeEmployee(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void employeeLogin(Integer id, String password) throws Exception {
        try{
            daoInstance.validateLogin(id,password);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
