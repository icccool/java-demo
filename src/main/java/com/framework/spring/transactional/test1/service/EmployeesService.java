package com.framework.spring.transactional.test1.service;


import com.framework.spring.entity.employees.Employees;
import com.framework.spring.transactional.test1.dao.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeesService {

    public int insert(Employees record);
    public int insert2(Employees record);


}