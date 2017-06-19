package com.lccf.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合工具类
 *
 * @author lichangchao
 */
public class Collections3 {
    /**
     * LIST 对象转化成String
     *
     * @param list      目标对象
     * @param clumName  对象里面的字段名称
     * @param separator 分隔符
     * @return
     */
    public static <T> String transListToString(List<T> list, final String clumName, String separator) {
        if (CollectionUtils.isEmpty(list)) return "";
        Function<Object, String> trans = new Function<Object, String>() {
            @Override
            public String apply(Object obj) {
                String s = "";
                try {
                    s = BeanUtils.getProperty(obj, clumName);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
                return s;
            }
        };
        return Joiner.on(separator).join(Lists.transform(list, trans));
    }

    /**
     * String 转 List<T>
     *
     * @param target
     * @param separator
     * @param <T>
     * @return
     */
    public static <T> List<T> transStringToList(String target, String separator) {
        if (StringUtils.isEmpty(target)) return Collections.EMPTY_LIST;
        List<T> retList = new ArrayList<>();
        List<String> list = Splitter.on(separator).trimResults().splitToList(target);
        for (String s : list) {
            retList.add((T) s);
        }
        return CollectionUtils.isEmpty(retList) ? Collections.EMPTY_LIST : retList;

    }

    /**
     * String 转 Long<T>
     *
     * @param target
     * @param separator
     * @return
     */
    public static Long[] transStringToArray(String target, String separator) {
        if (StringUtils.isEmpty(target)) return null;
        String[] ss = target.split(separator);
        Long[] ls = new Long[ss.length];
        for (int i = 0; i < ss.length; i++) {
            ls[i] = Long.valueOf(ss[i]);
        }
        return ls;
    }

    /**
     * @param targetList 目标list
     * @param start      截取开始的位置
     * @param end        截取结束的位置
     * @return List<T>
     */
    public static <T> List<T> subList(List<T> targetList, int start, int end) {
        if (CollectionUtils.isEmpty(targetList)) return Collections.EMPTY_LIST;
        List<T> list = new ArrayList<T>(end - start);
        int i = 0;
        for (T t : targetList) {
            if (i >= start && i < end) {
                list.add(t);
            }
            i++;
        }
        return list;
    }

    /**
     * @param targetList 目标list
     *                   顺序去掉重复
     * @return List<T>
     */
    public static <T> List<T> deleteRepeat(List<T>... targetList) {
        if (targetList == null) return Collections.EMPTY_LIST;
        List list = new ArrayList();
        for (int i = 0; i < targetList.length; i++) {
            List<T> tList = targetList[i];
            for (T t : tList) {
                if (!list.contains(t)) {
                    list.add(t);
                }
            }
        }
        return list;
    }

    public static void main(String arge[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list = (List<Integer>) Collections3.subList(list, 2, 10);
        for (int j : list) {
            System.out.println(j);
        }

    }
}
