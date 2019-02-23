package com.wxg.daily.pagecatch;

public class CatchException extends RuntimeException {
    public CatchException() {
        super();
    }

    public CatchException(String message) {
        super(message);
    }

    public CatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatchException(Throwable cause) {
        super(cause);
    }

    protected CatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
