package com.lccf.util;

/**
 * @author  lichangchao
 * @功能 返回json格式数据
 * @deprecated
 */
public class ResultJson {
      private int code;
      private String msg;
      private Object data;
    public ResultJson(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultJson(int resultCode, String message, Object b ){
        this.code = resultCode;
        this.msg = message;
        this.data = b;
    }
    public  ResultJson(int resultCode,Object b){
        this.code =resultCode;
        this.data = b;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
