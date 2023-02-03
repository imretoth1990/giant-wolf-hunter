package com.codecool.service;

import com.codecool.data.GameCharacter;

public class Singleton {
    private static Singleton instance;
    private GameCharacter gameCharacter;

    /*private Singleton(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }*/

    public GameCharacter getGameCharacter() {
        return instance.getGameCharacter();
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        instance.gameCharacter = gameCharacter;
    }

    public static Singleton getInstance() {
        /*Singleton result = instance;

        if(result == null) {
            synchronized (Singleton.class) {
                result = instance;

                if (result == null) {
                    instance = result = new Singleton(gameCharacter);
                }
            }
        }
        return result;*/
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}
