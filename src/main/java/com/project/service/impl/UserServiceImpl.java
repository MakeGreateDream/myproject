package com.project.service.impl;

import com.main.annotation.Pagination;
import com.project.entity.PageInfo;
import com.project.entity.User;
import com.project.dao.UserMapper;
import com.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @Pagination
    public PageInfo findAll() {
        logger.info("=====info====findAll");
        logger.error("=====error=====findAll====");
        int pageSize = 0;
        int pageNumber = 5;
        List<User> result = userMapper.findAll();

        int tot = result.size();

        return new PageInfo(result,tot,pageNumber,pageSize);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

}