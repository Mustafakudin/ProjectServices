package com.kudtech.stockmanagement.productservices.exception.enums.utils;


import com.kudtech.stockmanagement.productservices.enums.Language;
import com.kudtech.stockmanagement.productservices.exception.enums.IFriendlyMessageCode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
@UtilityClass
public class FriendlyMessageUtils {

    public static final String RESOURCE_BUNDLE_NAME = "FriendlyMessage ";
    public static final String SPECİAL_CHARACTER = "";

    public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode) {
        String messageKey = null;
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECİAL_CHARACTER + messageCode;
            return resourceBundle.getString(messageKey);
        } catch (MissingResourceException missingResourceException) {
            log.error("Friendly message not found for key : {}", messageKey);
            return null;
        }
    }
}