package dev.sanjayjana.one_store.responses;

public class SuccessApiResponse<T> extends ApiResponse<T> {
    public SuccessApiResponse(T data, String message) {
        super(data, message, false);
    }
}
