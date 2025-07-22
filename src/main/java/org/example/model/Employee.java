package org.example.model;

import net.snowflake.client.jdbc.internal.fasterxml.jackson.databind.node.ObjectNode; // For Variant, adjust import as needed

public class Employee {
    
    private String customerId;
    private String siteId;
    private String offerings;
    private Integer offeringPrice;
    private Integer offeringsEUC;
    private String offeringType;
    private Integer offeringInvestment;
    private String productCode;
    private Integer productsEUC;
    private Integer productUnitPrice;
    private Object CSA; // Use Object for Variant, adjust as needed for your environment
 
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getSiteId() { return siteId; }
    public void setSiteId(String siteId) { this.siteId = siteId; }

    public String getOfferings() { return offerings; }
    public void setOfferings(String offerings) { this.offerings = offerings; }

    public Integer getOfferingPrice() { return offeringPrice; }
    public void setOfferingPrice(Integer offeringPrice) { this.offeringPrice = offeringPrice; }

    public Integer getOfferingsEUC() { return offeringsEUC; }
    public void setOfferingsEUC(Integer offeringsEUC) { this.offeringsEUC = offeringsEUC; }

    public String getOfferingType() { return offeringType; }
    public void setOfferingType(String offeringType) { this.offeringType = offeringType; }

    public Integer getOfferingInvestment() { return offeringInvestment; }
    public void setOfferingInvestment(Integer offeringInvestment) { this.offeringInvestment = offeringInvestment; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public Integer getProductsEUC() { return productsEUC; }
    public void setProductsEUC(Integer productsEUC) { this.productsEUC = productsEUC; }

    public Integer getProductUnitPrice() { return productUnitPrice; }
    public void setProductUnitPrice(Integer productUnitPrice) { this.productUnitPrice = productUnitPrice; }

    public Object getCSA() { return CSA; }
    public void setCSA(Object CSA) { this.CSA = CSA; }
}
