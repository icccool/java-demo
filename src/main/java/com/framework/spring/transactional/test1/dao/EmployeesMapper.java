package com.framework.spring.transactional.test1.dao;


import com.framework.spring.entity.employees.Employees;

public interface EmployeesMapper {

    int deleteByPrimaryKey(Integer empNo);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer empNo);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}