package com.example;

import java.util.Random;

public class JokeProvider {


    private static Random mRandom = new Random();

    private static String[] jokes = {
            "How many programmers does it take to change a light bulb?\n" +
                    "None – It’s a hardware problem" ,
            "There are only 10 kinds of people in this world: those who know binary and those who don’t.",
            "Why is it that women find C to be more attractive than Java?\n" +
                    "Because C doesn’t treat them like objects.",
            "Why do Java programmers wear glasses?\n" +
                    "Because they don’t C#!",
            "In order to understand recursion you must first understand recursion.\n"


    };


    public static String getRandomJoke(){


        return jokes[mRandom.nextInt(jokes.length)];
    }

}
