package com.lccf.enums;


/**
 * @author lichangchao
 * @Time 2017 -04-06 16:33:06
 */
public enum EUserStatus {
    FREEZE(0,"激活状态"),
    ACTIVITED(1,"未激活状态");
    private int key;
    private String value;
    EUserStatus(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }



    public String getValue() {
        return value;
    }

}
