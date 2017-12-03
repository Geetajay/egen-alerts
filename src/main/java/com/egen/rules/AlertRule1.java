package com.egen.rules;

import com.egen.model.Alerts;
import com.egen.model.Metrics;
import com.egen.rules.AbstractAlertRule;
import com.egen.services.AlertsService;
import com.egen.services.SpringContextBridge;

import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
@Rule(description="AlertRule1",name="AlertRule1")
public class AlertRule1 extends AbstractAlertRule {

	@Override public boolean evaluate() {
		Metrics metric = getMetric();
        if (metric == null) return false;
        long baseWt = metric.getBaseWt();
        long actualWt = metric.getActualWt();
        long compareVal = ((baseWt * 10)/100) + baseWt;
        System.out.println("executing rule 1 actual wt, compare value--" + metric.getActualWt() + "," + compareVal);
        if (actualWt > compareVal) return true;
        else return false;
    }
    
    @Override
    public void execute() {
    	String alertStr = "Person is ovver weight";
        System.out.println("New Alert will be created for over weight");
        Alerts alert = new Alerts();
        alert.setAlertMessage(alertStr);
        //call dao to persist the data
        getAlertsService().create(alert);
        
    }
    
    // MUST IMPLEMENT THIS METHOD
    @Override public String getName() {
        return "1st Down Rule";
    }
}
