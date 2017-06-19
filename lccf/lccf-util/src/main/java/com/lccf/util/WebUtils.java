package com.lccf.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Filename WebUtils.java
 * @Data 2016-10-18 11:34
 * @Author lichangchao
 * @deprecated
 */
public abstract class WebUtils {
    private static Logger logger = LoggerFactory.getLogger(WebUtils.class);
    /**
     * 判断是否为XHR请求
     * @param request
     * @return
     */
    public static boolean isXhr(HttpServletRequest request) {
        return request.getHeader(HttpHeaders.X_REQUESTED_WITH) != null;
    }


    /**
     * 返回Ajax请求
     * @param response
     * @param responseVo
     */
    public static void responseAjax(HttpServletResponse response, Object responseVo) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            String result = mapper.writeValueAsString(responseVo);
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getOutputStream().write(result.getBytes("UTF-8"));
            response.getOutputStream().flush();
        } catch (IOException e) {
            logger.error("Ajax返回值异常", e);
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                logger.error("写流关闭失败", e);
            }
        }
    }
}
