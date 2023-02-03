package com.codecool.chapters.chapter3_shop;

import java.util.Objects;

public final class Weapon {
    private final String name;
    private double price;
    private final int attackPoint;

    public Weapon(String name, int price, int attackPoint) {
        this.name = name;
        this.price = price;
        this.attackPoint = attackPoint;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public int attackPoint() {
        return attackPoint;
    }

    public void increasePricesByPercentage(int percentage) {
        price = (price * (1 + (double) percentage / 100));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Weapon) obj;
        return Objects.equals(this.name, that.name) &&
               this.price == that.price &&
               this.attackPoint == that.attackPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, attackPoint);
    }

    @Override
    public String toString() {
        return "Weapon[" +
               "name=" + name + ", " +
               "price=" + price + ", " +
               "attackPoint=" + attackPoint + ']';
    }

}
