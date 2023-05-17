package DAO;

import Model.Employee;

public interface DAOInterface {


    int addEmployee(Employee employee);
    void removeEmployee(int id) throws Exception;

    void validateLogin(Integer id, String password) throws Exception;
}
