package Data;

import Model.Employee;

import java.util.HashMap;

public class Data {
    private static HashMap<Integer, Employee> database = new HashMap<>();
    public static HashMap<Integer, Employee> getDatabase(){
        return database;
    }
    public static void setDatabase(HashMap<Integer,Employee> data){
        database = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
