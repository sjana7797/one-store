package dev.sanjayjana.one_store.response;

public class SuccessApiResponse<T> extends ApiResponse<T> {
    public SuccessApiResponse(T data, String message) {
        super(data, message, false);
    }
}
