package com.kudtech.stockmanagement.productservices.exception.exceptions;


import com.kudtech.stockmanagement.productservices.enums.Language;
import com.kudtech.stockmanagement.productservices.exception.enums.IFriendlyMessageCode;
import com.kudtech.stockmanagement.productservices.exception.enums.utils.FriendlyMessageUtils;
import com.kudtech.stockmanagement.productservices.response.FriendlyMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ProductNotCreatedException extends RuntimeException{ // servicte producta gonderdigimiz request eklenememis durumu runtıme ile extends ettik


    private final Language language ;
    private final IFriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode,String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        // bu hata aldıgında calısacak ondan dolayı logerror ekliyecegiz
        log.error("[ProductNotCreatedException] -> message: {} developer message: {}",FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode),message);// burada message developer messagı olcak
    }
}
