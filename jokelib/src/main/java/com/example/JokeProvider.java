package com.example;

import java.util.Random;

public class JokeProvider {
    private static final String[] jokes = {
            "Police officer talks to a driver: Your tail light is broken, your tires must be exchanged and your bumper hangs halfway down. That will be 300 dollars.\n" + "Driver: Alright, go ahead. They want twice as much as that at the garage.",
            "Why did the physics teacher break up with the biology teacher? There was no chemistry.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "I forgot my cell phone when I went to the toilet yesterday. We have 245 tiles.",
            "I’ve always thought my neighbors were quite nice people. But then they put a password on their Wi-Fi.",
            "There are more English speakers in China than in the United States.",
            "The struggle is real for the ferret – if a female ferret in heat doesn’t find a mate, she can die.",
            "In the USA, there are more Chinese restaurants than all the McDonald’s, KFCs, Burger Kings and Wendy’s put together.",
            "How can you tell you have a really bad case of acne?\n" + "It’s when the blind try to read your face.",
            "Boy complains to his father: You told me to put a potato in my swimming trunks! You said it would impress the girls at the pool! But you forgot to mention one thing! \n" + "\n" + "Father: Really, what?\n" + "\n" + "Boy: That the potato should go in the front."
    };

    public static String getJoke() {
        int size = jokes.length;

        Random r = new Random();
        int index = r.nextInt(size);

        return jokes[index];
    }

}
