package pojo.testDataModel;

import lombok.Data;

import java.util.HashMap;

@Data
public class TestFile {
    private HashMap<String,EnvTestData> testFile;
}
