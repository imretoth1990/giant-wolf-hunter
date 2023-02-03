package com.codecool.chapters.chapter3_shop;

import com.codecool.data.GameCharacter;
import com.codecool.service.InputScanner;
import com.codecool.service.Printer;

import java.util.IllegalFormatConversionException;
import java.util.Random;

public class Work {

    public GameCharacter gameCharacter;

    public Work(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }


    public void showTask() {

        Random r = new Random();
        int low = 10;
        int high = 21;
        int coefficient1 = r.nextInt(high-low) + low;
        int coefficient2 = r.nextInt(high-low) + low;


        String question = String.format("Whats the product of %d * %d? ", coefficient1, coefficient2);


        String userAnswer = InputScanner.getInput(question);

        int convertedAnswerValue = 0;

        try {
            int buffer = Integer.valueOf(userAnswer);
            convertedAnswerValue = buffer;
        } catch (IllegalFormatConversionException e) {
            wrongAnswer();
        }



        int secretNumber = coefficient1 * coefficient2;

        if (convertedAnswerValue == secretNumber) {
            goodAnswer();
        } else {
            wrongAnswer();
        }
    }


    private void wrongAnswer() {
        Printer.printSimpleText("Wrong answer, you lost 50 coins");
        gameCharacter.decreaseCoins(50);
        Printer.printSimpleText(String.format("You have now %d coins.", gameCharacter.getCoins()));
    }

    private void goodAnswer() {
        Printer.printSimpleText("Good answer, you earned 30 coins");
        gameCharacter.increaseCoins(30);
        Printer.printSimpleText(String.format("You have now %d coins.", gameCharacter.getCoins()));
    }
}
