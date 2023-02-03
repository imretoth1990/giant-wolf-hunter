package com.codecool.chapters.chapter1_B.service;

import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class Pages1_B {
    public static void printPage1() {
        Printer.printPage("'Hey John, thank God you're at home! Come, I need help right now. * " +
                "There's an unseen emergency reported by the Gossipy Mary living next to the village pub. * " +
                "There's no time for more explanation, just grab your wolf traps and some rum.'");
        Printer.printPage("'Slowly, slowly, young man, i don`t even know your name. * Who are you?'");
    }

    public static void printPage2(String name) {
        Printer.printPage("Nice to meet you, " + name + ". I`m glad, you`ve found me. The gods sent you. " +
                "Come in, it`s dangerous outside. I need to talk to you about the legend of the giant white wolf.");
        Printer.printNarrative("Upon hearing about the legend of the wolf, * your rune stone, that you carry around " +
                "on your neck starts glowing. * " +
                "You're scared but excited. You can feel deep inside, the the big battle with the wolf is finally approaching.");
        Printer.printPage("'So, my son... I think, we should better prepare for the battle. * Do you know, " +
                "where the little Samey lives? You need to talk to him, we need a key from him to the ammo shop. * " +
                "We need weapons!");
    }

    public static void printPage3() {
        Printer.printPage("Ohhhh, you returned, my son! Very well... Give me the key, we have to be silent " +
                "and fast, as a fox. So, follow me... ");
        Printer.printNarrative("Type letter [f] 25 times to follow the hunter and get to the ammo shop!");
    }
}
