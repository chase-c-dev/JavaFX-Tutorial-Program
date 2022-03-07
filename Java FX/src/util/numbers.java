package util;

import helloworld.main;

public class numbers extends main {

        public Integer genrandom(int input1, int input2) { //generates random number in interval

            int total = (int) Math.floor(Math.random()*(input2-input1+1)+input1); //
            return total; //returns random number
        }
}

