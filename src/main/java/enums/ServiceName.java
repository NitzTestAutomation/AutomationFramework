package enums;

public enum ServiceName {
    GET_ALL_PRODUCTS("/products"),
    GET_ALL_CARTS("/carts");

    private final String basePath;
    ServiceName(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath(){
        return this.basePath;
    }
}
