package com.example.swagger.result;

public enum GlobalErrorInfoEnum implements ErrorInfoInterface {
    //注意枚举的使用的方式
    SUCCESS("0", "success"), NOT_FOUND("-1", "service not found");

    private String code;
    private String message;

    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
