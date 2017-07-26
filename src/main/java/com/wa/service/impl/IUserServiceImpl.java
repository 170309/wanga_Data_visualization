package com.wa.service.impl;

import com.wa.common.ServerResponse;
import com.wa.dao.UserMapper;
import com.wa.pojo.User;
import com.wa.service.IUserService;
import com.wa.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserservice")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public ServerResponse<User> login(String name ,String password){
        int result = userMapper.checkName(name);

        if(result == 0 ){
            return ServerResponse.createByError("用户名不存在");
        }
        String MD5pwd = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.queryUser(name, MD5pwd);
        if(user == null ){
            return ServerResponse.createByError("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }

}
