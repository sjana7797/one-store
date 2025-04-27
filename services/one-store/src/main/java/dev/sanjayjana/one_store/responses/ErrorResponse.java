package dev.sanjayjana.one_store.responses;

public class ErrorResponse<T> extends ApiResponse<T> {
    public ErrorResponse(String message) {
        super(null, message, true);
    }
}
