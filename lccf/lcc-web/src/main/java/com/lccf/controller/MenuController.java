package com.lccf.controller;

import com.lccf.controller.base.BaseController;
import com.lccf.domain.Menu;
import com.lccf.service.menu.IMenuService;
import com.lccf.service.menu.MenuParam;
import com.lccf.service.menu.MenuVo;
import com.lccf.service.menu.impl.MenuUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author  lichangchao
 * @Time 2017-04-24
 * 菜单管理
 */
@RestController

public class MenuController extends BaseController {
    @Resource
    IMenuService  menuService;
    @RequestMapping(value = "/menu/list", method = RequestMethod.GET  ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取全部菜单列表", httpMethod = "GET",response = List.class)
    public ResponseEntity<String> list() {
        List<Menu> menuList =   menuService.findByDeleteFlagAndParentId(false,null);
        String menuJson = MenuUtil.transMenuListTOJson(menuList);
        return new ResponseEntity<String>(menuJson, HttpStatus.OK);
    }

    @RequestMapping(value = "/menu/parentList", method = RequestMethod.GET  ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取父级菜单列表-用于菜单页面下拉框", httpMethod = "GET",response = List.class)
    public ResponseEntity<List<Menu>> parentList() {
        List<Menu> menuList =   menuService.findByDeleteFlagAndParentId(false,null);
        return new ResponseEntity(menuList, HttpStatus.OK);
    }
    @RequestMapping(value = "/menu/page", method = RequestMethod.GET  ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取菜单列表-分页", httpMethod = "GET",response = Page.class)
    public ResponseEntity<Page<MenuVo>> page(@ApiParam(value = "用户参数", required = true) MenuParam menuParam) {
        Page<MenuVo> menuPage =   menuService.page(menuParam);
        return new ResponseEntity<Page<MenuVo>>(menuPage, HttpStatus.OK);
    }
    @RequestMapping(value = "/menu/add", method = RequestMethod.POST  ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增菜单信息", httpMethod = "POST",response = Page.class)
    public ResponseEntity<String> add(@RequestBody @ApiParam(value = "用户参数", required = true) MenuParam menuParam) {
        menuService.save(menuParam);
        return new ResponseEntity<String>("操作成功", HttpStatus.OK);
    }

    @RequestMapping(value = "/menu/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", httpMethod = "DELETE", response = String.class, notes = "")
    public ResponseEntity<String> deleteById(@ApiParam(value = "用户ID", required = true) @PathVariable Long id) {
        menuService.updateDeleteFlagById(id);
        return new ResponseEntity<String>("操作成功", HttpStatus.OK);
    }
}
