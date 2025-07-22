package org.example.service;

import org.example.model.siteOfferings;
import org.example.model.CustomerType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Customer Categorization service.
 * @author Praveen.Nair
 */
public class ProductPOVService {

    private final KieContainer kieContainer;

    public ProductPOVService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public CustomerType getCustomerType(siteOfferings siteOfferings) {
        CustomerType customerType = new CustomerType(0);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("customerType", customerType);
        kieSession.insert(siteOfferings);        
        kieSession.fireAllRules();
        kieSession.dispose();
        return customerType;
    }
}
