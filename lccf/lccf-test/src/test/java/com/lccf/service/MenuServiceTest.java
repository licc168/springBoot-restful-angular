package com.lccf.service;

import com.lccf.Application;
import com.lccf.domain.Menu;
import com.lccf.service.menu.IMenuService;

import com.lccf.service.menu.MenuParam;
import com.lccf.service.menu.impl.MenuUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MenuServiceTest {
	@Resource
	IMenuService menuService;

	@Test
	public void testFindByDeleteFlag() {
        List<Menu> menuList =   menuService.findByDeleteFlagAndParentId(false,null);
        String menuJson = MenuUtil.transMenuListTOJson(menuList);
        System.out.println(menuJson);


	}
	@Test
	public void testPage() {
		menuService.page(new MenuParam());


	}
}
