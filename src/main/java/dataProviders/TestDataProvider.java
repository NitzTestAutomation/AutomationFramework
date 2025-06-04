package dataProviders;

import annotations.ProvideData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonUtils;
import constants.Constants;
import org.testng.annotations.DataProvider;
import pojo.testDataModel.EnvTestData;
import pojo.testDataModel.TestData;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name="getTestDataForAPI")
    public static Object[][] getTestDataForAPI(Method m) throws JsonProcessingException {
        ProvideData provideData = m.getAnnotation(ProvideData.class);
        String[] dataFilePaths = provideData.dataFilePaths();
        Collection<TestData> res = new ArrayList<>();
        for(String dataFilePath:dataFilePaths){
          String jsonData = CommonUtils.readResourceFile(dataFilePath);
          if(jsonData!=null){
              // push it to a collection .....
              ObjectMapper objectMapper = new ObjectMapper();
              Map<String, EnvTestData> envMap = objectMapper.readValue(
                      jsonData, new com.fasterxml.jackson.core.type.TypeReference<Map<String, EnvTestData>>() {}
              );
              EnvTestData envTestData = envMap.get(Constants.env.toLowerCase());
              if (envTestData != null && envTestData.getTestData() != null) {
                  res.addAll(envTestData.getTestData());
              }
          }
        }

        if(!res.isEmpty()){
            int numRows = res.size();
            int numCols = TestData.class.getDeclaredFields().length;
            Object[][] dataSet = new Object[numRows][numCols];
            int rowIndex = 0;
            for (TestData data : res) {
                int colIndex = 0;
                for (java.lang.reflect.Field field : TestData.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        Object fieldValue = field.get(data);
                        dataSet[rowIndex][colIndex] = fieldValue;

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    colIndex++;
                }
                rowIndex++;
            }
            return dataSet;

        } throw new RuntimeException("Invalid File name/path");
    }
}
