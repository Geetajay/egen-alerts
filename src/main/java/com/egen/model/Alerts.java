package com.egen.model;

import java.sql.Timestamp;

import com.egen.model.BaseEntity;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Alerts extends BaseEntity{

	private String alertMessage;
	private Timestamp alertTimeStmp;
	
	
	public Timestamp getAlertTimeStmp() {
		return alertTimeStmp;
	}
	public void setAlertTimeStmp(Timestamp alertTimeStmp) {
		this.alertTimeStmp = alertTimeStmp;
	}
	
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	
}
