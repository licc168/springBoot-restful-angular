package com.lccf.controller;

import com.lccf.controller.base.BaseController;
import com.lccf.domain.User;
import com.lccf.service.user.IUserService;
import com.lccf.service.user.UserParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController extends BaseController {

    @Resource
    IUserService userService;

    /**
     * <strong>注册用户</strong>
     * @param userParam
     * @see com.lccf.service.user.UserParam
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "注册用户", httpMethod = "POST", response = String.class, notes = "注册接口（用户名/邮箱/密码）")
    public ResponseEntity<String> register(@RequestBody @ApiParam(value = "用户参数", required = true) UserParam userParam) {
        userService.register(userParam);
        return new ResponseEntity<String>("注册成功", HttpStatus.OK);
    }

    /**
     * 获取用户数据-分页
     * @param userParam
     * @return
     */
    @RequestMapping(value = "/user/page", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数据", httpMethod = "GET", response = Page.class, notes = "")
    public ResponseEntity<Page<User>> page(@ApiParam(value = "用户参数", required = true) UserParam userParam) {
        Page<User> userPage =  userService.page(userParam);
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", httpMethod = "DELETE", response = String.class, notes = "")
    public ResponseEntity<String> deleteById(@ApiParam(value = "用户ID", required = true) @PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>("操作成功", HttpStatus.NO_CONTENT);
    }
}
