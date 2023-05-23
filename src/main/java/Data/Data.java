package Data;

import DTO.Employee;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;


import java.util.HashMap;
import java.util.UUID;

public class Data {

    private static HashMap<Integer, Employee> database = new HashMap<>();

    public static HashMap<Integer, Employee> getDatabase(){
        return database;
    }
    public static void setDatabase(HashMap<Integer,Employee> data){
        database = data;
    }


        // Datastore datastore = DatastoreOptions.newBuilder().setProjectId().build().getService();
//    DatastoreOptions options = new DatastoreOptions.Builder().projectId("oiag").build();
//
//    Datastore factory = DatastoreFactory.get().create(options);
//
//    Datastore datastore =  DatastoreFactory.get().create(new DatastoreOptions.Builder().projectId("internship-full").build());
//
//    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
//    AsyncDatastoreService asyncDatastoreService = DatastoreServiceFactory.getAsyncDatastoreService();

    Datastore datastore = DatastoreOptions.newBuilder().setProjectId("").build().getService();



    @Override
    public String toString() {
        return super.toString();
    }
}
