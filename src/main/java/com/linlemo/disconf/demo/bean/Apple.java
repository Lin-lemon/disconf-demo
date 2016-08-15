package com.linlemo.disconf.demo.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/13
 * Time: 00:36
 */
public class Apple implements Serializable {

    private static final long serialVersionUID = 4159367403621878924L;

    private String color;

    private int price;

    private boolean isLike;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean isLike) {
        this.isLike = isLike;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", isLike=" + isLike +
                '}';
    }
}
