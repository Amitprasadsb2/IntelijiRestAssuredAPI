package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilters implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilters.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("BASE URL:" + filterableRequestSpecification.getBaseUri());
        logger.info("Request Header:" + filterableRequestSpecification.getHeaders());
        logger.info("Request Payload:" + filterableRequestSpecification.getBody());
    }

    public void logResponse(Response response){
        logger.info("STATUS CODE:" + response.statusCode());
        logger.info("Response BODY:" + response.getBody().prettyPrint());
//        logger.info("Request Header:" + response.header());

    }
}
