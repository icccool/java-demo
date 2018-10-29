package com.framework.mybatis.test1;

import com.framework.mybatis.test1.bean.Salary;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {

    public static void main(String[] args) {
        try {
            String path = Test.class.getResource("conf.xml").toString();
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream(path));
            SqlSession session = sessionFactory.openSession();
            String statement = "me.gacl.mapping.userMapper.getUser";
            Salary salary = session.selectOne(statement, 1);
            System.out.println(salary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
