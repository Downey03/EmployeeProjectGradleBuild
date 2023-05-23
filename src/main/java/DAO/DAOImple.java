package DAO;

import DTO.Employee;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.*;

import java.io.IOException;

import static com.google.auth.oauth2.GoogleCredentials.getApplicationDefault;

public class DAOImple implements DAOInterface{
    private int id = 1  ;

    private static Datastore datastore;

    static {
        try {
            datastore = DatastoreOptions.newBuilder()
                    .setProjectId("internship-full")
                    .setCredentials(getApplicationDefault())
                    .build().getService();
        } catch (IOException e) {
            datastore = DatastoreOptions.newBuilder()
                    .setProjectId("internship-full")
                    .build().getService();
        }
    }

    //DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
   // DatastoreEmulatorOptions datastore = new DatastoreEmulatorOptions.Builder().setProjectId("internship-full").build(
//    static Datastore datastore = DatastoreOptions.newBuilder().setProjectId("internship-full")
//                .setHost("http://localhost:8380").setNamespace("employeeDetails").build().getService();

//    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
   // Datastore datastore = datastoreOptions.
    public void generateAdmin(){
        Key admin = getKind("admin").newKey("admin");
        Entity entity = Entity.newBuilder(admin)
                .setKey(admin)
                .set("id","admin")
                .set("password","admin")
                .build();
        datastore.put(entity);
    }
    private static Key getEmployeeKey(int id){
        return  datastore.newKeyFactory().setKind("employee").newKey(id);
    }
    private static KeyFactory getKind(String kind){
        return datastore.newKeyFactory().setKind(kind);
    }
    private static Key getKey(int id,String kind){
        return  datastore.newKeyFactory().setKind(kind).newKey(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        KeyFactory empFactory = datastore.newKeyFactory().setKind("employee");
        Key key = empFactory.newKey(id);
        Entity empEntity = Entity.newBuilder(key)
                .set("id",id)
                .setKey(key)
                .set("name",employee.getName())
                .set("number",employee.getMobileNumber())
                .set("password",employee.getPassword())
                .build();
        datastore.put(empEntity);
        return id++;
    }

    @Override
    public void removeEmployee(int id) throws Exception {
        KeyFactory empFactory = datastore.newKeyFactory().setKind("employee");
        Key key = empFactory.newKey(id);
        datastore.delete(key);
    }

    @Override
    public void validateLogin(String id, String password) throws Exception {
        Key key = getKind("admin").newKey(id);
        Entity entity = datastore.get(key);
        if(!entity.getString("password").equals(password)) throw new Exception("Wrong Password");
    }
    @Override
    public void validateLogin(Integer id, String password) throws Exception {
        Key key = getKind("employee").newKey(id);
        Entity entity = datastore.get(key);
        if(entity == null) throw new Exception("User ID Not Found");
        if(!entity.getString("password").equals(password)) throw new Exception("Wrong Password");
    }
    public Entity getEmployee(int id){
        Key key = getKind("employee").newKey(id);
        return datastore.get(key);
    }

    @Override
    public Entity updateDetails(int id, String name, String number) {
        Entity entity = datastore.get(getEmployeeKey(id));
        Entity updatedEntity = Entity.newBuilder(entity)
                .set("name",name)
                .set("number",number)
                .build();
        datastore.update(updatedEntity);
        return entity;
    }

    public QueryResults<Entity> getAllDetails(){
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind("employee")
                .build();
        return datastore.run(query);
    }
}
