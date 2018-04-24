package com.code.string.json;

/**
 * Created by john on 17/9/23.
 */
public class OrderVo {

    private String orderId;
    private String orderNumber;
    private OrderExtVo orderExt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderExtVo getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(OrderExtVo orderExt) {
        this.orderExt = orderExt;
    }
}
