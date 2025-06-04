package enums;

public enum StatusCode {
    SUCCESS(200),
    NOT_FOUND(404);


    private final int statusCode;
    StatusCode(int statusCode){
        this.statusCode=statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }
}
