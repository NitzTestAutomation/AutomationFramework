package handlers;

import constants.Constants;
import factory.TestSetUpFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class ExecutionEngine {
    private TestHandler testHandler;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){

       Constants.readParams();
       testHandler = TestSetUpFactory.getHandler(Constants.executionType);
       testHandler.beforeSuite();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        this.testHandler.afterSuite();
    }
    public void readProperties(String env){
        // based on the env read the properties fil
    }

}
