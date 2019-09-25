package com.framework.spring.transactional.test1.service;


import com.framework.spring.entity.employees.Employees;
import com.framework.spring.transactional.test1.dao.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesMapper employeesMapper;

    @Transactional
    public int insert(Employees record){
        //操作2
        int i = employeesMapper.insert(record);
        //操作1
        record.setEmpNo(record.getEmpNo() + 1000);
        insert2(record);

        //如果异常被捕捉,事务不会回滚 <----
//        try {
//            int d = 1 / 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return  i;
    }


    @Transactional
    public int insert2(Employees record){
        int i = employeesMapper.insert(record);
        int c = 1 / 0; //触发异常
        return  i;
    }

    public EmployeesMapper getEmployeesMapper() {
        return employeesMapper;
    }

    public void setEmployeesMapper(EmployeesMapper employeesMapper) {
        this.employeesMapper = employeesMapper;
    }
}