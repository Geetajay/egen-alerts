package com.egen.rules;

import com.egen.model.Alerts;
import com.egen.model.Metrics;
import com.egen.rules.AbstractAlertRule;
import com.egen.services.SpringContextBridge;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;


@Rule(description="AlertRule2",name="AlertRule2")
public class AlertRule2 extends AbstractAlertRule{

	@Override 
	public boolean evaluate() {
		Metrics metric = getMetric();	
		System.out.println("Rule2 metric --" + metric);
        if (metric == null) return false;
        long baseWeight = metric.getBaseWt();
        long actualWt = metric.getActualWt();
        long percentVal = (baseWeight * 10)/100;
        long compareVal = baseWeight - percentVal;
        System.out.println("executing rule 2 actual wt, compare value--" + metric.getActualWt() + "," + compareVal);
        if (actualWt < compareVal) return true;
        else return false;
    }
	
    @Override public void execute() {
       System.out.println("New Alert will be created for under weight");
      //call dao to persist the data
       String alertStr = "Person is under weight";
       Alerts alert = new Alerts();
       alert.setAlertMessage(alertStr);
       //call dao to persist the data
       getAlertsService().create(alert);
    }
    
    // MUST IMPLEMENT THIS METHOD
    @Override public String getName() {
        return "2nd Down Rule";
    }
   
}
