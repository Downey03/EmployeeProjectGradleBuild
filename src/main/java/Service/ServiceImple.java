package Service;

import DAO.DAOInterface;
import DTO.Employee;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.QueryResults;

import java.util.ArrayList;
import java.util.List;

public class ServiceImple implements ServiceInterface {

    private final DAOInterface daoInstance ;
    public ServiceImple(){
        daoInstance = DAOInterface.getInstance();
    }
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
    public void adminLogin(String id, String password) throws Exception {
        try{
            daoInstance.validateLogin(id,password);
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

    @Override
    public Employee displayDetails(int id) {
        Entity entity = daoInstance.getEmployee(id);
        return Employee.builder()
                .mobileNumber(entity.getString("number"))
                .id(id)
                .name(entity.getString("name"))
                .build();
    }

    @Override
    public Employee updateDetails(int id, String name, String number) {
        Entity entity = daoInstance.updateDetails(id,name,number);
        return  Employee.builder()
                .name(entity.getString("name"))
                .mobileNumber(entity.getString("number"))
                .build();
    }

    @Override
    public List<Employee> getAllDetails() {
        QueryResults<Entity> queryResults = daoInstance.getAllDetails();
        List<Employee> employeeList = new ArrayList<>();
        while (queryResults.hasNext()){
            Employee employee = new Employee();
            Entity entity = queryResults.next();
            employee.setId(Integer.parseInt(entity.getKey().getId().toString()));
            employee.setName(entity.getString("name"));
            employee.setMobileNumber(entity.getString("number"));
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public void generateAdmin() {
        daoInstance.generateAdmin();
    }
}
