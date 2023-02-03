package com.codecool.chapters.chapter3_shop.service;

import com.codecool.chapters.chapter3_shop.Weapon;
import com.codecool.data.GameCharacter;
import com.codecool.service.Calculator;
import org.apache.commons.lang3.StringUtils;

public class DisplayLists {
    public static void displayShopCatalogue(Weapon[] weapon) {

        int counter = 1;
        int repeatValue = Calculator.calculateCenterValue(60); // Characters: number of characters in the longest line
        int width = Calculator.returnCurrentConsoleWidth();

        System.out.printf(" ".repeat(repeatValue) + "------------------------------------------------------------%n");
        // System.out.printf(" ".repeat(repeatValue) + "                      WEAPON CATALOGUE                      %n");
        System.out.println(StringUtils.center("WEAPON CATALOGUE", width));
        System.out.printf(" ".repeat(repeatValue) + "------------------------------------------------------------%n");
        System.out.printf(" ".repeat(repeatValue) + "------------------------------------------------------------%n");
        System.out.printf(" ".repeat(repeatValue) + "| %-4s | %-18s | %-15s | %-10s |%n", "Nr.", "NAME", "PRICE", "DAMAGE");
        System.out.printf(" ".repeat(repeatValue) + "------------------------------------------------------------%n");

        for(Weapon e : weapon) {
            System.out.printf(" ".repeat(repeatValue) + "| %-4s | %-18s | %-15s | %-10s |%n", counter++, e.name(), e.price() + " coins", e.attackPoint());
        }

        System.out.printf(" ".repeat(repeatValue) + "------------------------------------------------------------%n");
    }

    public static void displayPlayerInventory(GameCharacter player) {

        int repeatValue = Calculator.calculateCenterValue(35);
        int width = Calculator.returnCurrentConsoleWidth();

        System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
        // System.out.printf(" ".repeat(repeatValue) + "        " + player.getName().toUpperCase() + "`S INVENTORY        %n");
        System.out.println(StringUtils.center(player.getName().toUpperCase() + "`S INVENTORY", width));
        System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
        System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", "HP:", player.getHp());
        System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", "ATTACK POINTS:", player.getAttack());
        System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", "WALLET:", player.getCoins() + " coins");
        System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
        // System.out.printf(" ".repeat(repeatValue) + "               WEAPONS             %n");
        System.out.println(StringUtils.center("WEAPONS", width));
        System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
        System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", "NAME (VALUE)", "DAMAGE");
        System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");

        if (player.getWeaponList().size() < 1) {
            System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", "no weapons", "0");
            System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
        } else {
            for (Weapon e : player.getWeaponList()) {
                System.out.printf(" ".repeat(repeatValue) + "| %-15s %15s |%n", e.name() + "(" + e.price() + ")", e.attackPoint());
                System.out.printf(" ".repeat(repeatValue) + "-----------------------------------%n");
            }
        }
    }
}
