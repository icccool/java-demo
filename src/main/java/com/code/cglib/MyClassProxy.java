package com.code.cglib;

/**
 * @Author WANG JI BO
 * @Date 2019/8/29 下午10:19
 * @Description
 **/
public class MyClassProxy extends MyClass {

    public void method() {
        System.out.println("前...........");
//
//        TransactionAttributeSource tas = getTransactionAttributeSource();
//        final TransactionAttribute txAttr = (tas != null ? tas.getTransactionAttribute(method, targetClass) : null);
//        final PlatformTransactionManager tm = determineTransactionManager(txAttr);
//        final String joinpointIdentification = methodIdentification(method, targetClass, txAttr);
        //begin
        try {
            super.method(); //invo
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("后...........");
    }

}
