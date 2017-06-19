package com.lccf.util;

import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取国际化信息
 */
public class TranslatorHelper {

    public static String get(String key, String... args) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return key;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        if (request == null) {
            return key;
        }
        MessageSource messageSource = SpringUtil.getBean("messageSource",MessageSource.class);
        String message = messageSource.getMessage(key, args,RequestContextUtils.getLocaleResolver(request).resolveLocale(request));
        return message;
    }

    public static String get(String key) {
        return TranslatorHelper.get(key, new String[0]);
    }
}
