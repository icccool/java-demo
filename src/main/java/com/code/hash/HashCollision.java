package com.code.hash;

import java.util.HashMap;

/**
 * hash碰撞, 利用连表存储数据
 *
 * @Author WANG JI BO
 * @Date 2019/6/12 上午10:38
 * @Description
 **/
public class HashCollision {


    public static void main(String[] args) {

        HashMap<User, String> hashMap = new HashMap<User, String>();

        hashMap.put(new User("1"), "a");
        hashMap.put(new User("1"), "a");
        hashMap.put(new User("1"), "a");
        hashMap.put(new User("1"), "a");
        hashMap.put(new User("1"), "a");

        System.out.println(hashMap.size());
        System.out.println(hashMap.entrySet());

    }


    static class User {
        int id;
        String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
