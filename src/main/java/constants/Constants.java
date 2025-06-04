package constants;

public final class Constants {
    public static String executionType;
    public static String suiteXmlFile;
    public static String env;
    public static String products_schema_file_path="schema/products.json";

    public static void readParams(){
        System.out.print("#### reading the params ####");
        env= System.getProperty("env");
        System.out.println(env);
        executionType=System.getProperty("executionType");
        System.out.println(executionType);
        System.out.println(System.getProperty("suiteXmlFile"));
    }
}
