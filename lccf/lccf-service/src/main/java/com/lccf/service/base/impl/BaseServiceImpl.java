package com.lccf.service.base.impl;

import com.lccf.service.base.IBaseService;
import com.lccf.util.BeanMapper;
import com.lccf.util.GenericsUtils;
import com.lccf.util.Reflect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * <ul>
 *   <h1>参数说明:</h1>
 *   <li>T:对应数据库持久化bean</li>
 *   <li>P:页面接受参数</li>
 *   <li>V:返回参数</li>
 * </ul>
 * @author lichangchao
 * @date 2017 -05-02 21:08:56
 */

public class BaseServiceImpl<T, P, V> implements IBaseService<T, P, V> {
    private transient Class<T> DTOClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 0);
    private transient Class<V> VOClass = GenericsUtils.getSuperClassGenricType(this.getClass(), 2);

    @Autowired
    JpaRepository<T, Long> jpaRepository;

    @Override
    public void deleteById(Long id) {
        jpaRepository.delete(id);
    }


    @Override
    public void save(P param) {
        if (param == null) {
            throw new IllegalArgumentException("参数为空");
        }
        T t = BeanMapper.map(param, DTOClass);
        jpaRepository.save(t);
    }

    @Override
    public void updateDeleteFlagById(Long id) {
        T t = jpaRepository.findOne(id);
        Reflect.on(t).set("deleteFlag", true);
        jpaRepository.save(t);
    }

    @Override
    public T findOne(Long id) {
        return jpaRepository.findOne(id);
    }

    public Page<V> pageDtoToPageVo(Page<T> tPage) {
        if (tPage == null) {
            return null;
        }
        return tPage.map(new Converter<T, V>() {
            @Override
            public V convert(T t) {
                return BeanMapper.map(t, VOClass);
            }
        });

    }

}
