package com.framework.spring.transactional.programmingtransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * spring 编程式事务
 *
 * @author 2017-11-22 11:04:13 WANG
 *
 */
public class Test {
	// 初始log4j
	static {
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String path = Test.class.getResource("beans.xml").toString();
		ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
		DataSourceTransactionManager transactionManager = ctx.getBean(DataSourceTransactionManager.class);
		//通过DefaultTransactionDefinition对象来持有事务处理属性
		TransactionDefinition td = new DefaultTransactionDefinition();
		//获取事务的状态
		TransactionStatus status = transactionManager.getTransaction(td);
		try{


			//调用需要进行事务处理的目标方法
            transactionManager.commit(status);
        }catch(Exception e){
			//调用目标方法过程中产生异常，则对事务进行回滚处理
			transactionManager.rollback(status);
			throw e;
		}
		//成功调用目标方法之后，对事务进行提交处理
		transactionManager.commit(status);
	}
}
