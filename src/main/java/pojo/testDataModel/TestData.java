package pojo.testDataModel;

import lombok.Data;

import java.util.List;

@Data
public class TestData {
    private String testCaseName;
    private String testCaseDescription;
    private String payload;
    private String expectedData;
}
