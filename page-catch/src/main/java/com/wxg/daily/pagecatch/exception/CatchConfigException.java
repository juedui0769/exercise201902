package com.wxg.daily.pagecatch.exception;

public class CatchConfigException extends RuntimeException {
    public CatchConfigException() {
        super();
    }

    public CatchConfigException(String message) {
        super(message);
    }

    public CatchConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatchConfigException(Throwable cause) {
        super(cause);
    }

    protected CatchConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
