package com.code.base.clone;

/**
 * Created by john on 17/11/19.
 * 关于浅拷贝，你该了解的<br>
 * 使用默认的clone方法
 * 对于原始数据域进行值拷贝
 * 对于引用类型仅拷贝引用
 * 执行快，效率高
 * 不能做到数据的100%分离。
 * 如果一个对象只包含原始数据域或者不可变对象域，推荐使用浅拷贝。
 */
public class Test {
    public static void main(String[] args) {

        Address add = new Address();
        add.setAdd("上海");
        System.out.println("===========================");
        Student stu1 = new Student("zhangsan", 18);
        System.out.println(stu1);
        stu1.setAdd(add);
        System.out.println(stu1.getName());
        System.out.println(stu1.getAge());
        System.out.println(stu1.getAdd());
        System.out.println("===========================");


        Student stu2 = (Student) stu1.clone();
        System.out.println(stu2);
        // 这里改变'北京'
        // stu1和stu2都会变, 因为stu1和stu2都是引用相同add
        // 深度复制: 复制student时,对每个引用对象都要复制.
        stu2.getAdd().setAdd("北京");

        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
        System.out.println(stu2.getAdd());

        System.out.println(" stu1--> " + stu1.getAdd());
        System.out.println("===========================");

//        System.out.println(stu1.getName());
//        System.out.println(stu1.getAge());
//        System.out.println(stu1.getAdd());

//        System.out.println(stu1);
//        System.out.println(stu2);

    }
}
