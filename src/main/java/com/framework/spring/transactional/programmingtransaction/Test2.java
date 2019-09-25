package com.framework.spring.transactional.programmingtransaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class Test2 {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private PlatformTransactionManager transactionManager ;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(
            PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);//begin
        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplate.update(SQL1, name, age);

            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = jdbcTemplate.queryForInt(SQL2);
            String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
            jdbcTemplate.update(SQL3, sid, marks, year);
            System.out.println("Created Name = " + name + ", Age = " + age);

            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return;
    }


}