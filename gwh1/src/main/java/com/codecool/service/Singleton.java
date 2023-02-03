package com.codecool.service;

import com.codecool.data.GameCharacter;

public class Singleton {
    public static volatile Singleton instance;
    public GameCharacter gameCharacter;

    public Singleton(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public static Singleton getInstance(GameCharacter gameCharacter) {
        Singleton result = instance;

        if(result == null) {
            synchronized (Singleton.class) {
                result = instance;

                if (result == null) {
                    instance = result = new Singleton(gameCharacter);
                }
            }
        }
        return result;
    }
}
