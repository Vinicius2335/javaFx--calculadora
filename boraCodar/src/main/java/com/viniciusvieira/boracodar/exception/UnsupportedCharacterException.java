package com.viniciusvieira.boracodar.exception;

import java.io.Serial;

public class UnsupportedCharacterException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -4843095035740732012L;

    public UnsupportedCharacterException(String message) {
        super(message);
    }

    public UnsupportedCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
}
