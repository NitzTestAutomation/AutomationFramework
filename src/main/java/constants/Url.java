package constants;

public final class Url {
    public static String QA_URL = "https://dummyjson.com";
    public static String DEV_URL="";
    public static String PRE_PROD_URL="";
    public static String GET_ALL_PRODUCTS= "/products";

    // Return URL based on the env
    public static String generateURL(String env,String serviceName){
        switch(env){
            case "QA" :
                if(serviceName.equalsIgnoreCase("get_all_products")) return QA_URL+GET_ALL_PRODUCTS;

            default: throw new RuntimeException("Invalid options");
        }
    }

    public static String getBaseURL(String env){
        switch(env){
            case "QA" :
                return QA_URL;
            default: throw new RuntimeException("Invalid env option");
        }
    }

}
