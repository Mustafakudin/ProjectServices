package com.kudtech.stockmanagement.productservices.exception.enums;

public enum FriendlyMessageCode implements IFriendlyMessageCode {
    OK(1000),
    SUCCES(1002),
    ERROR(1001),
    PRODUCT_NOT_CREATED_EXCEPTION(1500),
    PRODUCT_SUCCESSFULLY_CREATED (1501);



    private final int value;

    FriendlyMessageCode(int value) {
        this.value=value;
    }
    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}

