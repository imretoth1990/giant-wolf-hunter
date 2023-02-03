package com.codecool.chapters;

import org.apache.commons.lang3.StringUtils;

public class BackgroundStory {
    public static void printStory(int width) {
        System.out.println("*".repeat(width));
        System.out.println("");
        System.out.println(StringUtils.center("THE BACKGROUND STORY", width));
        System.out.println("");
        System.out.println(StringUtils.center("There was once a little village near a dark wood in the Appalache Mountains.", width));
        System.out.println(StringUtils.center("In a small hut, lived the lonely hunter who wanted to hunt down a rabid wolf.", width));
        System.out.println(StringUtils.center("This story is about the battle between the giant white wolf and the hunter.", width));
        System.out.println(StringUtils.center("It is in your hands, who succeeds.", width));
        System.out.println(StringUtils.center("You are a young hunter and your mother was once a good friend of the old hunter, John.", width));
        System.out.println(StringUtils.center("You came to the village to get to know the old hunter and help to him to fulfill the destiny of the evil wolf.", width));
        System.out.println("");
        System.out.println("*".repeat(width));
    }
}
