package com.egen.services;
 
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextBridge implements SpringContextBridgedServices, ApplicationContextAware {

	private static ApplicationContext applicationContext;
    
	@Autowired
    private AlertsService alertsService; 

	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
  
    public static SpringContextBridgedServices services() {
        return applicationContext.getBean(SpringContextBridgedServices.class);
    }

    @Override
    public AlertsService getAlertsService() {
        return alertsService; //Return the Autowired alertsService
    }
}
