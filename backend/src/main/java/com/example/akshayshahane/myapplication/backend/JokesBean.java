package com.example.akshayshahane.myapplication.backend;

import com.example.JokeProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokesBean {

    private JokeProvider mJokeProvider;

    public JokesBean() {
        mJokeProvider = new JokeProvider();
    }

    public String getJoke(){

        return mJokeProvider.getRandomJoke();
    }
}