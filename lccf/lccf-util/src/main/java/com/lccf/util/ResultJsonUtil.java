package com.lccf.util;


import com.lccf.enums.EResultCode;

/**
 * @author lichangchao
 * @功能 返回json格式数据
 * @deprecated
 */
public class ResultJsonUtil {
   /** 统一失败成功返回码**/
    public static ResultJson failResult(String Message) {
        return new ResultJson(EResultCode.FAIL.getKey(), Message);
    }
    public static ResultJson failResult(String Message, Object b) {
        return new ResultJson(EResultCode.FAIL.getKey(), Message, b);
    }

    public static ResultJson successResult(String Message) {
        return new ResultJson(EResultCode.SUCCESS.getKey(), Message);
    }

    public static ResultJson successResult (String Message, Object b) {
        return new ResultJson(EResultCode.SUCCESS.getKey(), Message, b);
    }

   /**自定义返回码**/
    public static ResultJson resultJson (int code , String Message) {
        return new ResultJson(code, Message);
    }

    public static ResultJson resultJson(int code , String Message, Object b) {
        return new ResultJson(code, Message,b);
    }

    public class failResult {
        public failResult(String errorInfo) {
        }
    }
}
