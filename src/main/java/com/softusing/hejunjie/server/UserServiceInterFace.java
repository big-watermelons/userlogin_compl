package com.softusing.hejunjie.server;

import com.softusing.hejunjie.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserServiceInterFace {

    int save(User user);

    boolean login(User user);

    List<User> findAll();

}
