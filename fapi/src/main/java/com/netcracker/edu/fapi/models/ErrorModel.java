package com.netcracker.edu.fapi.models;

public class ErrorModel {
    private boolean isError;

    public ErrorModel(boolean isError) {
        this.isError = isError;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
