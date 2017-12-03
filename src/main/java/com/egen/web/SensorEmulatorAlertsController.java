package com.egen.web;

import java.sql.Timestamp;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.egen.model.Alerts;
import com.egen.model.Metrics;
import com.egen.rules.AlertsRulesEngine;
import com.egen.services.AlertsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class SensorEmulatorAlertsController {
	@Autowired
	private AlertsService alertsService;
	
	@Autowired
	private AlertsRulesEngine alertsRulesEngine;	
			
	
	@RequestMapping(value = "/read", method = { RequestMethod.GET })
	public List<Alerts> readAlerts()
	{
		List<Alerts> alerts = alertsService.read();
		return alerts;
	}
	
	@RequestMapping(value = "/readByTimeRange", method = { RequestMethod.GET })
	public List<Alerts> readAlertsByTimeRange(@RequestParam(value = "startTm") Timestamp stTm,
			@RequestParam(value = "endTm") Timestamp endTm){
		List<Alerts> alerts = alertsService.readByTimeRange(stTm, endTm);
		return alerts;
	}
	
	@RequestMapping(value = "/fireRules", method = { RequestMethod.POST })
	@Consumes(MediaType.APPLICATION_JSON)
	public void fireRules(@RequestBody Metrics metrics)
	{
		alertsRulesEngine.runRules(metrics);
	}
}
