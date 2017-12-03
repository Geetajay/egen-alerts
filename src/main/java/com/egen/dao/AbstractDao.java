package com.egen.dao;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractDao {

	protected Datastore datastore = null;
	
	protected Datastore createDatastore(){
		if(datastore == null){
			 String dbName = new String("Alerts");
			 MongoClient mongo = new MongoClient("127.0.0.1", 27017);
			 Morphia morphia = new Morphia();
		     datastore = morphia.createDatastore(mongo, dbName);      
		 
		     morphia.mapPackage("com.city81.mongodb.morphia.entity");
		}
	    return datastore;         
	}
	
}
