package Service;

import DTO.Employee;

import java.util.List;

public interface ServiceInterface {

    ServiceInterface serviceInstance = new ServiceImple();

    static ServiceInterface getInstance() {
        return serviceInstance;
    }

    int addEmployee(String name, String mobile, String password);

    void removeEmployee(int id) throws Exception;

    void adminLogin(String id, String password) throws Exception;

    void employeeLogin(Integer id, String password) throws Exception;

    Employee displayDetails(int id);

    Employee updateDetails(int id,String name, String number);

    List<Employee> getAllDetails();

    void generateAdmin();
}
