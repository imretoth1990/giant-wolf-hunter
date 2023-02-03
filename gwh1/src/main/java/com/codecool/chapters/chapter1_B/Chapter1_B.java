package com.codecool.chapters.chapter1_B;

import com.codecool.chapters.chapter1_B.service.Pages1_B;
import com.codecool.chapters.chapter3_shop.Shop;
import com.codecool.chapters.chapter3_shop.service.DisplayLists;
import com.codecool.data.GameCharacter;
import com.codecool.service.Choices;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class Chapter1_B {

    GameCharacter supportingCharacter;
    GameCharacter mainCharacter;
    Pages1_B pages;

    String destination;

    boolean running = true;
    public Chapter1_B(GameCharacter support, GameCharacter main) {
        this.supportingCharacter = support;
        this.mainCharacter = main;
        this.pages = new Pages1_B();
        this.destination = "";
    }
    public void runChapter1_B() {
        pages.printPage1();
        String playerName = InputScanner.getInput("Please type your name for the old hunter: ");
        mainCharacter.setName(playerName);
        pages.printPage2(mainCharacter.getName());
        Choices.printOptions("You need to talk to Samey. Let find him!", "Go to the ancient oak",
                "Search Samey in the pub", "Go to the blacksmith`s hall", "Go to the beautiful, young gipsy witch");
        destination = InputScanner.getInput("Choose a destination, where Samey could be! " +
                "Type [A], [B], [C] or [D]: ").toLowerCase();

        while (!destination.equals("a") && !destination.equals("b") && !destination.equals("c") && !destination.equals("d")) {
            Printer.printSimpleText("Wrong letter, please choose [A] or [B], [C] or [D].");
            destination = InputScanner.getInput("Choose a destination, where Samey could be:  ").toLowerCase();
        }
        while(running) {
            if (destination.equals("a")) {
                atTheOak();
            } else if (destination.equals("b")) {
                inThePub();
            } else if (destination.equals("c")) {
                atTheBlacksmith();
            } else {
                atTheWitch();
            }
        }
    }

    public void atTheOak() {
        Printer.printPage("You are at the ancient oak in the darkest Appalachian forest... you are looking for Samey, but you can`t find him. * " +
                "You are shouting his name 10 times, " +
                "but it is only the wind, you can hear. * If you want to go deeper into the forest, pay attention. * There could be a wild bear in the cave, or outside in the forest.");
        Choices.printOptions("Do you want to search him or leave the forest?", "Search further", "Leave the forest");
        String choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        while (!choice.equals("a") && !choice.equals("b")) {
            Choices.printOptions("Do you want to search him or leave the forest?", "Search further", "Leave the forest");
            choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        }
        if (choice.equals("a")) {
            Printer.printPage("You are determined to find Samey. * You need weapon! You go even to the cave of " +
                    "the big black bear... " +
                    "You go further down, but oh nooo! * The bear is also in the cave and starts fighting you. * " +
                    "You don`t have any weapon, so can`t fight the bear. * The only thing, you can do, is solving the next quizlet. * If you lose all three questions, you will die.");
            question1();
            question2();
            question3();
        } else {
            Printer.printPage("You have a strange feeling, that you shouldn`t be here anymore. * Samey could be " +
                    "somewhere else. " +
                    "What would he do here alone? *  Go somewhere else.");
            Choices.printOptions("You need to talk to Samey. Let find him!", "Go to the ancient oak",
                    "Search Samey in the pub",
                    "Go to the blacksmith`s hall", "Go to the beautiful, young gipsy witch");
            destination = InputScanner.getInput("Choose a destination, where Samey could be: ").toLowerCase();
        }
    }

    public void question1() {
        Printer.printPage("QUESTION 1");
        Choices.printOptions("Which was first?", "the chicken", "the egg");
        boolean quiz1 = quizAB();

        if(!quiz1) {
            mainCharacter.decreaseHp(15);
            Printer.printPage("Ohh, no... you lost 15 HPs... you can do it better!");
        } else {
            mainCharacter.increaseCoins(30);
            Printer.printPage("Congratulation! You earned 30 coins!");
        }
    }

    public void question2() {
        Printer.printPage("QUESTION 2");
        Printer.printNarrative("If a ship has 26 sheep and 10 goats on board, * how old is the captain? *" +
                "Please write your answer into the input field!");
        boolean quiz2 = quizNumber();

        if(!quiz2) {
            mainCharacter.decreaseHp(15);
            Printer.printPage("Ohh, no... you lost 15 HPs... you can do it better!");
        } else {
            mainCharacter.increaseAttack(15);
            Printer.printPage("Congratulation! You earned 15 HPs!");
        }
    }

    public void question3() {
        Printer.printPage("QUESTION 3");
        Choices.printOptions("What is always coming but never arrives?", "tomorrow", "santa claus");
        boolean quiz1 = quizAB();

        if(!quiz1) {
            mainCharacter.setHP(0);
            Printer.printPage("Ohh, no... you lost all your HPs...");
            deathScene();
        } else {
            mainCharacter.increaseHp(30);
            Printer.printPage("Congratulation! You earned 30 HP points!");
        }
    }

    public void deathScene() {
        Printer.printPage("The bear jumps on you and you feel nothing for a moment. * " +
                "It seems, as you would dream. * Slowly, everything will be dark and calm. You died...");
        DisplayLists.displayPlayerInventory(mainCharacter);
        Printer.printPage("You can restart the game with ctrl+R!");
        running = false;
    }

    public boolean quizAB() {
        String answer = InputScanner.getInput("Please type [A] or [B]: ").toLowerCase();
        while(!answer.equals("a") && !answer.equals("b")) {
            Printer.printNarrative("Wrong letters, please type [A] or [B]!");
            answer = InputScanner.getInput("Please type [A] or [B]: ").toLowerCase();
        }

        if(answer.equals("a")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean quizNumber() {

        String answer = InputScanner.getInput("Please write your answer here: ");
        boolean isNumber;

        try {
            Integer.parseInt(answer);
            isNumber = true;
        } catch(NumberFormatException e) {
            isNumber = false;
        }

        while(!isNumber) {
            Printer.printNarrative("Hey! It wasn´t a number! Try again!");
            answer = InputScanner.getInput("Please enter a number here: ").toLowerCase();
        }

        if(Integer.parseInt(answer) < 35) {
            return true;
        } else {
            return false;
        }
    }

    public void inThePub() {
        Printer.printPage("You are in the pub... it is dark and smokey inside. Somebody plays ragtime on the piano. " +
                "You are starting to look for Samey. But you can`t find him.");
        Choices.printOptions("Do you want to ask somebody, where Samey is?", "Yes", "No");
        String choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        while (!choice.equals("a") && !choice.equals("b")) {
            Choices.printOptions("Do you want to ask somebody, where Samey is?", "Yes", "No");
            choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        }
        if (choice.equals("a")) {
            Printer.printPage("YOU: 'Excuse me, sir? Did you saw Samey somewhere? Where can I find him?' * " +
                    "STRANGER: 'Aoeeehh... bloooa.. brlkkkk... I.. I donut... do not know, where he is...* " +
                    "But I can.. I can remember, that... hukkk... * Öhhmm, sorry.... Bloaaaaa...");
            Choices.printOptions("You couldn`t find Samey. You have to search further!",
                    "Go to the ancient oak", "Search Samey in the pub",
                    "Go to the blacksmith`s hall", "Go to the beautiful, young gipsy witch");
            destination = InputScanner.getInput("Choose a destination, where Samey could be: ").toLowerCase();
        } else {
            Printer.printPage("You look around you, and you don`t feel well. Is Samey here? Who knows, " +
                    "but you think, he may be somewhere else.");
            Choices.printOptions("Go, find Samey finally!", "Go to the ancient oak",
                    "Search Samey in the pub",
                    "Go to the blacksmith`s hall", "Go to the beautiful, young gipsy witch");
            destination = InputScanner.getInput("Choose a destination, where Samey could be: ").toLowerCase();
        }
    }

    public void atTheBlacksmith() {
        Printer.printPage("Chinnn...Chinnn...Chinnn... The blacksmith works hard and can barely hear you, as you " +
                "talk to him. * He doesn`t have any time for you. But you hit him with your wrist. * " +
                "'What the fuck are you doing? Are you stupid, you little bastard? I`ll kill you, if you touch me once " +
                "again!' * 'Sorry, my apologies, I just want to find the Samey guy. May you know, where he might be? * " +
                "'You little filthy bastard. I have know idea, where he could be. * But I heard, he is a very strange " +
                "guy... * You better pay attention and don`t make any business with him... * " +
                "He often goes to that witch, I heard. * I can just assume, what he makes with that bitch...");
        Choices.printOptions("Do you believe the blacksmith?", "Yes, go to the witch", "No, I think, this game doesn`t make any sense. I want to leave now");
        String choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        while (!choice.equals("a") && !choice.equals("b")) {
            Choices.printOptions("Do you believe the blacksmith?", "Yes, go back to the menu, I go there",
                    "No, I think, this game doesn`t make any sense. I want to leave now");
            choice = InputScanner.getInput("Please choose from [A] and [B]: ").toLowerCase();
        }
        if (choice.equals("a")) {
            Choices.printOptions("Welcome back, I heard you want to go to the witch. ;)",
                    "Go to the ancient oak", "Search Samey in the pub",
                    "Go to the blacksmith`s hall", "Go to the beautiful, young gipsy witch");
            destination = InputScanner.getInput("Choose a destination, where Samey could be: ").toLowerCase();
        } else {
           Printer.printPage("I am disappointed, that you leave so soon. Come back and explore more stories!");
           System.exit(0);
        }
    }

    public void atTheWitch() {
        Printer.printPage("(Distant, indian music swims in the ear...) You arrived to the tent of the beautiful, " +
                "young witch. * 'What can I do for you, sweetie?' * 'Oahmmm, khmm.... Hi, my name is " +
                mainCharacter.getName() + ", I am searching for a guy, named Samey.' * In this moment, a huge, " +
                "black guy jumps out of the tent and runs away. * You follow him, finally, he stops, and says: * " +
                "'What do you want from me? Who are you?' * 'The old hunter sent me to find you. We need the key, to " +
                "the ammo shop. * We need weapons.' * 'Ahh, that`s why... Alright... here is the key. Take it.'");
        mainCharacter.increaseAttack(15);
        Printer.printPage("Congratulation " + mainCharacter.getName() + ", you received 15 attack points! Your current attack points are: " +
                mainCharacter.getAttack());
        Printer.printNarrative("Please push [R] to return to the old hunter");
        String returnInput = InputScanner.getInput("Push [R] to return to the house: ").toLowerCase();
        while (!returnInput.equals("r")) {
            Printer.printSimpleText("Wrong letter, you need to type [R] to go back to the old hunter!");
            returnInput = InputScanner.getInput("Push [R] to return to the house: ").toLowerCase();
        }

        if (returnInput.equals("r")) {
            pages.printPage3();
            String follow = InputScanner.getInput("Follow the old hunter by typing [f]: ").toLowerCase();
            while (follow.length() != 25) {
                Printer.printNarrative("You lost the hunter! Type letter [f] 25 times to follow the hunter and " +
                        "get to the ammo shop!");
                follow = InputScanner.getInput("Follow the old hunter by typing [f]: ");
            }
            if (follow.length() == 25) {
                Printer.printPage("'Finally, " + mainCharacter.getName() + "! We are here! We have to get in.' * " +
                        "'Brrr, it is freezing cold... Do you have some rum for me, John?' * 'Did you lost your mind? " +
                        "We don`t have time for such things. * Help me open the door! Here is the key!'");
                Printer.printNarrative("Help him, you can`t fail. Open the door!");
                String open = InputScanner.getInput("Type 'open' to open the door: ").toLowerCase();
                while(!open.equals("open")) {
                    Printer.printNarrative("Wrong word. Type 'open' to use the key!");
                }
                if(open.equals("open")) {
                    Shop ammoShop = new Shop(mainCharacter);
                    ammoShop.enter();
                }
                running = false;
            }
        }
    }
}
