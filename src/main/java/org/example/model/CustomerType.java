package org.example.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * CustomerType Response model.
 * @author Praveen.Nair
 */
public class CustomerType {


    // When working with Snowpark do consider the DataType 
    // Mapping considerations: https://docs.snowflake.com/en/developer-guide/udf-stored-procedure-data-type-mapping#sql-java-data-type-mappings

    public int customerType = 0;

    public CustomerType(int customerType) {
        this.customerType = customerType;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerType that = (CustomerType) o;
        return customerType == that.customerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerType.class.getSimpleName() + "[", "]")
                .add("customerType=" + customerType)
                .toString();
    }
}
