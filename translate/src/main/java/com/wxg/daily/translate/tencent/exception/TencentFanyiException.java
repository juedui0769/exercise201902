package com.wxg.daily.translate.tencent.exception;

public class TencentFanyiException extends RuntimeException {
    public TencentFanyiException() {
    }

    public TencentFanyiException(String message) {
        super(message);
    }

    public TencentFanyiException(String message, Throwable cause) {
        super(message, cause);
    }

    public TencentFanyiException(Throwable cause) {
        super(cause);
    }

    public TencentFanyiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
