package com.lccf.service;

import com.lccf.Application;
import com.lccf.domain.User;
import com.lccf.service.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MailServiceTest {
    @Resource
    MailService mailService;
    @Test
    public void testSendActivationEmail() {
        User  user = new User();
        user.setUserName("123123");
        user.setEmail("lichangchao@jumore.com");
        mailService.sendActivationEmail(user,"123123");
    }
}
