package reporting;


import com.aventstack.extentreports.Status;
import constants.Constants;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        if(result.getThrowable()!=null){
            ExtentReport.log(Status.FAIL,"Execution Failed: "+result.getThrowable().getMessage());
        }else{
            ExtentReport.log(Status.FAIL,"Unknown exception occurred");
        }
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReport.log(Status.SKIP, "Test Execution Skipped");
    }
}
