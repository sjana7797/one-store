package dev.sanjayjana.one_store.response;


import lombok.Data;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;
    private boolean error;


    public ApiResponse(T data, String message, boolean error) {
        this.setData(data);
        this.setMessage(message);
        this.setError(error);
    }

}
