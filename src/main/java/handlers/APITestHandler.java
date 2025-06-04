package handlers;

import reporting.ExtentReport;

public class APITestHandler implements TestHandler{
    @Override
    public void beforeSuite() {
        // API test suite before suite goes here
        System.out.print("### API Test Handler before suite Initiated ######");
        ExtentReport.createReport();
    }

    @Override
    public void afterSuite() {
     // API test suite after suite goes here
        System.out.print("### API Test Handler after  suite Initiated ######");
        if(ExtentReport.extentReport == null){
            System.out.println("##### extent report is null #############");
        }
        ExtentReport.extentReport.flush();
    }





}
