package Service;

public interface ServiceInterface {

    int addEmployee(String name, String mobile, String password);

    void removeEmployee(int id) throws Exception;
    void employeeLogin(Integer id, String password) throws Exception;
}
