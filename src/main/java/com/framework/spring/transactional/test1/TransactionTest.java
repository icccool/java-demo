package com.framework.spring.transactional.test1;

import com.framework.spring.entity.employees.Employees;
import com.framework.spring.transactional.test1.service.EmployeesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * spring 事务配置
 * <p>
 * 1. 如果事务方法里捕捉了异常, 事务不会回滚
 * 2.
 *
 * @author John
 */
public class TransactionTest {
    // 初始log4j
    static {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = TransactionTest.class.getResource("beans.xml").toString();
        ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
        EmployeesService service = ctx.getBean(EmployeesService.class);
        Employees emp = buildEmployess();
        int i = service.insert(emp);
        System.out.println("rows = " + i);
    }

    private static Employees buildEmployess() {
        Employees emp = new Employees();
        emp.setEmpNo((int) (Math.random() * 9 + 1) * 100000);
        emp.setBirthDate(new Date());
        emp.setFirstName("wang");
        emp.setLastName("jibo");
        emp.setGender("M");
        emp.setHireDate(new Date());
        return emp;
    }
}
