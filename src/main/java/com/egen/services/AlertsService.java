package com.egen.services;

import java.sql.Timestamp;
import java.util.List;

import com.egen.dao.AlertsDao;
import com.egen.model.Alerts;
import com.egen.rules.AlertsRulesEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlertsService {
	
	@Autowired
	private AlertsDao alertsDao;
	

	public void create(Alerts alert){
		alertsDao.create(alert);
	}

	public List<Alerts> read(){
		return alertsDao.read();
	}
	
	public List<Alerts> readByTimeRange(Timestamp stTm, Timestamp endTm){
		return alertsDao.readByTimeRange(stTm, endTm);
	}	
	
}
