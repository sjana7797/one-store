package dev.sanjayjana.one_store.exceptions;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException() {
        super("Unauthorized Request");
    }
}
