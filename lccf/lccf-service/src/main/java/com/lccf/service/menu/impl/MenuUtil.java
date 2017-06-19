package com.lccf.service.menu.impl;


import com.lccf.domain.Menu;

import java.util.List;
import java.util.Set;

public class MenuUtil {
    public static String transMenuListTOJson(List<Menu> list) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[{'path': 'pages', 'children': [");
        list.forEach(menu -> {
            stringBuffer.append("{'path':'" + menu.getPath() + "',")
                    .append("'data':{ 'menu':{'title':'" + menu.getTitle() + "','icon':'" + menu.getIcon() + "','selected':" + menu.getSelected())
                    .append(",'expanded':" + menu.getSelected() + ",'order':" + menu.getOrderNum());
            if (menu.getChildren().size() == 0) {
                stringBuffer.append("}}},");
            } else {
                stringBuffer.append("}},'children': [{");
                Set<Menu> childList = menu.getChildren();
                childList.stream().forEach((child) -> {
                    stringBuffer.append("'path':'" + child.getPath() + "','data':{'menu':{'title':'" + child.getTitle()).append("'}}}]},");
                });
            }
        });
        String menus = stringBuffer.substring(0,stringBuffer.length()-1)+"]}]";
        return menus;
    }
}
