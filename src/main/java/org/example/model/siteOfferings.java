package org.example.model;

import java.util.Objects;
import java.util.StringJoiner;
import com.snowflake.snowpark_java.types.Variant;
import org.json.JSONObject;
import java.util.Map;
/**
 * Customer request POJO.
 * @author Praveen.Nair
 */
public final class siteOfferings {

    

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
    private Variant CSA;
    

    

    // Constructor
    public siteOfferings() {}

    // All-args constructor
    public siteOfferings(String customerId, String siteId, String offerings, Integer offeringPrice, Integer offeringsEUC, String offeringType, Integer offeringInvestment, String productCode, Integer productsEUC, Integer productUnitPrice, Variant CSA) {
         
        this.customerId = customerId;
        this.siteId = siteId;
        this.offerings = offerings;
        this.offeringPrice = offeringPrice;
        this.offeringsEUC = offeringsEUC;
        this.offeringType = offeringType;
        this.offeringInvestment = offeringInvestment;
        this.productCode = productCode;
        this.productsEUC = productsEUC;
        this.productUnitPrice = productUnitPrice;
        this.CSA = CSA;
    }

    
    //getters and setters for csaAttributes
    public Map<String, Object>  getCSA() {
        return (new JSONObject(CSA.toString())).toMap();
    }
    public void setCSA(Variant CSA) {
        this.CSA = CSA;
    } 

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getOfferings() {
        return offerings;
    }

    public void setOfferings(String offerings) {
        this.offerings = offerings;
    }

    public int getOfferingPrice() {
        return offeringPrice;
    }

    public void setOfferingPrice(int offeringPrice) {
        this.offeringPrice = offeringPrice;
    }

    public int getOfferingsEUC() {
        return offeringsEUC;
    }

    public void setOfferingsEUC(int offeringsEUC) {
        this.offeringsEUC = offeringsEUC;
    }

    public String getOfferingType() {
        return offeringType;
    }

    public void setOfferingType(String offeringType) {
        this.offeringType = offeringType;
    }

    

    public int getPotentialOfferingLevelInvestment() {
        return offeringInvestment;
    }

    public void setPotentialOfferingLevelInvestment(int offeringInvestment) {
        this.offeringInvestment = offeringInvestment;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductsEUC() {
        return productsEUC;
    }

    public void setProductsEUC(int productsEUC) {
        this.productsEUC = productsEUC;
    }

    public int getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(int productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    @Override
    public String toString() {
        return "OfferingsDetails{" +
                "customerId='" + customerId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", offerings='" + offerings + '\'' +
                ", offeringPrice=" + offeringPrice +
                ", offeringsEUC=" + offeringsEUC +
                ", offeringType='" + offeringType + '\'' +
                ", potentialOfferingLevelInvestment=" + offeringInvestment +
                ", productCode='" + productCode + '\'' +
                ", productsEUC=" + productsEUC +
                ", productUnitPrice=" + productUnitPrice +
                '}';
    }
}
