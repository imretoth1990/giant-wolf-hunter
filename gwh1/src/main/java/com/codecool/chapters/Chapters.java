package com.codecool.chapters;

import com.codecool.chapters.chapter1.Chapter1;
import com.codecool.data.GameCharacter;
public class Chapters {
    // Logic
    public static void runChapters(GameCharacter support, GameCharacter main) {
        // Chapter 1
        Chapter1 chapter1 = new Chapter1(support, main);
        chapter1.runChapter1();
    }
}
