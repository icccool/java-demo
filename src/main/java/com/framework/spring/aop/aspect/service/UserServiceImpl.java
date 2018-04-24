package com.framework.spring.aop.aspect.service;

import com.framework.spring.aop.aspect.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  implements UserService{

    @Override
    public User selectById(int id) {
        System.out.println("我是selectById方法.");
        return null;
    }

    @Override
    public int insert(User user) {
        System.out.println("我是insert方法.");
        return 0;
    }

    @Override
    public int delete(User user) {
        System.out.println("我是delete方法.");
        return 0;
    }

    @Override
    public int add(int id, String name, int age) {
        System.out.println("我是add方法.id=" + id + ",name=" + name + ",age=" + age);
        return 0;
    }
}
