package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IngredientTypeTest {

    @Test
    public void checkIngredientsTypeTest() {
        Set<IngredientType> set = new HashSet<>(Arrays.asList(IngredientType.values()));
        set.remove(IngredientType.FILLING);
        set.remove(IngredientType.SAUCE);
        Assert.assertTrue(set.isEmpty());
    }

}
