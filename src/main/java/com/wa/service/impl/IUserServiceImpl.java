package com.wa.service.impl;

import com.wa.common.ServerResponse;
import com.wa.dao.UserMapper;
import com.wa.pojo.User;
import com.wa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserservice")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse<User> login(String name ,String password){
        int result = userMapper.checkName(name);
        User user = null;
        if(result>0 ){
            user = userMapper.queryUser(name,null,password);
        }else{
            user = userMapper.queryUser(null,name,password);
        }

        if(name == null ){
            return ServerResponse.createByError("密码错误");
        }
        return ServerResponse.createBySuccess(user);


    }

}
