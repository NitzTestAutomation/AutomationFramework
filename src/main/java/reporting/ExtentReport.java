package reporting;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.Constants;
import org.joda.time.LocalDateTime;

import java.io.File;

public class ExtentReport {
    public static ExtentReports extentReport;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    public static void createReport(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String path = System.getProperty("user.dir")+"/Reports"+ File.separator+ "TestReport" + localDateTime.getYear()+"_"+
                localDateTime.getMonthOfYear()+"_"+
                localDateTime.getDayOfMonth()+"_"+
                localDateTime.getHourOfDay()+"_"+
                localDateTime.getMinuteOfHour()+"_"+
                localDateTime.getSecondOfMinute()+
                ".html";
        extentReport = reportManager(path);
    }


    public static ExtentReports reportManager(String filePath){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName("<b>"+"<font size=5>"+ Constants.executionType.toUpperCase()+" Test Automation Report"+"</font>"+"</b>");
        extentSparkReporter.config().setDocumentTitle(Constants.executionType.toUpperCase());
        extentSparkReporter.config().setTheme(Theme.DARK);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setAnalysisStrategy(AnalysisStrategy.SUITE);
        return extentReports;
    }

    public void createNode(String testCaseName){
        extentTest.set(extentReport.createTest(testCaseName));
    }


    public static void log(Status status, String expectedJson, String actualJson){
        switch(status){
            case FAIL:
                extentTest.get().fail("<b>Expected JSON: " +expectedJson+"</b>");
                extentTest.get().fail("<b>Actual JSON: " +actualJson+"</b>");
        }
    }
    public static void log(Status status, String log){

        switch(status){
            case PASS:
                extentTest.get().log(Status.PASS,log);
                break;
            case FAIL:
                extentTest.get().log(Status.FAIL,log);
                break;
            case INFO:
                extentTest.get().log(Status.INFO,log);
                break;
        }
    }

}
