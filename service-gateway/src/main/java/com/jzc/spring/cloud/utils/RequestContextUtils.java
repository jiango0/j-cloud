package com.jzc.spring.cloud.utils;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

public class RequestContextUtils {

    private static Logger logger = LoggerFactory.getLogger(RequestContextUtils.class);

    public static String getBody(RequestContext context) {
        String body = null;
        if(context == null) {
            return null;
        }

        try {
            body = StreamUtils.copyToString(context.getResponseDataStream(), Charset.forName("UTF-8"));
            if(StringUtils.isBlank(body)){
                return null;
            }

        } catch (Exception e) {
            logger.error("获取getResponseDataStream失败", e);
        }

        return body;
    }

}
