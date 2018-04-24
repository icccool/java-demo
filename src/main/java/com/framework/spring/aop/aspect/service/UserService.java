package com.framework.spring.aop.aspect.service;

import com.framework.spring.aop.aspect.entity.User;

/**
 * Created by john on 17/11/21.
 */
public interface UserService {

    User selectById(int id);

    int insert(User user);

    int delete(User user);

    int add(int id,String name,int age);
}
