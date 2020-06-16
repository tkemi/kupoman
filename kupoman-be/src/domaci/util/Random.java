package domaci.util;

import java.util.UUID;

public class Random {
    public static String getRandomUID(){
        return UUID.randomUUID().toString();
    }
}