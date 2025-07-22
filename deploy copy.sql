USE database bic;
use schema MY_NEW_SCHEMA;

CREATE STAGE IF NOT EXISTS drools_tests;

PUT file://target/snowpark-java-drools-0.0.1-FAT.jar @drools_tests AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

-- PUT file://customers.csv @drools_tests AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

-- create or replace file format my_csv_format 
--     type = 'csv' 
--     field_delimiter = ',' 
--     record_delimiter = '\n'
--     parse_header = true ;

-- create or replace file format my_csv_format_read
--     type = 'csv' 
--     field_delimiter = ',' 
--     record_delimiter = '\n'
--     skip_header = 1;


-- create or replace table customers
--   using template (
--     select array_agg(object_construct(*))
--       from table(
--         infer_schema(
--             location=>'@drools_tests/customers.csv',
--             file_format=>'my_csv_format'
--     )));


-- copy into customers from @drools_tests/customers.csv
-- FILE_FORMAT = (FORMAT_NAME = 'my_csv_format_read');

CREATE OR REPLACE FUNCTION OFFERING_POV(
   
  CUSTOMER_ID STRING,
  SITE_ID STRING,
  OFFERINGS STRING,
  OFFERING_PRICE INT,
  OFFERINGS_EUC INT,
  OFFERING_TYPE STRING,
  POTENTIAL_OFFERING_LEVEL_INVESTMENT INT,
  PRODUCT_CODE STRING,
  PRODUCTS_EUC INT,
  PRODUCT_UNIT_PRICE INT,
  CSA VARIANT  
)
RETURNS TABLE(CustomerType NUMBER)
LANGUAGE JAVA
RUNTIME_VERSION = '11'
IMPORTS = ('@drools_tests/snowpark-java-drools-0.0.1-FAT.jar')
HANDLER = 'org.example.udft.CustomerCategorizeUDTFHandler'
PACKAGES = ('com.snowflake:snowpark:latest');


CREATE OR REPLACE FUNCTION PRODUCT_POV(
  
  CUSTOMER_ID STRING,
  SITE_ID STRING,
  OFFERINGS STRING,
  OFFERING_PRICE INT,
  OFFERINGS_EUC INT,
  OFFERING_TYPE STRING,
  POTENTIAL_OFFERING_LEVEL_INVESTMENT INT,
  PRODUCT_CODE STRING,
  PRODUCTS_EUC INT,
  PRODUCT_UNIT_PRICE INT,
  CSA VARIANT  
)
RETURNS TABLE(CustomerType NUMBER)
LANGUAGE JAVA
RUNTIME_VERSION = '11'
IMPORTS = ('@drools_tests/snowpark-java-drools-0.0.1-FAT.jar')
HANDLER = 'org.example.udtf.ProductPOVUDTFHandler'
PACKAGES = ('com.snowflake:snowpark:latest');

 

SELECT E.CustomerType as PRODUCT_POV , D.CustomerType, C.* FROM CUSTOMER_OFFERINGS C, 
TABLE(PRODUCT_POV(
    
    C."CUSTOMER_ID",
    C."SITE_ID",
    C."OFFERINGS",
    C."OFFERING_PRICE",
    C."OFFERINGS_EUC",
    C."OFFERING_TYPE",    
    C."POTENTIAL_OFFERING_LEVEL_INVESTMENT",
    C."PRODUCT_CODE",
    C."PRODUCTS_EUC",
    C."PRODUCT_UNIT_PRICE", 
    C."CSA"
     )

) E,
TABLE(OFFERING_POV(
    
    C."CUSTOMER_ID",
    C."SITE_ID",
    C."OFFERINGS",
    C."OFFERING_PRICE",
    C."OFFERINGS_EUC",
    C."OFFERING_TYPE",   
    C."POTENTIAL_OFFERING_LEVEL_INVESTMENT", 
    C."PRODUCT_CODE",
    C."PRODUCTS_EUC",
    C."PRODUCT_UNIT_PRICE", 
    C."CSA"
     )

) D;