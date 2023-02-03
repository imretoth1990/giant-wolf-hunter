package com.codecool.data;

import com.codecool.chapters.chapter3_shop.Weapon;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter {
    String name;
    int hp;
    int attack;
    int coins;
    List<Weapon> weaponList;

    public GameCharacter(String name, int hp, int attack, int coins) {
       this.name = name;
       this.hp = hp;
       this.attack = attack;
       this.coins = coins;
       this.weaponList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String input) {
        this.name = input;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public void increaseHp(int hp) {
        this.hp += hp;
    }

    public void decreaseHp(int hp) {
        this.hp -= hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void increaseAttack(int attack) {
        this.attack += attack;
    }

    public void decreaseAttack(int attack) {
        this.attack -= attack;
    }
    public int getCoins() {
        return coins;
    }

    public void increaseCoins(int coins) {
        this.coins += coins;
    }

    public void decreaseCoins(int coins) {
        this.coins -= coins;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void clearWeaponList(List<Weapon> weaponList) {
        weaponList.clear();
    }


}
