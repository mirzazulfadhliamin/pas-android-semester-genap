package com.example.pasandroidsemester2;

import retrofit2.Call;
import retrofit2.Response;

public class ErrorResponseChecker<T> {

    private Response<T> response;

    public ErrorResponseChecker(Response<T> response) {
        this.response = response;
    }

    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    public boolean isBodyNull() {
        try {
            return response.body() == null;
        } catch (Exception e) {
            return true;
        }
    }

    public int getCodeError() {
        return response.code();
    }

    public boolean isCodeError() {
        return response.code() > 399;
    }

}
