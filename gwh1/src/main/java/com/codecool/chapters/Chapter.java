package com.codecool.chapters;

import com.codecool.chapters.chapter1.service.Pages1;
import com.codecool.data.GameCharacter;

public abstract class Chapter {
    GameCharacter supportingCharacter;
    GameCharacter mainCharacter;

    public Chapter(GameCharacter support, GameCharacter main) {
        this.supportingCharacter = support;
        this.mainCharacter = main;
    }

    public GameCharacter getSupportingCharacter() {
        return supportingCharacter;
    }

    public GameCharacter getMainCharacter() {
        return mainCharacter;
    }

    abstract public void runChapter();
}
