package com.example.asusx550jx.androidtraining_2.Model;

/**
 * Created by Asus X550JX on 12/20/2017.
 */

public class ResponseModel {
    String message;
    int code;

    public ResponseModel(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
