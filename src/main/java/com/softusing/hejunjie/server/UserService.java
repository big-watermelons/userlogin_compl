package com.softusing.hejunjie.server;


import com.softusing.hejunjie.controller.UserController;
import com.softusing.hejunjie.entity.User;
import com.softusing.hejunjie.entity.UserExample;
import com.softusing.hejunjie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterFace {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }

    public List<User> findAll(){
        return userMapper.selectByExample(new UserExample());
    }

    public boolean login(User user) {
        String name = user.getUsername();
        String password = user.getPassword();
        List<User> userList = userMapper.selectByUsername(name);
        if (userList == null) {
            return false;
        } else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

}
