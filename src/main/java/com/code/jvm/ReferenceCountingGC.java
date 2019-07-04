package com.code.jvm;



/**
 *
 * @Author WANG JI BO
 * @Date 2019/5/26 下午11:22
 * @Description
 **/
//        step1：objA的引用+1   =1
//        step2：objB的引用+1   =1
//
//        step3：objB的引用+1   =2
//        step4：objA的引用+1   =2

//        step5：objA的引用-1   =1
//        step6：objB的引用-1   =1
public class ReferenceCountingGC {

    public Object instance = null;

    public static void testGC() {
        //step1  +1  =1
        ReferenceCountingGC objA = new ReferenceCountingGC();
        //step2  +1  =1
        ReferenceCountingGC objB = new ReferenceCountingGC();
        //相互引用
        //step3  +1  =2
        objA.instance = objB;
        //step4  +1  =2
        objB.instance = objA;
        //step5  -1  =1
        objA = null;
        //step6  -1  =1
        objB = null;
        //假设在这行发生CG，objA和objB是否能被回收？   不能！！！！
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
