package praktikum;

import java.util.Random;

public class DataManager {
    private final String [] standartStrings = {"0", "So_MaNy_UndeRScoreS___!", "Correct String", "noNullElement", "BunName", "One More Bun Name", "not empty string"};
    private final float [] standartFloats = {0f, 1.0f, 5.39362719283f, -9.754f, 10001939f, -8392983902f, 0.00000000005f};
    public String getAnyString(){
        return standartStrings[new Random().nextInt(standartStrings.length)];
    }
    public float getAnyFloat(){
        return standartFloats[new Random().nextInt(standartFloats.length)];
    }
}
