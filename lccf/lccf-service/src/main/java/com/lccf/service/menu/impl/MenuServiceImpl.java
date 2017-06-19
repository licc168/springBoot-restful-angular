package com.lccf.service.menu.impl;

import com.lccf.domain.Menu;
import com.lccf.repository.MenuRepostiory;
import com.lccf.service.base.impl.BaseServiceImpl;
import com.lccf.service.menu.IMenuService;
import com.lccf.service.menu.MenuParam;
import com.lccf.service.menu.MenuVo;
import com.lccf.util.BeanMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuParam, MenuVo> implements IMenuService {
    @Resource
    MenuRepostiory menuRepostiory;

    @Override
    public List<Menu> findByDeleteFlagAndParentId(Boolean deleteFlag, Long parentId) {
        List<Menu> menuList = menuRepostiory.findByDeleteFlagAndParentId(deleteFlag, parentId);
        return menuList;
    }


    @Override
    public Page<MenuVo> page(MenuParam menuParam) {
        Pageable pageable = menuParam.transPageRequest();
        Menu menu = BeanMapper.map(menuParam, Menu.class);
        menu.setDeleteFlag(false);
        Page<Menu> menuPage = menuRepostiory.findAll(Example.of(menu), pageable);
        Page<MenuVo> menuVoPage = this.pageDtoToPageVo(menuPage);
        return menuVoPage;
    }

    public Page<MenuVo> pageDtoToPageVo(Page<Menu> menuPage) {
        return menuPage.map(new Converter<Menu, MenuVo>() {
            @Override
            public MenuVo convert(Menu t) {
                MenuVo vo = BeanMapper.map(t, MenuVo.class);
                Long parentId = vo.getParentId();
                if(parentId==null){
                    vo.setParentTitle("");
                }else {
                    Menu parentMenu = menuRepostiory.findOne(vo.getParentId());
                    vo.setParentTitle(parentMenu.getTitle());
                }
                return vo;
            }
        });
    }


}
