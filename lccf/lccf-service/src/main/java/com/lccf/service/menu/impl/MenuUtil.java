package com.lccf.service.menu.impl;

import java.util.List;
import java.util.Set;

import com.lccf.domain.Menu;

public class MenuUtil {
    public static String transMenuListTOJson(List<Menu> list) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[{'path': 'pages', 'children': [");
        list.forEach(menu -> {
            stringBuffer
                .append("{'path':'" + menu.getPath() + "',").append("'data':{ 'menu':{'title':'" + menu.getTitle() + "','icon':'"
                + menu.getIcon() + "','selected':" + menu.getSelected())
                .append(",'expanded':" + menu.getSelected() + ",'order':" + menu.getOrderNum());
            if (menu.getChildren().size() == 0) {
                stringBuffer.append("}}},");
            } else {
                stringBuffer.append("}},'children': [");
                Set<Menu> childList = menu.getChildren();
                int index = 1;
                for (Menu child : childList) {
                    String s = "'}}},";
                    if (index == childList.size()) {
                        s = "'}}}";
                    }
                    stringBuffer.append("{'path':'" + child.getPath() + "','data':{'menu':{'title':'" + child.getTitle()).append(s);
                    index++;
                }
                ;
                stringBuffer.append("]},");
            }
        });
        String menus = stringBuffer.substring(0, stringBuffer.length() - 1) + "]}]";
        return menus;
    }
}
