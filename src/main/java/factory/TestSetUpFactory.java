package factory;

import handlers.APITestHandler;
import handlers.TestHandler;
import handlers.UITestHandler;

public class TestSetUpFactory {

    public static TestHandler getHandler(String executionType){
        switch(executionType.toUpperCase()){
            case "API":
                return new APITestHandler();
            case "UI":
                return new UITestHandler();
            default:
                throw new IllegalArgumentException("Unsupported Execution Type: "+executionType);
        }
    }
}
