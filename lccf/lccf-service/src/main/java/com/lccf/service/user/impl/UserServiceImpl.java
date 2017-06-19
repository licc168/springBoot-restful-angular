package com.lccf.service.user.impl;


import com.lccf.domain.User;
import com.lccf.enums.EUserStatus;
import com.lccf.repository.UserRepository;
import com.lccf.service.base.impl.BaseServiceImpl;
import com.lccf.service.user.IUserService;
import com.lccf.service.user.UserParam;
import com.lccf.service.user.UserVo;
import com.lccf.util.BeanMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author lichangchao
 * @Time 2017 -03-29 09:21:05
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User,UserParam,UserVo>  implements IUserService {
    @Resource
    UserRepository userRepository;
    @Inject
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserParam userParam) {
        User user = BeanMapper.map(userParam, User.class);
        user.setStatus(EUserStatus.FREEZE.getKey());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Page<User> page(UserParam userParam) {
        Pageable pageable = userParam.transPageRequest();
        User user = BeanMapper.map(userParam, User.class);
        return  userRepository.findAll(Example.of(user),pageable);
    }




}
