package handlers;

public class UITestHandler implements TestHandler{
    @Override
    public void beforeSuite() {
        System.out.printf("### UI Test Handler before suite Initiated ######");
    }

    @Override
    public void afterSuite() {

    }
}
