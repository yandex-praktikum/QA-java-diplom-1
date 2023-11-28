package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientTypeTest {

    @Test
    public void containsOnlySauceAndFilling() {

        List<IngredientType> expected = new ArrayList<IngredientType>();
        expected.add(IngredientType.SAUCE);
        expected.add(IngredientType.FILLING);

        List<IngredientType> result = Arrays.asList(IngredientType.values());
        int size = result.size();

        Assert.assertEquals(2,size);
        Assert.assertTrue(result.containsAll(expected));

    }

}