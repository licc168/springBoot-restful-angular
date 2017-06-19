package com.lccf.enums;

import com.lccf.util.CustomUUID;

/**
 * 生成全局唯一码 采用单列模式
 * @see <a href="http://www.jianshu.com/p/61817cf48cc3">简书介绍</a>
 *
 * @author lichangchao
 * @Time 2017 -04-13 20:44:26
 */
public enum ECustomUUID {
     INSTANCE;
     private  CustomUUID customUUID;
     ECustomUUID(){
            customUUID = new CustomUUID(12);
    }
    public CustomUUID getInstance() {
            return customUUID;
    }
}
