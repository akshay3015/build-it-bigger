package com.example.akshayshahane.myapplication.backend;

import com.example.JokeProvider;

/**
 * The object model for the data we are sending through endpoints
 *  Reference : https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints

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