package com.lccf.service.base;


import java.lang.reflect.InvocationTargetException;

/**
 * @author lichangchao
 * @date 2017 -05-02 21:12:47
 */
public interface IBaseService<T, P,V>  {
    /**
     * 物理删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 新增或者修改
     * @param param
     */
    void save(P param);

    /**
     * 逻辑删除
     * @param id
     */
    void updateDeleteFlagById(Long id) ;


    T findOne(Long id);
}
