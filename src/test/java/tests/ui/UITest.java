package tests.ui;

import handlers.ExecutionEngine;
import org.testng.annotations.Test;

public class UITest extends ExecutionEngine {
    @Test(alwaysRun = true)
    public void testUI(){

        System.out.printf("######## Ran the UI test ######");
    }
}
