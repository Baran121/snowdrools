package org.example.udft;

import java.util.stream.Stream;
import com.snowflake.snowpark_java.types.Variant;

import org.example.configuration.OfferingsPOVDroolsConfig;
import org.example.model.siteOfferings;
import org.example.model.CustomerType;
import org.example.service.OfferingsPOVService;

/**
 * Customer Categorization UDTF (see https://docs.snowflake.com/en/developer-guide/udf/java/udf-java-tabular-functions)
 * This is the actual categorization UDTF,
 * it will leverage the Drools Rule
 * @author mauricio.rojas
 */
public class CustomerCategorizeUDTFHandler {

    private transient OfferingsPOVService service=null;

    public CustomerCategorizeUDTFHandler() {

    }

    private void setupService() {
        var config = new OfferingsPOVDroolsConfig();
        var container = config.kieContainer();
        this.service = new OfferingsPOVService(container);
    }

    public static Class getOutputClass() {
      return CustomerType.class;
    }

    public Stream<CustomerType> process(String customerId, String siteId, 
    String offerings, Integer offeringPrice, Integer offeringsEUC, String offeringType, 
    Integer offeringInvestment, String productCode, Integer productsEUC, Integer productUnitPrice, Variant CSA) {
        if (this.service == null) setupService();
        var siteOfferings = new siteOfferings( customerId, siteId, offerings, offeringPrice, offeringsEUC, offeringType, offeringInvestment, productCode, productsEUC, productUnitPrice, CSA);
        var response = this.service.getCustomerType(siteOfferings);
        return Stream.of(response);
    }

}

 