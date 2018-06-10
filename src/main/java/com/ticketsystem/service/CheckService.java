package com.ticketsystem.service;

import com.ticketsystem.dao.UserMapper;
import com.ticketsystem.model.User;
import com.ticketsystem.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    @Autowired
    private UserMapper userMapper;

    public String getToken(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        if(userMapper.selectByExample(userExample) != null){
            criteria.andUserPasswordEqualTo(user.getUserPassword());
            if(userMapper.selectByExample(userExample) != null)
                //这里要写一个获取token的方法
                return "token";//TODO
            else
                return null;
        }else {
            return null;
        }
    }
}
