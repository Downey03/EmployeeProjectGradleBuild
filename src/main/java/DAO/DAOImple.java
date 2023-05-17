package DAO;

import Data.Data;
import Model.Employee;

import java.util.HashMap;
import java.util.List;

public class DAOImple implements DAOInterface{
    private int id = 1  ;
    private HashMap<Integer,Employee> getDataBase(){
        return Data.getDatabase();
    }

    private void saveDataBase(HashMap<Integer,Employee> database){
        Data.setDatabase(database);
    }
    @Override
    public int addEmployee(Employee employee) {
        HashMap<Integer,Employee> database = getDataBase();
        employee.setId(id);
        database.put(id,employee);
        saveDataBase(database);
        return id++;
    }

    @Override
    public void removeEmployee(int id) throws Exception {
        HashMap<Integer,Employee> database = getDataBase();
        if(!database.containsKey(id)) throw new Exception("Id Not Found");
        database.remove(id);
        saveDataBase(database);
    }

    @Override
    public void validateLogin(Integer id, String password) throws Exception {
        HashMap<Integer,Employee> database = getDataBase();
        if(!database.containsKey(id)) throw new Exception("User Id Not Found");
        if(database.containsKey(id) && !database.get(id).getPassword().equals(password)) throw new Exception("Invalid Password");
    }
}
