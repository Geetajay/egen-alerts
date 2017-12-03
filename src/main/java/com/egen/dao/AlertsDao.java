package com.egen.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.egen.dao.AbstractDao;
import com.egen.model.Alerts;
import com.egen.model.Metrics;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Repository;

@Repository
public class AlertsDao extends AbstractDao{

	public void create(Alerts alert){
		 Datastore datastore = createDatastore();      
	     Calendar cal = Calendar.getInstance();
	     Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
	     alert.setAlertTimeStmp(timestamp); 
	         
	     Key<Alerts> savedAlert = datastore.save(alert);   
	     System.out.println(savedAlert.getId());
	}
	
	public List<Alerts> read(){
		Datastore datastore = createDatastore();
		Query<Alerts> query = datastore.createQuery(Alerts.class);
		List<Alerts> alertList = query.asList();
	   /* QueryResults<Alerts> allAlerts =  datastore.find(query); 
	    if(allAlerts != null){
	    	alertList = allAlerts.asList();
	    }*/
	    return alertList;
	}
	
	public List<Alerts> readByTimeRange(Timestamp stTm, Timestamp endTm){
		Datastore dataStore = createDatastore();
		Query<Alerts> query = datastore.createQuery(Alerts.class);
		query.field("alertTimeStmp").greaterThanOrEq(stTm);
		query.field("alertTimeStmp").lessThan(endTm);
		List<Alerts> alerts = query.asList();
		return alerts;
	}
}
