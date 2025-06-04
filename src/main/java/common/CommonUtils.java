package common;

import constants.Url;

import enums.ServiceName;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CommonUtils {

    public static RequestSpecification buildRequestSpecification(String env, ServiceName serviceName){
        String baseUrl = Url.getBaseURL(env);
        String url = baseUrl + serviceName.getBasePath();
        return new RequestSpecBuilder().setBaseUri(url).setContentType("application/json").build();
    }


    public static String readResourceFile(String fileName) {
        try (InputStream is = CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
             Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource file: " + fileName, e);
        }
    }

}
