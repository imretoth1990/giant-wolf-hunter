package com.codecool.chapters.chapter2.service;

import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

public class Pages2 {

    public void printPage1() {
        Printer.printPage("''Ohh, a very special choice. I use the old recipe of my grandmother. * Please, " +
                "take a sit in the main hall until i bring you your drink'.");
        Printer.printNarrative("You are sitting on the couch and you recognise the big black book on the " +
                "small table near the rocking chair.");
        Printer.printPage("'Hmm... I`m sure that is the book about the legend...'.");
        Printer.printNarrative("You would grab it, but the old hunter comes back and says: ");
        Printer.printPage("'Here it is, my son, your drink. Enjoy it!' * 'Thank you, John!'");
        Printer.printNarrative("You drink the magic juice and suddenly you see a dream where a huge white wolf killing " +
                "people in the village.");
        Printer.printPage("'It`s just the juice. If you drink from it, you will see the legendary story of " +
                "the wolf with your own eyes!'");
    }

    public void printPage2VersionA() {
        Printer.printPage("'Ok, drink it! Now! We don´t have much "+
        "time, we have to prepare for the battle!'");
        Printer.printNarrative("You drink the whole drink and suddenly, you are laying " +
                "on the couch. * You don`t understand what happened.");
        Printer.printPage("'I see, you are week, my son. * You can`t handle such a magic juice yet. * " +
                " I´m not sure, that you should come with me to hung down the giant wolf.'");
    }
    public void printPage2VersionB() {
        Printer.printPage("'Ok, my son. It`s okay, no problem. * " +
                "Come, we have to go somewhere, to prepare for the battle. * We need some weapon!'");
    }

    public void printPage3VersionA() {
        Printer.printPage("'Than come, jung man! * We are going to collect some necessary equipment for the battle!'");
    }

    public void printPage3VersionB() {
        Printer.printPage("'Ok, there is a room behind the kitchen. You can sleep there. * " +
                "We will see us tomorrow. But pay attention, the wolf can return to the village every time. * " +
                "You should be alert even in you dreams! Have a good night...'");
        Printer.printNarrative("You are preparing yourself for sleeping. * But as you would lay down to the bed, " +
                "you hear some strange noise, coming from the woods.");
        Printer.printPage("'It`s him! It`s the wolf! * We should go somewhere immediately, we need weapons! * " +
                "Prepare yourself, prepare for battle!'");
    }



}
