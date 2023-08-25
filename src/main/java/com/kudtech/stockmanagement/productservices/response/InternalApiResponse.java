package com.kudtech.stockmanagement.productservices.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class InternalApiResponse <T>{

    private FriendlyMessage friendlyMessage;
    private T payload; // genelde response vericez ondan dolayı T GENERİC YAPI YAPTIK
    private boolean hasError; // bu alan error olusup olusmadıgını tutacak
    private List<String> errorMessages;//ERRORLARIN NE OLDUGUNU İÇERİCEK
    private HttpStatus httpStatus; // BU DA NOTFOUND BADREQUEST OK VS HTTP STATUSLARI TUTACAK
}
