package com.lccf.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lccf.Application;
import com.lccf.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserRepositoryTest {
    @Resource
    UserRepository userRepository;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("licc");
        user.setPassword("1111111");
        user.setStatus(1);
        userRepository.save(user);
    }
    
    
    @Test
    public void testFindone() {
        User user = new User();
        user.setUserName(RandomStringUtils.randomAlphanumeric(10));
        user.setPassword("1111111");
        user.setStatus(1);
        userRepository.save(user);
        
        Optional<User> newUser =userRepository.findOneByUserName(user.getUserName());
        assertEquals(newUser.get().getId(), user.getId());
        
    }
    
}


