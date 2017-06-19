package com.lccf.service;

import com.lccf.Application;
import com.lccf.domain.User;
import com.lccf.service.user.IUserService;
import com.lccf.service.user.UserParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserServiceTest {
    @Resource
    IUserService userService;

    @Test
    public void testSendActivationEmail() {

    }

    @Test
    public void testRegister() {
        userService.updateDeleteFlagById(17l);
    }

    @Test
    public void testPage() {
        Page<User> userPage = userService.page(new UserParam());
        System.out.println(userPage);
    }

}

