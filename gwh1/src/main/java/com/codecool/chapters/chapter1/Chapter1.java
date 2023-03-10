package com.codecool.chapters.chapter1;

import com.codecool.chapters.chapter1_B.Chapter1_B;
import com.codecool.chapters.chapter2.Chapter2;
import com.codecool.chapters.chapter3_shop.Shop;
import com.codecool.data.GameCharacter;
import com.codecool.chapters.chapter1.service.Pages1;
import com.codecool.service.Choices;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class Chapter1 {
    GameCharacter supportingCharacter;
    GameCharacter mainCharacter;
    Pages1 pages;

    public Chapter1(GameCharacter support, GameCharacter main) {
        this.supportingCharacter = support;
        this.mainCharacter = main;
        this.pages = new Pages1();
    }
    public void runChapter1(){

        // You arrived to the house of the hunter
        String doorbell = atTheHouse();

        while(!doorbell.equals("d")) {
           Printer.printSimpleText("Wrong button, the old hunter cannot hear you ringing the bell. Pay attention, " +
                   "not to waiting too much, he will fall asleep soon.");
           doorbell = InputScanner.getInput("Please push 'd' in order to ring the doorbell: ");
        }

        // Get into the house or let the hunter help to fight
        String atTheDoor = atTheDoor();

        while(!atTheDoor.equals("a") && !atTheDoor.equals("b")) {
            Printer.printSimpleText("Wrong letter. Please choose wisely, otherwise you miss the chance, " +
                    "collaborate with the old hunter.");
            atTheDoor = InputScanner.getInput("Please select [A] or [B]: ");
        }

        if(atTheDoor.equals("a")) {
            String drink = inTheHouse();

            while(!atTheDoor.equals("a") && !atTheDoor.equals("b")) {
                Printer.printSimpleText("Wrong letter. Please choose wisely, otherwise you miss the chance, " +
                        "collaborate with the old hunter.");
                atTheDoor = InputScanner.getInput("Please select [A] or [B]: ");
            }

            if(drink.equals("a")) {
                Chapter2 chapter2 = new Chapter2(supportingCharacter, mainCharacter);
                chapter2.runChapter2();
            } else {
                pages.printPage5();
                Printer.printPage("After a long run, you finally arrived to the shop.");
                Printer.printNarrative("Enter 'open' to get into the shop!");
                String open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                while(!open.equals("open")) {
                    Printer.printNarrative("Wrong word. Please, type 'open' again.");
                    open = InputScanner.getInput("Type 'open', to open the door to the ammo shop: ").toLowerCase();
                }

                if(open.equals("open")) {
                    Shop ammoShop = new Shop(mainCharacter);
                    ammoShop.enter();
                }
            }
        } else {
            Chapter1_B chapter1_b = new Chapter1_B(supportingCharacter, mainCharacter);
            chapter1_b.runChapter1_B();
        }
    }

    public String atTheHouse() {
        pages.printPage1();
        return InputScanner.getInput("Please push 'd' in order to ring the doorbell: ").toLowerCase();
    }

    public String atTheDoor() {
        pages.printPage2();
        Printer.printNarrative("The old hunter is waiting for your answer, but it is very cold outside. * Don`t let him waiting too much.");
        Choices.printOptions("What do you want to do?","Hear the legend of the giant white wolf", "Urge the old hunter to help you defeat the wolf");
        return InputScanner.getInput("Please select [A] or [B]: ").toLowerCase();
    }

    public String inTheHouse() {
        pages.printPage3();
        String playerName = InputScanner.getInput("Please type your name for the old hunter: ");
        mainCharacter.setName(playerName);
        pages.printPage4(mainCharacter.getName());
        Choices.printOptions("Come and sit down, what would you like to drink?","A magic strawberry juice", "Thanks, I`m good. I already had some drink");
        return InputScanner.getInput("Please select [A] or [B]: ").toLowerCase();
    }
}
