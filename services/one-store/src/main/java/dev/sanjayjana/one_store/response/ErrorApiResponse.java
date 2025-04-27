package dev.sanjayjana.one_store.response;

public class ErrorApiResponse<T> extends ApiResponse<T> {
    public ErrorApiResponse(String message) {
        super(null, message, true);
    }
}
