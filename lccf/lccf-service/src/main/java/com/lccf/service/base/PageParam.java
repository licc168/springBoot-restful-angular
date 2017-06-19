package com.lccf.service.base;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * 分页参数
 *
 * @author lichangchao
 * @date 2017 -04-25 19:25:03
 */
public class PageParam {
    private Integer page = 0;
    private Integer size = 10;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    private Sort sort;

    public PageRequest transPageRequest() {

            return new PageRequest(this.page, this.size, this.sort);


    }
}
