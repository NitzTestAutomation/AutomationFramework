package assertions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import enums.StatusCode;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Assertion {

    public static <T> void assertEquals(T actual, T expected){
        Assert.assertEquals(actual, expected);
    }

    public static void validateResponse(Response response , StatusCode statusCode, String schemaFilePath, ExtentTest test){
        try {
            response.then().statusCode(statusCode.getStatusCode())
                    .contentType("application/json")
                    .body(matchesJsonSchemaInClasspath(schemaFilePath));
        }catch(Throwable e){
            test.log(Status.INFO,response.prettyPrint());
            throw e;
        }
    }
}
