package com.code.reflex.enums;


/**
 * @Author WANG JI BO
 * @Date 2019/8/7 下午2:08
 * @Description
 **/

public enum DocumentStatusEnum {

    DRAFT("1", "草稿"),
    IN_FORCE("2", "生效中"),
    ENTERED_INTO_FORCE("3", "已生效"),
    TO_VOID("4", "作废"),
    ;

    private String value;
    private String name;

    DocumentStatusEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
