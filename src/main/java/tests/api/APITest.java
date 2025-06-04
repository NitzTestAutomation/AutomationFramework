package tests.api;


import annotations.ProvideData;
import assertions.Assertion;
import com.aventstack.extentreports.ExtentTest;
import common.CommonUtils;
import constants.Constants;
import dataProviders.TestDataProvider;
import enums.ServiceName;
import enums.StatusCode;
import handlers.ExecutionEngine;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pojo.productsModel.AllProducts;
import pojo.productsModel.Products;
import reporting.ExtentReport;

import java.util.HashMap;

import static  io.restassured.RestAssured.*;

public class APITest extends ExecutionEngine {

    private static Logger log = LoggerFactory.getLogger(APITest.class);

   // @Test()
    public void testAPI(){
        ExtentReport.extentTest.set(ExtentReport.extentReport.createTest("Validate /product API"));
        ExtentTest test = ExtentReport.extentTest.get();
        RequestSpecification respec = CommonUtils.buildRequestSpecification(Constants.env, ServiceName.GET_ALL_PRODUCTS);
        HashMap<String,String> queryParameters = new HashMap<>();
        queryParameters.put("limit","3");
        Response res = given().spec(respec).when().queryParams(queryParameters).get();
        log.info(res.getBody().prettyPrint());
        Assertion.validateResponse(res, StatusCode.SUCCESS,Constants.products_schema_file_path,test);
        AllProducts allProducts = res.as(AllProducts.class);
        for(Products product : allProducts.getProducts()){
           System.out.println(product.getId());
           System.out.println("################################");
           System.out.println(product.getBrand());
           System.out.println(product.getDescription());
           System.out.println("################################");
           Assertion.assertEquals(product.getId(),1);
       }

    }

    //@Test
    public void testAPI1(){
        ExtentReport.extentTest.set(ExtentReport.extentReport.createTest("Validate /product API- Different scenario"));
        ExtentTest test = ExtentReport.extentTest.get();
        RequestSpecification respec = CommonUtils.buildRequestSpecification(Constants.env, ServiceName.GET_ALL_PRODUCTS);
        HashMap<String,String> queryParameters = new HashMap<>();
        queryParameters.put("limit","3");
        Response res = given().spec(respec).when().queryParams(queryParameters).get();
        log.info(res.getBody().prettyPrint());
        Assertion.validateResponse(res, StatusCode.NOT_FOUND,Constants.products_schema_file_path,test);
        AllProducts allProducts = res.as(AllProducts.class);
        for(Products product : allProducts.getProducts()){
            System.out.println(product.getId());
            System.out.println("################################");
            System.out.println(product.getBrand());
            System.out.println(product.getDescription());
            System.out.println("################################");
            Assertion.assertEquals(product.getId(),2);
        }
    }


    @Test(dataProvider = "getTestDataForAPI", dataProviderClass = TestDataProvider.class)
    @ProvideData(dataFilePaths = {"apitestdata/api-test.json"})
    public void test(String testCaseName, String testCaseDescription, String payload, String expectedPayload){
        System.out.println(testCaseDescription);
        System.out.println(testCaseName);
        System.out.println(payload);
        System.out.println(expectedPayload);

    }

}
