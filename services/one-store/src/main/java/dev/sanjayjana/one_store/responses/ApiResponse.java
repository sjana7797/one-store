package dev.sanjayjana.one_store.responses;


import lombok.Data;
import lombok.Setter;

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
