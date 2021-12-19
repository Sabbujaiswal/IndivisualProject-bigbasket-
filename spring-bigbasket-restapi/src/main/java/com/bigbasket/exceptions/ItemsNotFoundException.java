package com.bigbasket.exceptions;

public class ItemsNotFoundException extends RuntimeException {
    public ItemsNotFoundException() {
    }

    public ItemsNotFoundException(String message) {
        super(message);
    }
}
