package com.kudtech.stockmanagement.productservices.exception.handler;

import com.kudtech.stockmanagement.productservices.exception.enums.FriendlyMessageCode;
import com.kudtech.stockmanagement.productservices.exception.enums.utils.FriendlyMessageUtils;
import com.kudtech.stockmanagement.productservices.exception.exceptions.ProductNotCreatedException;
import com.kudtech.stockmanagement.productservices.response.FriendlyMessage;
import com.kudtech.stockmanagement.productservices.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice // exception Handing yapabilmke için ekledik
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // request uygun olarak gonderilememesi diyebiliriz
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception) {
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.<String>builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCode.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode())) // eger bır product created edilemezse mesaj içerigini yaz
                        .build())

                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();
    }
}
