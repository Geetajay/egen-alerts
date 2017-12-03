package com.egen.rules;
import org.easyrules.core.BasicRule;
import org.springframework.beans.factory.annotation.Autowired;

import com.egen.model.Metrics;
import com.egen.services.AlertsService;
import com.egen.services.SpringContextBridge;

import org.springframework.stereotype.Component;

//@Component
public class AbstractAlertRule extends BasicRule{
	protected Metrics metric;
	

    protected void setMetrics(Metrics metric) {
        this.metric = metric;
    }
    
    protected Metrics getMetric(){
    	System.out.println("metric -- " + metric);
    	return metric;
    }
    
    protected AlertsService getAlertsService(){
    	return SpringContextBridge.services().getAlertsService();
    }
}
