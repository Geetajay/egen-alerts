package com.egen.model;

import java.sql.Timestamp;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Metrics extends BaseEntity{
	private int baseWt;	
	private int actualWt;
	private Timestamp timestampValue;
	
	
	public int getBaseWt() {
		return baseWt;
	}
	public void setBaseWt(int baseWt) {
		this.baseWt = baseWt;
	}
	
	public int getActualWt() {
		return actualWt;
	}
	public void setActualWt(int actualWt) {
		this.actualWt = actualWt;
	}
	public Timestamp getTimestampValue() {
		return timestampValue;
	}
	public void setTimestampValue(Timestamp timestampValue) {
		this.timestampValue = timestampValue;
	}
	
	
	
}