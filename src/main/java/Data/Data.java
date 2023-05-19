package Data;

import Model.Employee;
import com.google.appengine.api.datastore.AsyncDatastoreService;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceConfig;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.repackaged.com.google.datastore.v1.client.Datastore;
import com.google.appengine.repackaged.com.google.datastore.v1.client.DatastoreFactory;
import com.google.appengine.repackaged.com.google.datastore.v1.client.DatastoreOptions;


import java.util.HashMap;

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

    @Override
    public String toString() {
        return super.toString();
    }
}
