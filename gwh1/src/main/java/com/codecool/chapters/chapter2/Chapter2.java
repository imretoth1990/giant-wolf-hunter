package com.codecool.chapters.chapter2;

import com.codecool.chapters.chapter2.service.Pages2;
import com.codecool.chapters.chapter3_shop.Shop;
import com.codecool.data.GameCharacter;
import com.codecool.service.Choices;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class Chapter2 {
        GameCharacter supportingGameCharacter;
        GameCharacter mainGameCharacter;
        Pages2 pages;
        public Chapter2(GameCharacter support, GameCharacter main) {
            this.supportingGameCharacter = support;
            this.mainGameCharacter = main;
            this.pages = new Pages2();
        }

    public void runChapter2() {
       pages.printPage1();
        Choices.printOptions("Are you ok, my son?","Yes, i want to drink the whole glass and see " +
                "everything!", "No, i feel slightly bad. I don`t want to drink more");
        String drink = InputScanner.getInput("Please select [A] or [B]: ").toLowerCase();

        while(!drink.equals("a") && !drink.equals("b")) {
            Printer.printSimpleText("Wrong letter. Please choose wisely, otherwise you could stay thirsty.");
            drink = InputScanner.getInput("Please select [A] or [B]: ");
        }

        if(drink.equals("a")) {
            pages.printPage2VersionA();
            Choices.printOptions("Are you sure, you want to come?", "Yes, for sure!", "No, i want to sleep a little bit...");
            String theBigDecision = InputScanner.getInput("Please select [A] or [B]: ").toLowerCase();

            while(!theBigDecision.equals("a") && !theBigDecision.equals("b")) {
                Printer.printSimpleText("Wrong letter. Please choose wisely!");
                theBigDecision = InputScanner.getInput("Please select [A] or [B]: ");
            }

            if(theBigDecision.equals("a")) {
                pages.printPage3VersionA();
                Printer.printNarrative("Enter 'open' to get into the shop!");
                String open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                while(!open.equals("open")) {
                    Printer.printNarrative("Wrong word. Please, type 'open' again.");
                    open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                }

                if(open.equals("open")) {
                    Shop ammoShop = new Shop(mainGameCharacter);
                    ammoShop.enter();
                }
            }else {
                pages.printPage3VersionB();
                Printer.printPage("After a long run, you finally arrived to the shop.");
                Printer.printNarrative("Enter 'open' to get into the shop!");
                String open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                while(!open.equals("open")) {
                    Printer.printNarrative("Wrong word. Please, type 'open' again.");
                    open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                }

                if(open.equals("open")) {
                    Shop ammoShop = new Shop(mainGameCharacter);
                    ammoShop.enter();
                }
            }
        } else {
            pages.printPage2VersionB();
            Printer.printPage("After a long run, you finally arrived to the shop.");
            Printer.printNarrative("Enter 'open' to get into the shop!");
            String open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
            while(!open.equals("open")) {
                Printer.printNarrative("Wrong word. Please, type 'open' again.");
                open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
            }

            if(open.equals("open")) {
                Shop ammoShop = new Shop(mainGameCharacter);
                ammoShop.enter();
            }
        }
    }
}
