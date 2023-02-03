package com.codecool.chapters.chapter3_shop;

import com.codecool.chapters.chapter3_shop.service.DisplayLists;
import com.codecool.data.GameCharacter;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

import java.util.*;


public class Shop {
    private List<Weapon> weapons = new ArrayList<>();
    private GameCharacter gameCharacter;
    private String input;

    public Shop(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        generateWeapons();
        this.input = " ";
    }

    public void enter() {
        gameCharacter.increaseCoins(2000);
        HashMap<Integer, Weapon> weaponCatalogue = new HashMap<>();

        while (!input.equals("leave")) {
            createCatalogue(weaponCatalogue);
            listWeaponOptions();
            Printer.printSimpleText("You have: " + gameCharacter.getCoins() + " coins.");

            boolean correctNumberInput = false;
            int inputNumber = 0;

            inputNumber = getInputNumber(weaponCatalogue, correctNumberInput, inputNumber);

            if (gameCharacter.getCoins() >= weaponCatalogue.get(inputNumber).price()) {
                gameCharacter.increaseAttack(weaponCatalogue.get(inputNumber).attackPoint());
                gameCharacter.decreaseCoins(weaponCatalogue.get(inputNumber).price());
                gameCharacter.getWeaponList().add(weaponCatalogue.get(inputNumber));
                Printer.printPage("You bought a " + weaponCatalogue.get(inputNumber).name() + " successfully!");
            }

            if (gameCharacter.getCoins() < weaponCatalogue.get(inputNumber).price()) {
                Printer.printSimpleText("You don't have enough coins to buy a new weapon... You either work for the shopkeeper or start bargaining.");

                String workBargainInput = InputScanner.getInput("What do you do [work / bargain]?");

                while (!workBargainInput.equals("work") && !workBargainInput.equals("bargain")) {
                    System.out.println("Wrong input");
                    workBargainInput = InputScanner.getInput("What do you do [work / bargain]: ");
                }

                boolean userWantsWork;

                switch (workBargainInput) {
                    case "work":
                        Work work = new Work(gameCharacter);
                        userWantsWork = true;

                        while (userWantsWork) {
                            work.showTask();

                            String moreWork = InputScanner.getInput("Do you want to work more [yes / no] ?");

                            if (moreWork.equalsIgnoreCase("no")) {
                                userWantsWork = false;
                            }
                        }
                        Printer.printSimpleText(String.format("%s returns to weapon shop", gameCharacter.getName()));
                        break;

                    case "bargain":
                        bargain();
                        break;
                }
            }
        }
        Printer.printPage("After you bought a lot of weapons, you went to the woods to fight the giant white wolf. * Dou you want to know, how to story continues? * Buy and download the game from the official website. * 7 days trial is over.");
    }


    private int getInputNumber(HashMap<Integer, Weapon> weaponCatalogue, boolean correctNumberInput, int inputNumber) {

        while (!correctNumberInput) {
            input = InputScanner.getInput("Enter weapon's number to buy it: ");
            try {
                inputNumber = Integer.parseInt(input);
                correctNumberInput = true;
            } catch (NumberFormatException e) {
                if(input.equalsIgnoreCase("leave")) {
                    Printer.printPage("After you bought a lot of weapons, you went to the woods to fight the giant white wolf. * Dou you want to know, how to story continues? * Buy and download the game from the official website. * 7 days trial is over.");
                    System.exit(0);
                } else {
                    System.out.println("Wrong input, enter an integer.");
                }
            }
        }

        while (!weaponCatalogue.containsKey(inputNumber)) {
            System.out.println("There's no such weapon, try again.");
            try {
                input = InputScanner.getInput("Enter weapon's number to to buy it: ");
                inputNumber = Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input, enter an integer.");
            }
        }
        return inputNumber;
    }

    private void createCatalogue(HashMap<Integer, Weapon> weaponCatalogue) {
        int catalogueNumber = 1;

        for (Weapon weapon : weapons) {
            weaponCatalogue.put(catalogueNumber, weapon);
            catalogueNumber++;
        }
    }

    private void generateWeapons() {
        Weapon[] STANDARD_WEAPONS = {
                new Weapon("sword", 300, 30),
                new Weapon("bow", 200, 15),
                new Weapon("dagger", 150, 10)
        };
        Collections.addAll(weapons, STANDARD_WEAPONS);
    }

    private void listWeaponOptions() {
        DisplayLists.displayShopCatalogue((Weapon[]) weapons.toArray());
    }


    public void increasePricesByPercentage(int percentage) {
        for (Weapon weapon : weapons) {
            weapon.increasePricesByPercentage(percentage);
        }
    }

    public void bargain() {

        Printer.printSimpleText("You started bargaining for a lower price...");
        Printer.printSimpleText("This seriously insults the shopkeeper, he gets angry and hits you...");
        String input = InputScanner.getInput("What do you do [fight back / trick him]: ").toLowerCase();

        while (!input.equals("fight back") && !input.equals("trick him")) {
            System.out.println("Wrong input");
            input = InputScanner.getInput("What do you do [fight back / trick him]: ");
        }

        if (input.equals("fight back")) {
            fight();
        } else {
            System.out.println("Game exits.");
            System.exit(0);
        }
    }

    public void fight() {
        Surrender surrender = new Surrender();

        Printer.printPage("You fought for a while, but the guy has won, so you apologize. *" +
                                "He stopped hitting you but can accept your apology only if you give all your famous scotchs to him. *" +
                               "And he also doubled the prices for you, just in case...");

        String input = InputScanner.getInput("What do you do [pay more / apologize]: ").toLowerCase();

        while (!input.equals("pay more") && !input.equals("apologize")) {
            System.out.println("Wrong input");
            input = InputScanner.getInput("What do you do [pay more / apologize]: ");
        }

        if (input.equals("pay more")) {
            increasePricesByPercentage(30); // TODO: Constant or even better random number
            Printer.printSimpleText("The shopkeeper increased the prices");
        } else {
            surrender.goHome();
        }
    }

}
