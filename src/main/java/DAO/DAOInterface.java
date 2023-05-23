package DAO;

import DTO.Employee;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.QueryResults;

public interface DAOInterface {

    static final DAOInterface daoInstance = new DAOImple();

    public static DAOInterface getInstance(){
        return daoInstance;
    }

    int addEmployee(Employee employee);

    void removeEmployee(int id) throws Exception;

    void validateLogin(Integer id, String password) throws Exception;

    void validateLogin(String id,String password) throws Exception;

    Entity getEmployee(int id);

    Entity updateDetails(int id, String name, String number);

    QueryResults<Entity> getAllDetails();

    void generateAdmin();
}
