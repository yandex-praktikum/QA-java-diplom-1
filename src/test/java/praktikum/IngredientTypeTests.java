package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private final String type;
    private final int expectedNumber;

    public IngredientTypeTests(String type, int expectedNumber){
        this.type = type;
        this.expectedNumber = expectedNumber;}

    @Parameterized.Parameters
    public static Object[][] getTypes(){
        return new Object[][]{
                {"SAUCE", 0},
                {"FILLING", 1}
        };
    }
    @Test
    public void enumContainTypeTest(){
        int actualNumber = IngredientType.valueOf(IngredientType.class, type).ordinal();
        Assert.assertEquals(expectedNumber, actualNumber);
    }
}
