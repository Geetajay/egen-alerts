package com.egen.rules;

import com.egen.model.Metrics;

import org.springframework.stereotype.Component;

import com.egen.rules.AlertRule1;
import com.egen.rules.AlertRule2;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

@Component
public class AlertsRulesEngine {	
	public void runRules(Metrics metric){
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().withSkipOnFirstFailedRule(true).build();
		//RulesEngine rulesEngine = aNewRulesEngine().build();
		AlertRule1 rule1 = new AlertRule1();
		rule1.setMetrics(metric);
		AlertRule2 rule2 = new AlertRule2();
		rule2.setMetrics(metric);
		rulesEngine.registerRule(rule1);
		rulesEngine.registerRule(rule2);
		rulesEngine.fireRules();
	}
	
	
	public void initializeRules(){
		
	}
}
